package com.xunyu.operator.service.out;

import com.xunyu.model.operator.out.GatewayOutConfigModel;

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
}
