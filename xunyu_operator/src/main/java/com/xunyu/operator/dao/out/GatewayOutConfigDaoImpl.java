package com.xunyu.operator.dao.out;

import com.commons.core.dao.impl.BaseDao;
import com.xunyu.model.operator.out.GatewayOutConfigModel;
import com.xunyu.operator.vo.out.GatewayOutConfigListVO;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author xym
 * @description
 * @date 2018/6/14 10:11
 */
@Repository
public class GatewayOutConfigDaoImpl extends BaseDao {


    /**
     * 通过企业代码查询记录条数
     * @param enterpriseCode 企业代码
     * @return 条数
     */
    public int selectCountByEnterpriseCode(String enterpriseCode){
        return selectOne("com.xunyu.operator.pojo.out.GatewayOutConfig.selectCountByEnterpriseCode",enterpriseCode);
    }

    /**
     * 新增网关接出配置
     * @param model 参数
     * @return 影响条数
     */
    public int insertGatewayOutConfig(GatewayOutConfigModel model){
        return insert("com.xunyu.operator.pojo.out.GatewayOutConfig.insertGatewayOutConfig",model);
    }

    /**
     * 查询网关接出配置列表
     * @param model 参数类
     * @return
     */
    public List<GatewayOutConfigListVO> selectConfigList(GatewayOutConfigModel model){
        return selectList("com.xunyu.operator.pojo.out.GatewayOutConfig.selectConfigList",model);
    }

    /**
     * 查询 查询列表时符合条件的总条数 便于分页
     * @param model
     * @return  条数
     */
    public int selectConfigListCount(GatewayOutConfigModel model){
        return selectOne("com.xunyu.operator.pojo.out.GatewayOutConfig.selectConfigListCount",model);
    }

    /**
     * 删除
     * @param model
     * @return
     */
    public int deleteGatewayOutConfig(GatewayOutConfigModel model){
        return update("com.xunyu.operator.pojo.out.GatewayOutConfig.deleteGatewayOutConfig",model);
    }

    public GatewayOutConfigDaoImpl(SqlSessionFactory sqlSessionFactory) {
        super(sqlSessionFactory);
    }

    @Override
    public Class getClz() {
        return null;
    }
}
