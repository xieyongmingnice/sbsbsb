package com.xunyu.operator.dao.out;

import com.commons.core.dao.impl.BaseDao;
import com.xunyu.model.operator.out.GatewayOutConfigModel;
import com.xunyu.operator.vo.out.SpGatewayConfigVO;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    /**
     * 根据gatewayOutConfigId删除sp网关接出配置
     * @param idList
     * @return
     */
    public int deleteSpGatewayConfig(List<Integer> idList){
        return update("com.xunyu.operator.pojo.out.SpGatewayConfig.deleteSpGatewayConfigByGatewayConfigId",idList);
    }

    /**
     * 启用 、 恢复
     * @param idList
     * @return
     */
    public int startUsing(List<Integer> idList){
        return update("com.xunyu.operator.pojo.out.SpGatewayConfig.startUsing",idList);
    }

    /**
     * 停用 、 废弃
     * @param idList
     * @return
     */
    public int stopUsing(List<Integer> idList){
        return update("com.xunyu.operator.pojo.out.SpGatewayConfig.stopUsing",idList);
    }

    /**
     * 根据gateway_out_config_id查询网关分流配置
     */
    public List<SpGatewayConfigVO> selectByGatewayOutConfigId(GatewayOutConfigModel model){
        return selectList("com.xunyu.operator.pojo.out.SpGatewayConfig.selectByGatewayOutConfigId",model);
    }

    /**
     * 根据sp_gateway_config_id集合删除网关配置
     */
    public int deleteSpGatewayConfigByPK(List<Integer> idList){
        return update("com.xunyu.operator.pojo.out.SpGatewayConfig.deleteSpGatewayConfigByPK",idList);
    }

    public SpGatewayConfigDaoImpl(SqlSessionFactory sqlSessionFactory) {
        super(sqlSessionFactory);
    }

    @Override
    public Class getClz() {
        return null;
    }
}
