package com.xunyu.operator.dao.out;

import com.commons.core.dao.impl.BaseDao;
import com.xunyu.model.operator.out.RechargeRecordModel;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

/**
 * @author xym
 * @description 充值记录dao实现类
 * @date 2018/6/19 10:18
 */
@Repository
public class RechargeRecordDaoImpl extends BaseDao{

    /**
     * 新增充值记录
     * @param model
     * @return
     */
    public int insertRechargeRecord(RechargeRecordModel model){
        return insert("com.xunyu.operator.pojo.out.RechargeRecord.insertRechargeRecord",model);
    }


    public RechargeRecordDaoImpl(SqlSessionFactory sqlSessionFactory) {
        super(sqlSessionFactory);
    }

    @Override
    public Class getClz() {
        return null;
    }
}
