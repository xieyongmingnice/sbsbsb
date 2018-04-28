package com.xunyu.system.service.operator;

import com.xunyu.system.pojo.operator.Operator;

import java.util.List;
import java.util.Map;

/**
 * @author dth
 * @date 2018/4/28 9:30
 **/
public interface OperatorService {

    /**
     * 添加运营商配置信息
     */
    int addOperator(Operator op);

    /**
     * 修改运营商配置信息
     */
    int updateOPerator(Operator op);

    /**
     *获取运营商配置详情
     */
    Operator getOperatorDetail(Map<String,Object> map);

    /**
     * 获取运营商配置列表
     */
    int OperatorCount(Map<String,Object> map);
    List<Operator> OperatorList(Map<String,Object> map);

    /**
     * 批量删除
     */
    int delOperatorById(String ids);

}
