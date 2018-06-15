package com.xunyu.operator.controller;

import com.commons.core.message.Result;
import com.commons.core.message.ResultMessage;
import com.google.common.collect.Maps;
import com.xunyu.config.redis.RedisUtil;
import com.xunyu.model.operator.out.GatewayOutConfigModel;
import com.xunyu.model.user.User;
import com.xunyu.operator.pojo.access.OperAccessCoreConfig;
import com.xunyu.operator.pojo.out.CarrierAgree;
import com.xunyu.operator.pojo.out.Customer;
import com.xunyu.operator.service.access.OperAccessService;
import com.xunyu.operator.service.out.CarrierAgreeService;
import com.xunyu.operator.service.out.CustomerService;
import com.xunyu.operator.service.out.GatewayOutConfigService;
import com.xunyu.operator.vo.out.GatewayOutConfigListVO;
import com.xunyu.operator.vo.out.GatewayOutConfigVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author xym
 * @description 网关接出配置（SP接入到运营商） 控制器
 * @date 2018/6/12 11:58
 */
@RestController
@RequestMapping("/outConfig")
public class GatewayOutConfigController {

    private static final Integer YES = 1;
    private static final Integer NO = 0;

    private Logger logger = LoggerFactory.getLogger(GatewayOutConfigController.class);

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private OperAccessService operAccessService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CarrierAgreeService carrierAgreeService;

    @Autowired
    private GatewayOutConfigService gatewayOutConfigService;

    /**
     * 提供进入详情页面时需要的信息
     * 1、提供企业用户的选择项
     * 2、网关节点的选择项
     * 3、协议类型的选择项
     *
     * 需要参数：选择的运营商id
     */
    @RequestMapping(value = "/firstComeInDetail")
    @ResponseBody
    public Result<GatewayOutConfigVO> firstComeInDetail(GatewayOutConfigModel model){
        User user = redisUtil.getCurrUser(model.getSessionId());
        Result<GatewayOutConfigVO> result = checkLogin(new Result(),user);
        if (result.getMessage() != null){
            return result;
        }
        GatewayOutConfigVO config = new GatewayOutConfigVO();
        Map map = Maps.newHashMap();
        map.put("startRow", 0);
        map.put("endRow", Long.MAX_VALUE);
        List<OperAccessCoreConfig> operAccessCoreConfigList = operAccessService.listOperAccessCoreConfig(map) ;
        if (operAccessCoreConfigList != null && operAccessCoreConfigList.size() > 0){
            config.setOperAccessCoreConfigList(operAccessCoreConfigList);
        }
        List<Customer> customerList = customerService.selectCustomerList();
        if (customerList != null && customerList.size() > 0) {
            config.setCustomerList(customerList);
        }
        List<CarrierAgree> carrierAgreeList = carrierAgreeService.selectCarrierAgree(model.getCarrierType());
        if (carrierAgreeList != null && carrierAgreeList.size() > 0){
            config.setCarrierAgreeList(carrierAgreeList);
        }
        result.setCode(ResultMessage.Code.SUCCESS);
        result.setMessage(ResultMessage.Message.SUCCESS);
        result.setRes(config);
        return result;
    }
    /**
     * 提供第一次进入列表页面时需要的数据
     * 1、网关列表
     * 2、归属业务
     * @param model
     * @return
     */
    @RequestMapping(value = "/firstComeInList")
    @ResponseBody
    public Result<GatewayOutConfigListVO> firstComeInListPage(GatewayOutConfigModel model){
        User user = redisUtil.getCurrUser(model.getSessionId());
        Result<GatewayOutConfigListVO> result = checkLogin(new Result(),user);
        if (result.getMessage() != null){
            return result;
        }
        GatewayOutConfigListVO vo = new GatewayOutConfigListVO();
        //通过运营商类型查询网关列表
        Integer carrierType = model.getCarrierType();
        Map map = Maps.newHashMap();
        map.put("startRow", 0);
        map.put("endRow", Long.MAX_VALUE);
        map.put("isabled", YES);
        map.put("agreeType",carrierType);
        List<OperAccessCoreConfig> coreConfigs = operAccessService.listOperAccessCoreConfig(map);
        vo.setOperAccessCoreConfigList(coreConfigs);
        //TODO 查询归属业务人员 放置到vo中
        return result;
    }

    /**
     * 新增配置
     * @param model
     * @return
     */
    @RequestMapping(value = "/addConfig")
    @ResponseBody
    public Result addConfig(GatewayOutConfigModel model)  {
        User user = redisUtil.getCurrUser(model.getSessionId());
        Result result = checkLogin(new Result(),user);
        if (result.getMessage() != null){
            return result;
        }
        //判空
        checkBlank(result,model);
        //校验：自定义企业代码,系统内必须唯一，否则提交失败
        String enterCode = model.getEnterpriseCode();
        int count = gatewayOutConfigService.selectCountByEnterpriseCode(enterCode);
        if (count > 0 ){
            result.setCode(ResultMessage.Code.FAILED);
            result.setMessage("企业代码已存在，请重新编辑后提交");
            return result;
        }
        //校验：自定义企业网关接入码，前缀必须跟网关节点的接入码一致，否则会提交不成功
        String gatewayAccessCode = model.getGatewayAccessCode();
        boolean checkGatewayAccessCode = gatewayAccessCode.startsWith(model.getAccessCode());
        if (!checkGatewayAccessCode){
            result.setCode(ResultMessage.Code.FAILED);
            result.setMessage("网关接入码前缀与网关节点不一致，请重新编辑后提交");
            return result;
        }
        model.setOperatorId(user.getUserId().intValue());
        model.setIsabled(YES);
        model.setCreateTime(new Date());

        int insertSuccess = gatewayOutConfigService.insertGatewayOutConfig(model);
        if (insertSuccess > 0){
            result.setCode(ResultMessage.Code.SUCCESS);
            result.setMessage(ResultMessage.Message.SUCCESS);
        }else {
            result.setCode(ResultMessage.Code.FAILED);
            result.setCode(ResultMessage.Message.FAILED);
        }
        return result;
    }

    /**
     * 查询列表
     * @param model
     * @return
     */
    @RequestMapping(value = "/getConfigList")
    @ResponseBody
    public Result<List<GatewayOutConfigListVO>> getGatewayOutListConfig(GatewayOutConfigModel model){
        User user = redisUtil.getCurrUser(model.getSessionId());
        Result result = checkLogin(new Result(),user);
        if (result.getMessage() != null){
            return result;
        }
        int currPage = model.getCurrPage();
        if (currPage == 0){
            result.setMessage(ResultMessage.Message.PRAMA_LOSS);
            result.setCode(ResultMessage.Code.PRAMA_LOSS);
            return result;
        }
        model.setOffset(model.getStartRows());
        int totalRows = gatewayOutConfigService.selectConfigListCount(model);
        List<GatewayOutConfigListVO> list = gatewayOutConfigService.selectConfigList(model);
        if (list != null && list.size() > 0){
            result.setCode(ResultMessage.Code.SUCCESS);
            result.setMessage(ResultMessage.Message.SUCCESS);
            result.setRes(list);
            result.setTotalRows(totalRows);
        }else {
            result.setCode(ResultMessage.Code.SUCCESS);
            result.setMessage(ResultMessage.Message.NO_VALUE);
        }
        return result;
    }

    /**
     * 删除
     * @param model
     * @return
     */
    @RequestMapping(value = "/deleteConfig")
    @ResponseBody
    public Result<String> deleteGatewayOutConfig(GatewayOutConfigModel model){
        User user = redisUtil.getCurrUser(model.getSessionId());
        Result result = checkLogin(new Result(),user);
        if (result.getMessage() != null){
            return result;
        }

        return null;
    }


    /**
     * 检查是否登录或会话是否过期
     * @param result
     * @param user
     * @return
     */
    private Result checkLogin(Result result,User user){
        if(user == null){
            result.setCode(ResultMessage.Code.NOT_FOUND);
            result.setMessage(ResultMessage.Message.UN_LOGIN);
        }
        return result;
    }


    /**
     * 判断参数是否为空
     * @param result
     * @param model
     * @return
     */
    private Result checkBlank(Result result, GatewayOutConfigModel model){
        //企业用户、企业代码、接入类型、协议类型、网关节点、网关接入码、企业Ip、企业密码、网关接入码、赋给SP接入码、上行短信接入码
        if (model.getCustomerId() == null || model.getCustomerId() == 0){
            result.setCode(ResultMessage.Code.PRAMA_LOSS);
            result.setMessage("企业用户不可为空，请重新填写后提交");
            return result;
        }
        if (model.getEnterpriseCode() == null || model.getEnterpriseCode() == ""){
            result.setCode(ResultMessage.Code.PRAMA_LOSS);
            result.setMessage("企业代码不可为空，请重新填写后提交");
            return result;
        }
        if (model.getAccessType() == null || model.getAccessType() == 0){
            result.setCode(ResultMessage.Code.PRAMA_LOSS);
            result.setMessage("接入类型不可为空，请重新填写后提交");
            return result;
        }
        if (model.getAgreeType() == null || model.getAgreeType() == 0){
            result.setCode(ResultMessage.Code.PRAMA_LOSS);
            result.setMessage("协议类型不可为空，请重新填写后提交");
            return result;
        }
        if (model.getAccessCode() == null || model.getAccessCode() == ""){
            result.setCode(ResultMessage.Code.PRAMA_LOSS);
            result.setMessage("网关节点接入码不可为空，请重新填写后提交");
            return result;
        }
        if (model.getConfigId() == null){
            result.setCode(ResultMessage.Code.PRAMA_LOSS);
            result.setMessage("网关节点不可为空，请重新填写后提交");
            return result;
        }
        if (model.getEnterpriseIp() == null || model.getEnterpriseIp() == ""){
            result.setCode(ResultMessage.Code.PRAMA_LOSS);
            result.setMessage("企业ip不可为空，请重新填写后提交");
            return result;
        }
        if (model.getEnterprisePwd() == null || model.getEnterprisePwd() == ""){
            result.setCode(ResultMessage.Code.PRAMA_LOSS);
            result.setMessage("企业密码不可为空，请重新填写后提交");
            return result;
        }
        if (model.getGatewayAccessCode() == null || model.getGatewayAccessCode() == ""){
            result.setCode(ResultMessage.Code.PRAMA_LOSS);
            result.setMessage("网关接入码不可为空，请重新填写后提交");
            return result;
        }
        if (model.getSpAccessCode() == null || model.getSpAccessCode() == ""){
            result.setCode(ResultMessage.Code.PRAMA_LOSS);
            result.setMessage("赋给sp接入码不可为空，请重新填写后提交");
            return result;
        }
        if (model.getMsgAccessCode() == null || model.getMsgAccessCode() == ""){
            result.setCode(ResultMessage.Code.PRAMA_LOSS);
            result.setMessage("上行短信接入码不可为空，请重新填写后提交");
            return result;
        }
        //短信长度限制、SP长短信额外可发字数、是否ASCII支持	、号码是否需要86、是否去签名发送、MO模式、MO网关ID、报告消息ID模式
        //下发流量门限、报告回复推送流量门限、是否启用、付费模式
        if (model.getSpMsgLenLimit() == null ){
            result.setCode(ResultMessage.Code.PRAMA_LOSS);
            result.setMessage("短信长度限制不可为空，请重新填写后提交");
            return result;
        }if (model.getLongMsgExtraNum() == null ){
            result.setCode(ResultMessage.Code.PRAMA_LOSS);
            result.setMessage("SP长短信额外可发字数不可为空，请重新填写后提交");
            return result;
        }if (model.getIsAscllSupported() == null ){
            result.setCode(ResultMessage.Code.PRAMA_LOSS);
            result.setMessage("是否ASCII支持不可为空，请重新填写后提交");
            return result;
        }if (model.getIsNeedPrefix() == null){
            result.setCode(ResultMessage.Code.PRAMA_LOSS);
            result.setMessage("号码是否需要86不可为空，请重新填写后提交");
            return result;
        }if (model.getIsSendWithoutSign() == null){
            result.setCode(ResultMessage.Code.PRAMA_LOSS);
            result.setMessage("是否去签名发送不可为空，请重新填写后提交");
            return result;
        }if (model.getMoPattern() == null ){
            result.setCode(ResultMessage.Code.PRAMA_LOSS);
            result.setMessage("MO模式不可为空，请重新填写后提交");
            return result;
        }if (model.getReportMsgType() == null){
            result.setCode(ResultMessage.Code.PRAMA_LOSS);
            result.setMessage("报告消息ID模式不可为空，请重新填写后提交");
            return result;
        }if (model.getSendFlowThreshold() == null ){
            result.setCode(ResultMessage.Code.PRAMA_LOSS);
            result.setMessage("下发流量门限不可为空，请重新填写后提交");
            return result;
        }if (model.getReplyFlowThreshold() == null ){
            result.setCode(ResultMessage.Code.PRAMA_LOSS);
            result.setMessage("报告回复推送流量门限不可为空，请重新填写后提交");
            return result;
        }if (model.getIsUsed() == null ){
            result.setCode(ResultMessage.Code.PRAMA_LOSS);
            result.setMessage("是否启用不可为空，请重新填写后提交");
            return result;
        }if (model.getPayType() == null || model.getPayType() == 0){
            result.setCode(ResultMessage.Code.PRAMA_LOSS);
            result.setMessage("付费模式不可为空，请重新填写后提交");
            return result;
        }
        //押金、费率、在线充值起充条数、是否启用在线充值、质押条数、信用率、审核模式、优先级、最大连接数、是否强制签名、签名内容
        if (model.getDeposit() == null ){
            result.setCode(ResultMessage.Code.PRAMA_LOSS);
            result.setMessage("押金不可为空，请重新填写后提交");
            return result;
        }if (model.getRate() == null ){
            result.setCode(ResultMessage.Code.PRAMA_LOSS);
            result.setMessage("费率不可为空，请重新填写后提交");
            return result;
        }if (model.getRechargeNumLimit() == null ){
            result.setCode(ResultMessage.Code.PRAMA_LOSS);
            result.setMessage("在线充值起充条数不可为空，请重新填写后提交");
            return result;
        }if (model.getIsOnlineRechargeUsed() == null ){
            result.setCode(ResultMessage.Code.PRAMA_LOSS);
            result.setMessage("是否启用在线充值不可为空，请重新填写后提交");
            return result;
        }if (model.getPledgeNum() == null ){
            result.setCode(ResultMessage.Code.PRAMA_LOSS);
            result.setMessage("质押条数不可为空，请重新填写后提交");
            return result;
        }if (model.getPriority() == null){
            result.setCode(ResultMessage.Code.PRAMA_LOSS);
            result.setMessage("优先级不可为空，请重新填写后提交");
            return result;
        }if (model.getAuditType() == null){
            result.setCode(ResultMessage.Code.PRAMA_LOSS);
            result.setMessage("审核模式不可为空，请重新填写后提交");
            return result;
        }if (model.getMaxConnectNum() == null){
            result.setCode(ResultMessage.Code.PRAMA_LOSS);
            result.setMessage("最大连接数不可为空，请重新填写后提交");
            return result;
        }if (model.getIsForcedSign() == null){
            result.setCode(ResultMessage.Code.PRAMA_LOSS);
            result.setMessage("是否强制签名不可为空，请重新填写后提交");
            return result;
        }if (YES.equals(model.getIsForcedSign()) && (model.getSignContent() == null || model.getSignContent() =="")){
            result.setCode(ResultMessage.Code.PRAMA_LOSS);
            result.setMessage("签名内容不可为空，请重新填写后提交");
            return result;
        }
        //签名位置、是否必须签名、审核条数、是否启用黑名单、是否启用白名单、是否启用系统级强制红、白名单	、是否启用网关关键字拦截
        if (model.getSignLocation() == null){
            result.setCode(ResultMessage.Code.PRAMA_LOSS);
            result.setMessage("签名位置不可为空，请重新填写后提交");
            return result;
        }if (model.getIsMustSign() == null){
            result.setCode(ResultMessage.Code.PRAMA_LOSS);
            result.setMessage("是否必须签名不可为空，请重新填写后提交");
            return result;
        }if (model.getAuditNum() == null){
            result.setCode(ResultMessage.Code.PRAMA_LOSS);
            result.setMessage("审核条数不可为空，请重新填写后提交");
            return result;
        }if (model.getIsUseBlacklist() == null){
            result.setCode(ResultMessage.Code.PRAMA_LOSS);
            result.setMessage("是否启用黑名单不可为空，请重新填写后提交");
            return result;
        }if (model.getIsUseWhitelist() == null){
            result.setCode(ResultMessage.Code.PRAMA_LOSS);
            result.setMessage("是否启用白名单不可为空，请重新填写后提交");
            return result;
        }if (model.getIsUseSysRedlistWhitelist() == null){
            result.setCode(ResultMessage.Code.PRAMA_LOSS);
            result.setMessage("是否启用系统级强制红、白名单不可为空，请重新填写后提交");
            return result;
        }if (model.getIsUseKeywordIncpt() == null){
            result.setCode(ResultMessage.Code.PRAMA_LOSS);
            result.setMessage("是否启用网关关键字拦截不可为空，请重新填写后提交");
            return result;
        }
        //SP长短信组包方式、是否自动返还、下发接入号超长是否截断、业务最低销售成本	、业务销售实际价格、业务销售提成比例、是否启用平台处理
        if (model.getLongMsgPackType() == null){
            result.setCode(ResultMessage.Code.PRAMA_LOSS);
            result.setMessage("SP长短信组包方式不可为空，请重新填写后提交");
            return result;
        }if (model.getIsAutoReturn() == null){
            result.setCode(ResultMessage.Code.PRAMA_LOSS);
            result.setMessage("是否自动返还不可为空，请重新填写后提交");
            return result;
        }if (model.getIsIncptLongAccessCode() == null){
            result.setCode(ResultMessage.Code.PRAMA_LOSS);
            result.setMessage("下发接入号超长是否截断不可为空，请重新填写后提交");
            return result;
        }if (model.getMinSaleCost() == null){
            result.setCode(ResultMessage.Code.PRAMA_LOSS);
            result.setMessage("业务最低销售成本不可为空，请重新填写后提交");
            return result;
        }if (model.getActualSalePrice() == null){
            result.setCode(ResultMessage.Code.PRAMA_LOSS);
            result.setMessage("业务销售实际价格不可为空，请重新填写后提交");
            return result;
        }if (model.getSaleCommissionProp() == null){
            result.setCode(ResultMessage.Code.PRAMA_LOSS);
            result.setMessage("业务销售提成比例不可为空，请重新填写后提交");
            return result;
        }if (model.getIsUsePlatformHandle() == null){
            result.setCode(ResultMessage.Code.PRAMA_LOSS);
            result.setMessage("是否启用平台处理不可为空，请重新填写后提交");
            return result;
        }
        //平台处理比例、平台处理成功报告比例、平台处理成功报告实时比例、平台处理成功报告回传时间、错号空号等成功比例、错号空号等未知比例
        if (model.getPlatformHandleProp() == null){
            result.setCode(ResultMessage.Code.PRAMA_LOSS);
            result.setMessage("平台处理比例不可为空，请重新填写后提交");
            return result;
        }if (model.getHandleRepProp() == null){
            result.setCode(ResultMessage.Code.PRAMA_LOSS);
            result.setMessage("平台处理成功报告比例不可为空，请重新填写后提交");
            return result;
        }if (model.getHandleRepRealtimeProp() == null){
            result.setCode(ResultMessage.Code.PRAMA_LOSS);
            result.setMessage("平台处理成功报告实时比例不可为空，请重新填写后提交");
            return result;
        }if (model.getHandleRepReturnTime() == null){
            result.setCode(ResultMessage.Code.PRAMA_LOSS);
            result.setMessage("平台处理成功报告回传时间不可为空，请重新填写后提交");
            return result;
        }if (model.getWrongNumSucPorp() == null){
            result.setCode(ResultMessage.Code.PRAMA_LOSS);
            result.setMessage("错号空号等成功比例不可为空，请重新填写后提交");
            return result;
        }if (model.getWrongNumUnknowPorp() == null){
            result.setCode(ResultMessage.Code.PRAMA_LOSS);
            result.setMessage("错号空号等未知比例不可为空，请重新填写后提交");
            return result;
        }
        //错误报告转成功比例、是否启用超时改变状态、改变状态超时比例、改变状态超时时间开始、改变状态超时时间结束
        if (model.getWrongReportSucProp() == null){
            result.setCode(ResultMessage.Code.PRAMA_LOSS);
            result.setMessage("错误报告转成功比例不可为空，请重新填写后提交");
            return result;
        }if (model.getIsUseOvertimeChange() == null){
            result.setCode(ResultMessage.Code.PRAMA_LOSS);
            result.setMessage("是否启用超时改变状态不可为空，请重新填写后提交");
            return result;
        }if (model.getChangeOvertimeProp() == null){
            result.setCode(ResultMessage.Code.PRAMA_LOSS);
            result.setMessage("改变状态超时比例不可为空，请重新填写后提交");
            return result;
        }if (model.getChangeOvertimeStartTime() == null){
            result.setCode(ResultMessage.Code.PRAMA_LOSS);
            result.setMessage("改变状态超时时间开始不可为空，请重新填写后提交");
            return result;
        }if (model.getChangeOvertimeEndTime() == null){
            result.setCode(ResultMessage.Code.PRAMA_LOSS);
            result.setMessage("改变状态超时时间结束不可为空，请重新填写后提交");
            return result;
        }
        //是否启用审核关键字、用户号码发送限制条数、是否启用号段分流、是否启用余额短信提醒、余额提醒条数、余额提醒内容、余额提醒间隔
        if (model.getIsUseAuditKeyword() == null){
            result.setCode(ResultMessage.Code.PRAMA_LOSS);
            result.setMessage("是否启用审核关键字不可为空，请重新填写后提交");
            return result;
        }if (model.getUserSendLimit() == null){
            result.setCode(ResultMessage.Code.PRAMA_LOSS);
            result.setMessage("用户号码发送限制条数不可为空，请重新填写后提交");
            return result;
        }if (model.getIsUseNumShunt() == null){
            result.setCode(ResultMessage.Code.PRAMA_LOSS);
            result.setMessage("是否启用号段分流不可为空，请重新填写后提交");
            return result;
        }if (model.getIsUseBalanceNotice() == null){
            result.setCode(ResultMessage.Code.PRAMA_LOSS);
            result.setMessage("是否启用余额短信提醒不可为空，请重新填写后提交");
            return result;
        }if (YES.equals(model.getIsUseBalanceNotice()) && model.getBalNoticeNum() == null ){
            result.setCode(ResultMessage.Code.PRAMA_LOSS);
            result.setMessage("余额提醒条数不可为空，请重新填写后提交");
            return result;
        }if (YES.equals(model.getIsUseBalanceNotice()) && (model.getBalNoticeContent() == null || model.getBalNoticeContent() =="")){
            result.setCode(ResultMessage.Code.PRAMA_LOSS);
            result.setMessage("余额提醒内容不可为空，请重新填写后提交");
            return result;
        }if (YES.equals(model.getIsUseBalanceNotice()) && model.getBalNoticeInterval() == null){
            result.setCode(ResultMessage.Code.PRAMA_LOSS);
            result.setMessage("余额提醒间隔不可为空，请重新填写后提交");
            return result;
        }
        //余额提醒时间、是否启用HTTP接口、是否启用推送
        if ( YES.equals(model.getIsUseBalanceNotice()) && model.getBalNoticeTime() == null){
            result.setCode(ResultMessage.Code.PRAMA_LOSS);
            result.setMessage("余额提醒时间不可为空，请重新填写后提交");
            return result;
        }if (model.getIsUseHttp() == null){
            result.setCode(ResultMessage.Code.PRAMA_LOSS);
            result.setMessage("是否启用HTTP接口不可为空，请重新填写后提交");
            return result;
        }if (model.getIsUsePush() == null){
            result.setCode(ResultMessage.Code.PRAMA_LOSS);
            result.setMessage("是否启用推送不可为空，请重新填写后提交");
            return result;
        }


        return result;
    }
}
