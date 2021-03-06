package com.xunyu.operator.controller;

import com.commons.core.message.Result;
import com.commons.core.message.ResultMessage;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.xunyu.config.redis.RedisUtil;
import com.xunyu.model.operator.out.GatewayOutConfigModel;
import com.xunyu.model.operator.out.RechargeRecordModel;
import com.xunyu.model.operator.out.group.GatewayOutConfigGroup;
import com.xunyu.model.operator.out.group.GatewayOutConfigShuntGroup;
import com.xunyu.model.operator.out.group.SpConfigGroup;
import com.xunyu.model.user.User;
import com.xunyu.operator.constants.GatewayConfigConstant;
import com.xunyu.operator.pojo.access.OperAccessCoreConfig;
import com.xunyu.operator.pojo.out.CarrierAgree;
import com.xunyu.operator.pojo.out.Customer;
import com.xunyu.operator.service.access.OperAccessService;
import com.xunyu.operator.service.out.CarrierAgreeService;
import com.xunyu.operator.service.out.CustomerService;
import com.xunyu.operator.service.out.GatewayOutConfigService;
import com.xunyu.operator.utils.beaccopier.BeanCopierUtil;
import com.xunyu.operator.vo.out.GatewayOutConfigListVO;
import com.xunyu.operator.vo.out.GatewayOutConfigVO;
import com.xunyu.operator.vo.out.OperAccessCoreConfigVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
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
     * @param model 参数
     */
    @RequestMapping(value = "/firstComeInDetail")
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
        map.put("agreeType",model.getCarrierType());
        List<OperAccessCoreConfig> operAccessCoreConfigList = operAccessService.listOperAccessCoreConfig(map);
        if (operAccessCoreConfigList != null && operAccessCoreConfigList.size() > 0){
            List<OperAccessCoreConfigVO> operAccessCoreConfigVOList = Lists.newArrayList();
            //beanCopy
            for (OperAccessCoreConfig operAccessCoreConfig:operAccessCoreConfigList){
                OperAccessCoreConfigVO vo = new OperAccessCoreConfigVO();
                BeanCopierUtil.copyProperties(operAccessCoreConfig,vo);
                appendStrings(vo);
                operAccessCoreConfigVOList.add(vo);
            }
            config.setAccessConfigVOList(operAccessCoreConfigVOList);
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
     * @param model 参数
     * @return 结果
     */
    @RequestMapping(value = "/firstComeInList")
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
        if (coreConfigs !=null && coreConfigs.size()>0){
            result.setCode(ResultMessage.Code.SUCCESS);
            result.setMessage(ResultMessage.Message.SUCCESS);
            vo.setOperAccessCoreConfigList(coreConfigs);
            result.setRes(vo);
        }else {
            result.setCode(ResultMessage.Code.FAILED);
            result.setCode(ResultMessage.Message.FAILED);
        }
        //TODO 查询归属业务人员 放置到vo中
        return result;
    }

    /**
     * 新增配置（网关直连）
     * @param model 参数
     * @return 结果
     */
    @RequestMapping(value = "/addConfigStraight")
    public Result addConfigStraight(@Validated(GatewayOutConfigGroup.class) GatewayOutConfigModel model, BindingResult bindingResult){
        Result checkBlank = checkBlank(bindingResult);
        if (checkBlank != null){
            return checkBlank;
        }
        User user = redisUtil.getCurrUser(model.getSessionId());
        Result result = checkLogin(new Result(),user);
        if (result.getMessage() != null){
            return result;
        }
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
     * 新增配置（网关分流）
     * @param model 参数 校验用 GatewayOutConfigShuntGroup
     * @return 结果
     */
    @RequestMapping(value = "/addConfigShunt")
    public Result addConfigShunt(@Validated(GatewayOutConfigShuntGroup.class) GatewayOutConfigModel model, BindingResult bindingResult){
        Result checkBlank = checkBlank(bindingResult);
        if (checkBlank != null){
            return checkBlank;
        }
        User user = redisUtil.getCurrUser(model.getSessionId());
        Result result = checkLogin(new Result(),user);
        if (result.getMessage() != null){
            return result;
        }
        //校验：自定义企业代码,系统内必须唯一，否则提交失败
        String enterCode = model.getEnterpriseCode();
        int count = gatewayOutConfigService.selectCountByEnterpriseCode(enterCode);
        if (count > 0 ){
            result.setCode(ResultMessage.Code.FAILED);
            result.setMessage("企业代码已存在，请重新编辑后提交");
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
     * @param model 参数
     * @return 结果
     */
    @RequestMapping(value = "/getConfigList")
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
     * @param model 参数
     * @return 结果
     */
    @RequestMapping(value = "/deleteConfig")
    public Result<String> deleteGatewayOutConfig(GatewayOutConfigModel model){
        User user = redisUtil.getCurrUser(model.getSessionId());
        Result result = checkLogin(new Result(),user);
        if (result.getMessage() != null){
            return result;
        }
        List<Integer> idList = model.getIdList();
        if (idList == null || idList.size() <=0){
            result.setCode(ResultMessage.Code.PRAMA_LOSS);
            result.setMessage(ResultMessage.Message.PRAMA_LOSS+"：主键列idList");
            return result;
        }
        int success = gatewayOutConfigService.deleteGatewayOutConfig(idList);
        if (success > 0){
            result.setCode(ResultMessage.Code.SUCCESS);
            result.setMessage(ResultMessage.Message.SUCCESS);
        }else {
            result.setCode(ResultMessage.Code.FAILED);
            result.setCode(ResultMessage.Message.FAILED);
        }
        return result;
    }

    /**
     * 编辑(网关直连)
     * @param model 参数
     * @return 结果
     */
    @RequestMapping(value = "/updateConfigStraight")
    public Result<String> updateGatewayOutConfigStraight(@Validated(GatewayOutConfigGroup.class) GatewayOutConfigModel model, BindingResult bindingResult){
        Result checkBlank = checkBlank(bindingResult);
        if (checkBlank != null){
            return checkBlank;
        }
        User user = redisUtil.getCurrUser(model.getSessionId());
        Result result = checkLogin(new Result(),user);
        if (result.getMessage() != null){
            return result;
        }
        int success = gatewayOutConfigService.updateGatewayOutConfigStraight(model);
        if (success > 0){
            result.setCode(ResultMessage.Code.SUCCESS);
            result.setMessage(ResultMessage.Message.SUCCESS);
        }else {
            result.setCode(ResultMessage.Code.FAILED);
            result.setCode(ResultMessage.Message.FAILED);
        }
        return result;
    }

    /**
     * 编辑(网关分流) 校验参数不同
     * @param model 参数
     * @return 结果
     */
    @RequestMapping(value = "/updateConfigShunt")
    public Result<String> updateGatewayOutConfigShunt(@Validated(GatewayOutConfigShuntGroup.class) GatewayOutConfigModel model, BindingResult bindingResult){
        Result checkBlank = checkBlank(bindingResult);
        if (checkBlank != null){
            return checkBlank;
        }
        User user = redisUtil.getCurrUser(model.getSessionId());
        Result result = checkLogin(new Result(),user);
        if (result.getMessage() != null){
            return result;
        }
        int success = gatewayOutConfigService.updateGatewayOutConfigShunt(model);
        if (success > 0){
            result.setCode(ResultMessage.Code.SUCCESS);
            result.setMessage(ResultMessage.Message.SUCCESS);
        }else {
            result.setCode(ResultMessage.Code.FAILED);
            result.setCode(ResultMessage.Message.FAILED);
        }
        return result;
    }

    /**
     * 充值
     * @param model 参数
     * @return 结果
     */
    @RequestMapping(value = "/recharge")
    public Result<String> recharge(@Valid RechargeRecordModel model, BindingResult bindingResult){
        Result checkBlank = checkBlank(bindingResult);
        if (checkBlank != null){
            return checkBlank;
        }
        User user = redisUtil.getCurrUser(model.getSessionId());
        Result result = checkLogin(new Result(),user);
        if (result.getMessage() != null){
            return result;
        }
        model.setNumAfterRecharge(model.getRechargeMsgNum()+model.getRemainderMsgNum());
        int success = gatewayOutConfigService.recharge(model);
        if (success > 0){
            result.setCode(ResultMessage.Code.SUCCESS);
            result.setMessage(ResultMessage.Message.SUCCESS);
        }else {
            result.setCode(ResultMessage.Code.FAILED);
            result.setCode(ResultMessage.Message.FAILED);
        }
        return result;
    }



    /**
     * 启用
     * @param model 参数
     * @return 结果
     */
    @RequestMapping(value = "/startUsing")
    public Result<String> startUsing(GatewayOutConfigModel model){
        User user = redisUtil.getCurrUser(model.getSessionId());
        Result result = checkLogin(new Result(),user);
        if (result.getMessage() != null){
            return result;
        }
        List<Integer> idList = model.getIdList();
        if (idList == null || idList.size() <=0){
            result.setCode(ResultMessage.Code.PRAMA_LOSS);
            result.setMessage(ResultMessage.Message.PRAMA_LOSS+"：主键列idList");
            return result;
        }
        int success = gatewayOutConfigService.startUsing(idList);
        if (success > 0){
            result.setCode(ResultMessage.Code.SUCCESS);
            result.setMessage(ResultMessage.Message.SUCCESS);
        }else {
            result.setCode(ResultMessage.Code.FAILED);
            result.setCode(ResultMessage.Message.FAILED);
        }
        return result;
    }

    /**
     * 停用
     * @param model 参数
     * @return 结果
     */
    @RequestMapping(value = "/stopUsing")
    public Result<String> stopUsing(GatewayOutConfigModel model){
        User user = redisUtil.getCurrUser(model.getSessionId());
        Result result = checkLogin(new Result(),user);
        if (result.getMessage() != null){
            return result;
        }
        List<Integer> idList = model.getIdList();
        if (idList == null || idList.size() <=0){
            result.setCode(ResultMessage.Code.PRAMA_LOSS);
            result.setMessage(ResultMessage.Message.PRAMA_LOSS+"：主键列idList");
            return result;
        }
        int success = gatewayOutConfigService.stopUsing(idList);
        if (success > 0){
            result.setCode(ResultMessage.Code.SUCCESS);
            result.setMessage(ResultMessage.Message.SUCCESS);
        }else {
            result.setCode(ResultMessage.Code.FAILED);
            result.setCode(ResultMessage.Message.FAILED);
        }
        return result;
    }

    /**
     * 恢复
     * @param model 参数
     * @return
     */
    @RequestMapping(value = "/recover")
    public Result<String> recover(GatewayOutConfigModel model){
        User user = redisUtil.getCurrUser(model.getSessionId());
        Result result = checkLogin(new Result(),user);
        if (result.getMessage() != null){
            return result;
        }
        List<Integer> idList = model.getIdList();
        if (idList == null || idList.size() <=0){
            result.setCode(ResultMessage.Code.PRAMA_LOSS);
            result.setMessage(ResultMessage.Message.PRAMA_LOSS+"：主键列idList");
            return result;
        }
        int success = gatewayOutConfigService.recover(idList);
        if (success > 0){
            result.setCode(ResultMessage.Code.SUCCESS);
            result.setMessage(ResultMessage.Message.SUCCESS);
        }else {
            result.setCode(ResultMessage.Code.FAILED);
            result.setCode(ResultMessage.Message.FAILED);
        }
        return result;
    }

    /**
     * 废弃
     * @param model 参数
     * @return
     */
    @RequestMapping(value = "/abandon")
    public Result<String> abandon(GatewayOutConfigModel model){
        User user = redisUtil.getCurrUser(model.getSessionId());
        Result result = checkLogin(new Result(),user);
        if (result.getMessage() != null){
            return result;
        }
        List<Integer> idList = model.getIdList();
        if (idList == null || idList.size() <=0){
            result.setCode(ResultMessage.Code.PRAMA_LOSS);
            result.setMessage(ResultMessage.Message.PRAMA_LOSS+"：主键列idList");
            return result;
        }
        int success = gatewayOutConfigService.abandon(idList);
        if (success > 0){
            result.setCode(ResultMessage.Code.SUCCESS);
            result.setMessage(ResultMessage.Message.SUCCESS);
        }else {
            result.setCode(ResultMessage.Code.FAILED);
            result.setCode(ResultMessage.Message.FAILED);
        }
        return result;
    }

    /**
     * 查看单个详情
     * @param model 参数类
     * @return 结果集
     */
    @RequestMapping(value = "/viewDetail")
    public Result<GatewayOutConfigVO> viewDetail(GatewayOutConfigModel model){
        User user = redisUtil.getCurrUser(model.getSessionId());
        Result result = checkLogin(new Result(),user);
        if (result.getMessage() != null){
            return result;
        }
        GatewayOutConfigVO vo = gatewayOutConfigService.viewDetail(model);
        if (vo != null){
            result.setCode(ResultMessage.Code.SUCCESS);
            result.setMessage(ResultMessage.Message.SUCCESS);
            result.setRes(vo);
            Map map = Maps.newHashMap();
            map.put("startRow", 0);
            map.put("endRow", Long.MAX_VALUE);
            map.put("agreeType",model.getCarrierType());
            List<OperAccessCoreConfig> operAccessCoreConfigList = operAccessService.listOperAccessCoreConfig(map) ;
            if (operAccessCoreConfigList != null && operAccessCoreConfigList.size() > 0){
                List<OperAccessCoreConfigVO> operAccessCoreConfigVOList = Lists.newArrayList();
                //beanCopy
                for (OperAccessCoreConfig operAccessCoreConfig:operAccessCoreConfigList){
                    OperAccessCoreConfigVO accessCoreConfigVO = new OperAccessCoreConfigVO();
                    BeanCopierUtil.copyProperties(operAccessCoreConfig,accessCoreConfigVO);
                    appendStrings(accessCoreConfigVO);
                    operAccessCoreConfigVOList.add(accessCoreConfigVO);
                }
                vo.setAccessConfigVOList(operAccessCoreConfigVOList);
            }
            List<Customer> customerList = customerService.selectCustomerList();
            if (customerList != null && customerList.size() > 0) {
                vo.setCustomerList(customerList);
            }
            List<CarrierAgree> carrierAgreeList = carrierAgreeService.selectCarrierAgree(model.getCarrierType());
            if (carrierAgreeList != null && carrierAgreeList.size() > 0){
                vo.setCarrierAgreeList(carrierAgreeList);
            }
            String useTimeStr = vo.getUseTimeStr();
            String invalidTimeStr =vo.getInvalidTimeStr();
            if (useTimeStr!=null && useTimeStr.endsWith(".0")){
                vo.setUseTimeStr(useTimeStr.substring(0,useTimeStr.length()-2));
            }
            if (invalidTimeStr!=null && invalidTimeStr.endsWith(".0")){
                vo.setInvalidTimeStr(invalidTimeStr.substring(0,invalidTimeStr.length()-2));
            }
        }else {
            result.setCode(ResultMessage.Code.FAILED);
            result.setCode(ResultMessage.Message.FAILED);
        }
        return result;
    }

    /**
     * 配置网关节点接出信息 增加sp网关接出分流配置
     * @param model 参数类
     * @return 结果集
     */
    @RequestMapping(value = "/addGatewayConfig")
    public Result<String> addGatewayConfig(@Validated(SpConfigGroup.class) GatewayOutConfigModel model, BindingResult bindingResult){
        Result checkBlank = checkBlank(bindingResult);
        if (checkBlank != null){
            return checkBlank;
        }
        User user = redisUtil.getCurrUser(model.getSessionId());
        Result result = checkLogin(new Result(),user);
        if (result.getMessage() != null){
            return result;
        }
        boolean checkPrefix = model.getGatewayAccessCode().startsWith(model.getAccessCode());
        if (!checkPrefix){
            result.setCode(ResultMessage.Code.FAILED);
            result.setMessage("网关接入码前缀与网关节点不一致，请重新编辑后提交");
            return result;
        }
        int success = gatewayOutConfigService.addGatewayConfig(model);
        if (success>0){
            result.setCode(ResultMessage.Code.SUCCESS);
            result.setMessage(ResultMessage.Message.SUCCESS);
        }else {
            result.setCode(ResultMessage.Code.FAILED);
            result.setCode(ResultMessage.Message.FAILED);
        }
        return result;
    }

    /**
     * 删除sp网关接出分流配置
     * @param model 参数类
     * @return 结果集
     */
    @RequestMapping(value = "/deleteGatewayConfig")
    public Result<String> deleteGatewayConfig(GatewayOutConfigModel model){
        User user = redisUtil.getCurrUser(model.getSessionId());
        Result result = checkLogin(new Result(),user);
        if (result.getMessage() != null){
            return result;
        }
        if (model.getIdList()==null || model.getIdList().size()<=0){
            result.setCode(ResultMessage.Code.PRAMA_LOSS);
            result.setMessage(ResultMessage.Message.PRAMA_LOSS+"：主键列idList");
            return result;
        }
        int success = gatewayOutConfigService.deleteGatewayConfig(model);
        if (success>0){
            result.setCode(ResultMessage.Code.SUCCESS);
            result.setMessage(ResultMessage.Message.SUCCESS);
        }else {
            result.setCode(ResultMessage.Code.FAILED);
            result.setCode(ResultMessage.Message.FAILED);
        }
        return result;
    }

    /**
     * 清除sp网关接出分流配置(全部删除)
     * @param model 参数类
     * @return 结果集
     */
    @RequestMapping(value = "/clearGatewayConfig")
    public Result<String> clearGatewayConfig(GatewayOutConfigModel model){
        User user = redisUtil.getCurrUser(model.getSessionId());
        Result result = checkLogin(new Result(),user);
        if (result.getMessage() != null){
            return result;
        }
        if (model.getIdList()==null || model.getIdList().size()<=0){
            result.setCode(ResultMessage.Code.PRAMA_LOSS);
            result.setMessage(ResultMessage.Message.PRAMA_LOSS+"：主键列idList");
            return result;
        }
        int success = gatewayOutConfigService.clearGatewayConfig(model.getIdList());
        if (success>0){
            result.setCode(ResultMessage.Code.SUCCESS);
            result.setMessage(ResultMessage.Message.SUCCESS);
        }else {
            result.setCode(ResultMessage.Code.FAILED);
            result.setCode(ResultMessage.Message.FAILED);
        }
        return result;
    }

    /**
     * 根据configId查询接入配置
     * @param model 参数类
     * @return 结果集
     */
    @RequestMapping(value = "/selectAccessConfig")
    public Result<OperAccessCoreConfigVO> selectAccessConfig(GatewayOutConfigModel model){
        User user = redisUtil.getCurrUser(model.getSessionId());
        Result result = checkLogin(new Result(),user);
        if (result.getMessage() != null){
            return result;
        }
        if (model.getConfigId() == null || model.getConfigId() == 0){
            result.setCode(ResultMessage.Code.PRAMA_LOSS);
            result.setMessage(ResultMessage.Message.PRAMA_LOSS+"：configId");
            return result;
        }
        Map<String,Object> map = Maps.newHashMap();
        map.put("configId",model.getConfigId());
        OperAccessCoreConfig config = operAccessService.getOperAccessCoreConfig(map);
        if (config != null){
            OperAccessCoreConfigVO vo = new OperAccessCoreConfigVO();
            BeanCopierUtil.copyProperties(config,vo);
            appendStrings(vo);
            result.setCode(ResultMessage.Code.SUCCESS);
            result.setMessage(ResultMessage.Message.SUCCESS);
            result.setRes(vo);
        }else {
            result.setCode(ResultMessage.Code.FAILED);
            result.setCode(ResultMessage.Message.FAILED);
        }
        return result;
    }

    /**
     * 检查是否登录或会话是否过期
     * @param result 结果
     * @param user 用户
     * @return
     */
    private Result checkLogin(Result result,User user){
        if(user == null){
            result.setCode(ResultMessage.Code.NOT_FOUND);
            result.setMessage(ResultMessage.Message.UN_LOGIN_2);
        }
        return result;
    }


    /**
     * 判断是否检查出不合法的参数
     */
    private Result checkBlank(BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            StringBuffer sb = new StringBuffer();
            for(ObjectError objectError : bindingResult.getAllErrors()){
                sb.append(((FieldError)objectError).getField() +" : ").append(objectError.getDefaultMessage());
                break;
            }
            Result result = new Result();
            result.setCode(ResultMessage.Code.FAILED);
            result.setMessage(sb.toString());
            return result;
        }
        return null;
    }

    /**
     *
     */
    private OperAccessCoreConfigVO appendStrings(OperAccessCoreConfigVO vo){
        String carrier = "";
        if (vo.getAgreeType()== GatewayConfigConstant.Carrier.CMPP){
            carrier = GatewayConfigConstant.CarrierName.CMPP;
        }if (vo.getAgreeType()== GatewayConfigConstant.Carrier.SGIP){
            carrier = GatewayConfigConstant.CarrierName.SGIP;
        }if (vo.getAgreeType()== GatewayConfigConstant.Carrier.SMGP){
            carrier = GatewayConfigConstant.CarrierName.SMGP;
        }

        String isabled = "";
        if (vo.getIsable() == 1){
            isabled = "有效";
        }if (vo.getIsable() == 2){
            isabled = "停用";
        }if (vo.getIsable() == 3){
            isabled = "停用";
        }if (vo.getIsable() == 4){
            isabled = "停用";
        }
        StringBuilder sb = new StringBuilder("");
        sb.append("(");
        sb.append(carrier);
        sb.append(")");
        sb.append(vo.getChannelName());
        sb.append("(");
        sb.append(isabled);
        sb.append(")");
        vo.setNameStr(sb.toString());
        return vo;
    }
}
