package com.xunyu.system.dao.operator;

import com.commons.core.dao.impl.BaseDao;
import com.xunyu.system.pojo.operator.Operator;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author dth
 * @date 2018/4/28 9:46
 **/
@Repository
public class OperatorDaoImpl extends BaseDao<Operator,Long> {

    /**
     * 添加运营商配置信息
     */
    public int addOperator(Operator op){

        return super.insert("com.xunyu.system.pojo.operator.Operator.addOperator",op);
    }

    /**
     * 修改运营商配置信息
     */
    public int updateOPerator(Operator op){

        return super.update("com.xunyu.system.pojo.operator.Operator.updateOPerator",op);
    }

    /**
     *获取运营商配置详情
     */
    public Operator getOperatorDetail(Map<String,Object> map){

        return super.selectForObject("com.xunyu.system.pojo.operator.Operator.getOperatorDetail",map);
    }

    /**
     * 获取运营商配置列表
     */
    public int OperatorCount(Map<String,Object> map){
        return super.selectForObject("com.xunyu.system.pojo.operator.Operator.OperatorCount",map);
    }
    public List<Operator> OperatorList(Map<String,Object> map){
        return super.selectForListObject("com.xunyu.system.pojo.operator.Operator.OperatorList",map);
    }

    /**
     * 批量删除
     */
   public int delOperatorById(Map<String,Object> map){

        return super.update("com.xunyu.system.pojo.operator.Operator.delOperatorById",map);
    }

    public OperatorDaoImpl(SqlSessionFactory sqlSessionFactory) {
        super(sqlSessionFactory);
    }

    @Override
    public Class<Operator> getClz() {
        return Operator.class;
    }


}
