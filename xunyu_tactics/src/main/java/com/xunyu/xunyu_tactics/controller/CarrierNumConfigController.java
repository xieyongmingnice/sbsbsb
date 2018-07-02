package com.xunyu.xunyu_tactics.controller;

import com.commons.core.message.Result;
import com.commons.core.message.ResultMessage;
import com.google.common.collect.Lists;
import com.xunyu.config.redis.RedisUtil;
import com.xunyu.model.tactics.CarrierNumConfigModel;
import com.xunyu.xunyu_tactics.constant.TacticsConstants;
import com.xunyu.xunyu_tactics.pojo.CarrierNumConfig;
import com.xunyu.xunyu_tactics.service.CarrierNumConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author xym
 * @description 运营商号段配置管理
 * @date 2018/6/25 18:00
 */
@RestController
@RequestMapping("/carrierNum")
public class CarrierNumConfigController {

    @Autowired
    RedisUtil redisUtil;

    @Autowired
    CarrierNumConfigService carrierNumConfigService;

    /**
     * 修改列表
     * @param model
     * @return
     */
    @RequestMapping("/editNums")
    public Result<String> editNums(CarrierNumConfigModel model){
        Result result = checkLogin(new Result(),model.getSessionId());
        if(result.getMessage() != null ){
            return result;
        }
        List<Integer> chinaMobileNums = model.getChinaMobileNums();
        List<Integer> chinaUnicomNums = model.getChinaUnicomNums();
        List<Integer> chinaTelecomNums = model.getChinaTelecomNums();
        List<CarrierNumConfig> configList = Lists.newArrayList();
        if(chinaMobileNums != null) {
            for (Integer num : chinaMobileNums) {
                if (num != null ) {
                    CarrierNumConfig cnc = new CarrierNumConfig();
                    cnc.setNumPrefix(num);
                    cnc.setIsabled(1);
                    cnc.setCarrierType(TacticsConstants.CarrierType.CHINA_MOBILE);
                    configList.add(cnc);
                }
            }
        }
        if(chinaUnicomNums != null) {
            for (Integer num : chinaUnicomNums) {
                if (num != null ) {
                    CarrierNumConfig cnc = new CarrierNumConfig();
                    cnc.setNumPrefix(num);
                    cnc.setIsabled(1);
                    cnc.setCarrierType(TacticsConstants.CarrierType.CHINA_UNICOM);
                    configList.add(cnc);
                }
            }
        }
        if(chinaTelecomNums != null ) {
            for (Integer num : chinaTelecomNums) {
                if (num != null ) {
                    CarrierNumConfig cnc = new CarrierNumConfig();
                    cnc.setNumPrefix(num);
                    cnc.setIsabled(1);
                    cnc.setCarrierType(TacticsConstants.CarrierType.CHINA_TELECOM);
                    configList.add(cnc);
                }
            }
        }
        Set<CarrierNumConfig> set = new TreeSet<>(Comparator.comparing(CarrierNumConfig::getNumPrefix));
        set.addAll(configList);
        List<CarrierNumConfig> list = Lists.newArrayList(set);

        //批量插入新数据
        int insert = 0;
        int delete = 0;
        if (list != null && list.size()>0) {
            insert = carrierNumConfigService.batchInsert(list);
        }else {
            //删除之前的数据
            delete = carrierNumConfigService.deleteNums();
        }
        if (insert>0 || delete>0){
            result.setMessage(ResultMessage.Message.SUCCESS);
            result.setCode(ResultMessage.Code.SUCCESS);
        }else {
            result.setMessage(ResultMessage.Message.FAILED);
            result.setCode(ResultMessage.Code.FAILED);
        }
        return result;
    }

    /**
     * 查询列表
     * @param model
     * @return
     */
    @RequestMapping("/selectNums")
    public Result<CarrierNumConfig> selectNums(CarrierNumConfigModel model){
        Result result = checkLogin(new Result(),model.getSessionId());
        if(result.getMessage() != null ){
            return result;
        }
        List<CarrierNumConfig> list = carrierNumConfigService.selectList();
        if (list!=null && list.size()>0){
            result.setMessage(ResultMessage.Message.SUCCESS);
            result.setCode(ResultMessage.Code.SUCCESS);
            result.setRes(list);
        }else {
            result.setMessage(ResultMessage.Message.NO_VALUE);
            result.setCode(ResultMessage.Code.NOT_FOUND);
        }
        return  result;
    }

    /**
     * 重置
     */
    @RequestMapping("/reset")
    public Result<String> reset(CarrierNumConfigModel model){
        Result result = checkLogin(new Result(),model.getSessionId());
        if(result.getMessage() != null ){
            return result;
        }
        int success = carrierNumConfigService.deleteNums();
        if (success > 0){
            result.setMessage(ResultMessage.Message.SUCCESS);
            result.setCode(ResultMessage.Code.SUCCESS);
        }else {
            result.setMessage(ResultMessage.Message.FAILED);
            result.setCode(ResultMessage.Code.FAILED);
        }
        return  result;
    }

    /**
     * 检查登陆
     * @param r
     * @param sessionId
     */
    private Result checkLogin(Result r, String sessionId){
        boolean flag = redisUtil.sessionStatus(sessionId);
        if (!flag) {
            r.setCode(ResultMessage.Code.NOT_FOUND);
            r.setMessage(ResultMessage.Message.UN_LOGIN);
        }
        return r;
    }

}
