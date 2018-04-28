package com.xunyu.system.service.operator;

import com.commons.core.util.RandomUtils;
import com.commons.core.util.StringUtils2;
import com.xunyu.system.dao.operator.OperatorDaoImpl;
import com.xunyu.system.pojo.operator.Operator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author dth
 * @date 2018/4/28 9:45
 **/
@Service
public class OperatorServiceImpl implements OperatorService{

    @Autowired
    private OperatorDaoImpl operatorDaoImpl;

    @Override
    public int addOperator(Operator op) {
        return operatorDaoImpl.addOperator(op);
    }

    @Override
    public int updateOPerator(Operator op) {
        return operatorDaoImpl.updateOPerator(op);
    }

    @Override
    public Operator getOperatorDetail(Map<String, Object> map) {
        return operatorDaoImpl.getOperatorDetail(map);
    }

    @Override
    public int OperatorCount(Map<String, Object> map) {
        return operatorDaoImpl.OperatorCount(map);
    }

    @Override
    public List<Operator> OperatorList(Map<String, Object> map) {
        return operatorDaoImpl.OperatorList(map);
    }

    @Override
    public int delOperatorById(String ids) {
        int n = 0;
        if(StringUtils2.isNotEmpty(ids)) {

            Map<String,Object> map = new HashMap<String,Object>();
            String[] idsDir = ids.split(",");
            String[] array = new String[idsDir.length];
            for (int i = 0; i < idsDir.length; i++) {
                if(RandomUtils.isInteger(idsDir[i])){
                    array[i] = idsDir[i];

                }else{
                    continue;
                }
            }
            map.put("isabled",0);
            map.put("array",array);
            n = operatorDaoImpl.delOperatorById(map);
        }
        return n;
    }
}
