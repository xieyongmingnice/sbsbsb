package com.xunyu.operator.service.out;

import com.xunyu.model.operator.out.GatewayOutConfigModel;
import com.xunyu.model.operator.out.RechargeRecordModel;
import com.xunyu.operator.vo.out.GatewayOutConfigListVO;
import com.xunyu.operator.vo.out.GatewayOutConfigVO;

import java.util.List;

/**
 * @author xym
 * @description
 * @date 2018/6/14 10:13
 */
public interface GatewayOutConfigService {

    /**
     * 通过企业代码查询数据条数
     * @param enterpriseCode
     * @return
     */
    int selectCountByEnterpriseCode(String enterpriseCode);

    /**
     * 新增网关接出配置
     * @param model 参数
     * @return 影响条数
     */
    int insertGatewayOutConfig(GatewayOutConfigModel model);

    /**
     * 查询网关接出配置列表
     * @param model 参数类
     * @return
     */
    List<GatewayOutConfigListVO> selectConfigList(GatewayOutConfigModel model);

    /**
     * 查询 查询列表时符合条件的总条数 便于分页
     * @param model
     * @return  条数
     */
    int selectConfigListCount(GatewayOutConfigModel model);

    /**
     * 删除网关接出配置
     * @param idList
     * @return 影响条数
     */
    int deleteGatewayOutConfig(List<Integer> idList);


    /**
     * 编辑网关接出配置
     * @param model
     * @return 影响条数
     */
    int updateGatewayOutConfigShunt(GatewayOutConfigModel model);

    /**
     * 编辑网关接出配置（网关直连）
     * @param model
     * @return 影响条数
     */
    int updateGatewayOutConfigStraight(GatewayOutConfigModel model);

    /**
     * 充值
     * @param model
     * @return 影响条数
     */
    int recharge(RechargeRecordModel model);

    /**
     * 启用
     * @param idList
     * @return
     */
    int startUsing(List<Integer> idList);

    /**
     * 停用
     * @param idList
     * @return
     */
    int stopUsing(List<Integer> idList);

    /**
     * 恢复
     * @param idList
     * @return
     */
    int recover(List<Integer> idList);

    /**
     * 废弃
     * @param idList
     * @return
     */
    int abandon(List<Integer> idList);

    /**
     * 查看详情
     * @param model 参数类
     * @return 结果
     */
    GatewayOutConfigVO viewDetail(GatewayOutConfigModel model);

    /**
     * 增加网关配置
     */
    int addGatewayConfig(GatewayOutConfigModel model);

    /**
     * 删除网关配置
     */
    int deleteGatewayConfig(GatewayOutConfigModel model);

    /**
     * 清除网关配置（全部删除）
     */
    int clearGatewayConfig(List<Integer> idList);
}
