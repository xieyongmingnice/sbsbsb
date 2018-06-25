package com.xunyu.operator.dao.out;

import com.commons.core.dao.impl.BaseDao;
import com.xunyu.model.operator.out.GatewayOutConfigModel;
import com.xunyu.model.operator.out.RechargeRecordModel;
import com.xunyu.operator.vo.out.GatewayOutConfigListVO;
import com.xunyu.operator.vo.out.GatewayOutConfigVO;
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
     * @param idList
     * @return
     */
    public int deleteGatewayOutConfig(List<Integer> idList){
        return update("com.xunyu.operator.pojo.out.GatewayOutConfig.deleteGatewayOutConfig",idList);
    }

    /**
     * 编辑网关接出配置
     * @param model
     * @return 影响条数
     */
    public int updateGatewayOutConfig(GatewayOutConfigModel model){
        return update("com.xunyu.operator.pojo.out.GatewayOutConfig.updateGatewayOutConfig",model);
    }

    /**
     * 充值
     * @param model
     * @return 影响条数
     */
    public int recharge(RechargeRecordModel model){
        return update("com.xunyu.operator.pojo.out.GatewayOutConfig.recharge",model);
    }

    /**
     * 启用
     * @param idList
     * @return
     */
    public int startUsing(List<Integer> idList){
        return update("com.xunyu.operator.pojo.out.GatewayOutConfig.startUsing",idList);
    }

    /**
     * 停用
     * @param idList
     * @return
     */
    public int stopUsing(List<Integer> idList){
        return update("com.xunyu.operator.pojo.out.GatewayOutConfig.stopUsing",idList);
    }

    /**
     * 恢复
     * @param idList
     * @return
     */
    public int recover(List<Integer> idList){
        return update("com.xunyu.operator.pojo.out.GatewayOutConfig.recover",idList);
    }

    /**
     * 废弃
     * @param idList
     * @return
     */
    public int abandon(List<Integer> idList){
        return update("com.xunyu.operator.pojo.out.GatewayOutConfig.abandon",idList);
    }

    /**
     *
     * @param model 参数类
     * @return
     */
    public GatewayOutConfigVO viewDetail(GatewayOutConfigModel model){
        return selectOne("com.xunyu.operator.pojo.out.GatewayOutConfig.viewDetail",model);
    }

    public GatewayOutConfigDaoImpl(SqlSessionFactory sqlSessionFactory) {
        super(sqlSessionFactory);
    }

    @Override
    public Class getClz() {
        return null;
    }
}
