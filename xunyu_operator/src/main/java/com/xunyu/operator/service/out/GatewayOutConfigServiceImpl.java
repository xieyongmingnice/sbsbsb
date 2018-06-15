package com.xunyu.operator.service.out;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.xunyu.model.operator.out.GatewayOutConfigModel;
import com.xunyu.operator.dao.out.GatewayOutConfigDaoImpl;
import com.xunyu.operator.dao.out.SpGatewayConfigDaoImpl;
import com.xunyu.operator.vo.out.GatewayOutConfigListVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.concurrent.*;

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

    /**
     * 查询网关接出配置列表
     * @param model 参数类
     * @return
     */
    @Override
    public List<GatewayOutConfigListVO> selectConfigList(GatewayOutConfigModel model) {
        return gatewayOutConfigDao.selectConfigList(model);
    }

    /**
     * 查询 查询列表时符合条件的总条数 便于分页
     * @param model
     * @return  条数
     */
    @Override
    public int selectConfigListCount(GatewayOutConfigModel model) {
        return gatewayOutConfigDao.selectConfigListCount(model);
    }


    /**
     * 删除网关接出配置
     * @param model
     * @return 影响条数
     */
    @Override
    @Transactional(rollbackFor = Exception.class,propagation = Propagation.REQUIRED)
    public int deleteGatewayOutConfig(GatewayOutConfigModel model) {
        ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("service-pool-%d").build();
        ExecutorService ex = new ThreadPoolExecutor(5, 200, 0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(1024) , threadFactory,new ThreadPoolExecutor.AbortPolicy());
        Runnable runnable = () -> {
            gatewayOutConfigDao.deleteGatewayOutConfig(model);
            spGatewayConfigDao.deleteSpGatewayConfig(model);
        };
        return 0;
    }

}
