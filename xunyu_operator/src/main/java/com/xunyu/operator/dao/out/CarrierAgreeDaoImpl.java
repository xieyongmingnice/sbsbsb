package com.xunyu.operator.dao.out;

import com.commons.core.dao.impl.BaseDao;
import com.xunyu.operator.pojo.out.CarrierAgree;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author xym
 * @description
 * @date 2018/6/12 17:15
 */
@Repository
public class CarrierAgreeDaoImpl extends BaseDao {

    public List<CarrierAgree> selectCarrierAgreeList(Integer carrierType){
        return selectList("com.xunyu.operator.pojo.out.CarrierAgree.selectCarrierAgreeList",carrierType);
    }

    public CarrierAgreeDaoImpl(SqlSessionFactory sqlSessionFactory) {
        super(sqlSessionFactory);
    }

    @Override
    public Class getClz() {
        return null;
    }
}
