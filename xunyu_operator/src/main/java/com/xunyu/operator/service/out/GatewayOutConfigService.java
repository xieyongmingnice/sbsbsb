package com.xunyu.operator.service.out;

import com.xunyu.model.operator.out.GatewayOutConfigModel;
import com.xunyu.operator.vo.out.GatewayOutConfigListVO;

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
     * @param model
     * @return 影响条数
     */
    int deleteGatewayOutConfig(GatewayOutConfigModel model);

}
