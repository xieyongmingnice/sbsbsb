package com.xunyu.system.controller.operator;

import com.commons.core.message.Result;
import com.commons.core.util.StringUtils2;
import com.xunyu.config.redis.RedisUtil;
import com.xunyu.model.system.operator.OperatorModel;
import com.xunyu.model.user.User;
import com.xunyu.system.pojo.operator.Operator;
import com.xunyu.system.service.operator.OperatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author dth
 * @date 2018/4/28 10:06
 **/
@RestController
@RequestMapping(value = "/oper")
public class OperatorController {

    @Autowired
    private RedisUtil redisUtil;
    @Autowired
    private OperatorService operatorService;

    /**
     * 添加运营商配置
     * @param response
     * @param op
     * @return
     */
    @RequestMapping(value = "addOperator",method = RequestMethod.POST)
    public Result<Operator> addOperatorData(Operator op) throws Exception{

        Result<Operator> res = new Result<Operator>();
        User us = redisUtil.getCurrUser(op.getSessionId());
        Map<String, Object> map = new HashMap<String, Object>();
        int flag = 0;
        if (us == null) {
            res.setCode("404");
            res.setMessage("当前会话失效，请跳转到登录页");
            return res;
        }
            op.setCreateTime(new Date());
            op.setIsabled(1);
            operatorService.addOperator(op);
            res.setMessage("success");
            res.setCode("200");
            res.setRes(op);
        return res;
    }

    /**
     * 修改运营商配置
     */
    @RequestMapping(value = "updateOperator",method = RequestMethod.POST)
    public Result<Operator> updateOperatorData(Operator op) throws Exception{

        Result<Operator> res = new Result<Operator>();
        User us = redisUtil.getCurrUser(op.getSessionId());
        Map<String, Object> map = new HashMap<String, Object>();
        int flag = 0;
        if (us == null) {
            res.setCode("404");
            res.setMessage("当前会话失效，请跳转到登录页");
            return res;
        }
            if(op.getOperId() != null){
                operatorService.updateOPerator(op);
                res.setMessage("success");
                res.setCode("200");
                res.setRes(op);
            }else{
                res.setCode("413");
                res.setMessage("operId不能为空");
                res.setRes(op);
            }

        return res;
    }

    /**
     * 获取运营商配置详情
     */
    @RequestMapping(value = "getOperatorDetail",method = RequestMethod.POST)
    public Result<Operator> getOperatorDetailData(OperatorModel op) throws Exception{

        Result<Operator> res = new Result<Operator>();
        User us = redisUtil.getCurrUser(op.getSessionId());
        Map<String, Object> map = new HashMap<String, Object>();
        int flag = 0;
        if (us == null) {
            res.setCode("404");
            res.setMessage("当前会话失效，请跳转到登录页");
            return res;
        }
            if(op.getOperId() != null){
                map.put("operId",op.getOperId());
                Operator oop =  operatorService.getOperatorDetail(map);
                if(oop != null){
                    res.setMessage("success");
                    res.setCode("200");
                    res.setRes(oop);
                }else{
                    res.setMessage("notvalue");
                    res.setCode("412");
                    res.setRes(oop);
                }
            }else{
                res.setCode("413");
                res.setMessage("operId不能为空");
            }
        return res;
    }

    /**
     * 获取运营商配置列表
     */
    @RequestMapping(value = "operatorList",method = RequestMethod.POST)
    public Result<List<Operator>> OperatorListData(OperatorModel op) throws Exception{

        Result<List<Operator>> res = new Result<List<Operator>>();
        User us = redisUtil.getCurrUser(op.getSessionId());
        Map<String, Object> map = new HashMap<String, Object>();
        int total = 0;
        int flag = 0;
        if (us == null) {
            res.setCode("404");
            res.setMessage("当前会话失效，请跳转到登录页");
            return res;
        }
            map.put("operId",op.getOperId());
            map.put("operName",op.getOperName());
            map.put("startRow", op.getStartRows());
            map.put("endRow", op.getEndRows());
            total = operatorService.OperatorCount(map);
            if(total > 0){
               List<Operator> list = operatorService.OperatorList(map);
               res.setRes(list);
               res.setCode("200");
               res.setMessage("success");
               res.setTotalRows(total);
            }else{
                res.setMessage("notvalue");
                res.setCode("412");
            }
        return res;
    }

    /**
     * 批量删除
     */
    @RequestMapping(value = "delOperatorByIds",method = RequestMethod.POST)
    public Result<Operator> delOperatorData(OperatorModel op) throws Exception{

        Result<Operator> res = new Result<Operator>();
        User us = redisUtil.getCurrUser(op.getSessionId());
        Map<String, Object> map = new HashMap<String, Object>();
        int flag = 0;
        if (us == null) {
            res.setCode("404");
            res.setMessage("当前会话失效，请跳转到登录页");
            return res;
        }

            if(StringUtils2.isNotEmpty(op.getOperIds())){
               operatorService.delOperatorById(op.getOperIds());
                res.setCode("200");
                res.setMessage("success");
            }else{
                res.setCode("413");
                res.setMessage("operIds不能为空");
            }

        return res;
    }

}
