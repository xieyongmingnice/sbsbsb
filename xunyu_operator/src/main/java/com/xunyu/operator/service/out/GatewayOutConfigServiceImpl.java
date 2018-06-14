package com.xunyu.operator.service.out;

import com.xunyu.model.operator.out.GatewayOutConfigModel;
import com.xunyu.operator.dao.out.GatewayOutConfigDaoImpl;
import com.xunyu.operator.dao.out.SpGatewayConfigDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author xym
 * @description
 * @date 2018/6/14 10:13
 */
@Service
public class GatewayOutConfigServiceImpl implements GatewayOutConfigService {

    @Autowired
    GatewayOutConfigDaoImpl gatewayOutConfigDao;

    @Autowired
    SpGatewayConfigDaoImpl spGatewayConfigDao;

    /**
     * 通过企业代码查询记录条数
     * @param enterpriseCode
     * @return
     */
    @Override
    public int selectCountByEnterpriseCode(String enterpriseCode) {
        return gatewayOutConfigDao.selectCountByEnterpriseCode(enterpriseCode);
    }

    /**
     * 新增网关接出配置
     * @param model 参数
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class,propagation = Propagation.REQUIRED)
    public int insertGatewayOutConfig(GatewayOutConfigModel model) {
        int result_1 = gatewayOutConfigDao.insertGatewayOutConfig(model);
        int result_2 = spGatewayConfigDao.insertSpGatewayConfig(model);
        int result = result_1 > 0 && result_2 >0 ? 1 : 0;
        return  result;
    }

}
