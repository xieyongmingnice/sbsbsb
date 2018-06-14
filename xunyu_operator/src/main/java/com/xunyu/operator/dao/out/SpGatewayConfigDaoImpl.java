package com.xunyu.operator.dao.out;

import com.commons.core.dao.impl.BaseDao;
import com.xunyu.model.operator.out.GatewayOutConfigModel;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

/**
 * @author xym
 * @description
 * @date 2018/6/14 16:06
 */
@Repository
public class SpGatewayConfigDaoImpl extends BaseDao{

    /**
     * 新增sp网关接出配置
     * @param model
     * @return
     */
    public int insertSpGatewayConfig(GatewayOutConfigModel model){
        return insert("com.xunyu.operator.pojo.out.SpGatewayConfig.insertSpGatewayConfig",model);
    }


    public SpGatewayConfigDaoImpl(SqlSessionFactory sqlSessionFactory) {
        super(sqlSessionFactory);
    }

    @Override
    public Class getClz() {
        return null;
    }
}
