package com.xunyu.operator.service.out;

import com.xunyu.model.operator.out.GatewayOutConfigModel;
import com.xunyu.model.operator.out.RechargeRecordModel;
import com.xunyu.operator.dao.out.GatewayOutConfigDaoImpl;
import com.xunyu.operator.dao.out.RechargeRecordDaoImpl;
import com.xunyu.operator.dao.out.SpGatewayConfigDaoImpl;
import com.xunyu.operator.exception.out.GatewayOutConfigExcption;
import com.xunyu.operator.vo.out.GatewayOutConfigListVO;
import com.xunyu.operator.vo.out.GatewayOutConfigVO;
import com.xunyu.operator.vo.out.SpGatewayConfigVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author xym
 * @description
 * @date 2018/6/14 10:13
 */
@Service
public class GatewayOutConfigServiceImpl implements GatewayOutConfigService {

    private Logger logger = LoggerFactory.getLogger(GatewayOutConfigServiceImpl.class);

    @Autowired
    GatewayOutConfigDaoImpl gatewayOutConfigDao;

    @Autowired
    SpGatewayConfigDaoImpl spGatewayConfigDao;

    @Autowired
    RechargeRecordDaoImpl rechargeRecordDao;

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
        if (result_1 <= 0 || result_2 <= 0){
            throw new GatewayOutConfigExcption();
        }
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
        int result_1 = gatewayOutConfigDao.deleteGatewayOutConfig(model);
        int result_2 = spGatewayConfigDao.deleteSpGatewayConfig(model);
        if(result_1 <= 0 || result_2 <= 0){
            throw new GatewayOutConfigExcption();
        }
        int result = result_1 > 0 && result_2 >0 ? 1 : 0;
        return result;
    }

    /**
     * 编辑网关接出配置
     * @param model
     * @return 影响条数
     */
    @Override
    public int updateGatewayOutConfig(GatewayOutConfigModel model) {
        return gatewayOutConfigDao.updateGatewayOutConfig(model);
    }

    /**
     * 充值
     * @param model
     * @return 影响条数
     */
    @Override
    @Transactional(rollbackFor = Exception.class,propagation = Propagation.REQUIRED)
    public int recharge(RechargeRecordModel model) {

        int result_1 = gatewayOutConfigDao.recharge(model);
        int result_2 = rechargeRecordDao.insertRechargeRecord(model);
        int result = result_1 > 0 && result_2 >0 ? 1 : 0;
        if(result_1 <= 0 || result_2 <= 0){
            throw new GatewayOutConfigExcption();
        }
        return result;
    }
    /**
     * 启用
     * @param idList
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class,propagation = Propagation.REQUIRED)
    public int startUsing(List<Integer> idList) {

        int result_1 = gatewayOutConfigDao.startUsing(idList);
        int result_2 = spGatewayConfigDao.startUsing(idList);
        int result = result_1 > 0 && result_2 >0 ? 1 : 0;
        if(result_1 <= 0 || result_2 <= 0){
            throw new GatewayOutConfigExcption();
        }
        return result;
    }
    /**
     * 停用
     * @param idList
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class,propagation = Propagation.REQUIRED)
    public int stopUsing(List<Integer> idList) {

        int result_1 = gatewayOutConfigDao.stopUsing(idList);
        int result_2 = spGatewayConfigDao.stopUsing(idList);
        int result = result_1 > 0 && result_2 >0 ? 1 : 0;
        if(result_1 <= 0 || result_2 <= 0){
            throw new GatewayOutConfigExcption();
        }

        return result;
    }
    /**
     * 恢复
     * @param idList
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class,propagation = Propagation.REQUIRED)
    public int recover(List<Integer> idList) {

        int result_1 = gatewayOutConfigDao.recover(idList);
        int result_2 = spGatewayConfigDao.startUsing(idList);
        int result = result_1 > 0 && result_2 >0 ? 1 : 0;
        if(result_1 <= 0 || result_2 <= 0){
            throw new GatewayOutConfigExcption();
        }

        return result;
    }
    /**
     * 废弃
     * @param idList
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class,propagation = Propagation.REQUIRED)
    public int abandon(List<Integer> idList) {

        int result_1 = gatewayOutConfigDao.abandon(idList);
        int result_2 = spGatewayConfigDao.stopUsing(idList);
        int result = result_1 > 0 && result_2 >0 ? 1 : 0;
        if(result_1 <= 0 || result_2 <= 0){
            throw new GatewayOutConfigExcption();
        }
        return result;
    }

    /**
     * 查看详情
     * @param model 参数类
     * @return 结果
     */
    @Override
    public GatewayOutConfigVO viewDetail(GatewayOutConfigModel model) {
        GatewayOutConfigVO vo = gatewayOutConfigDao.viewDetail(model);
        List<SpGatewayConfigVO> spGatewayConfigList = spGatewayConfigDao.selectByGatewayOutConfigId(model);
        if (vo != null) {
            vo.setSpGatewayConfigVOList(spGatewayConfigList);
        }
        return vo;
    }

    /**
     * 增加sp接出分流网关配置
     */
    @Override
    public int addGatewayConfig(GatewayOutConfigModel model) {
        return spGatewayConfigDao.insertSpGatewayConfig(model);
    }

    /**
     * 删除sp接出分流网关配置
     */
    @Override
    public int deleteGatewayConfig(GatewayOutConfigModel model) {
        return spGatewayConfigDao.deleteSpGatewayConfigByPK(model.getIdList());
    }

    /**
     * 清除网关配置（全部删除）
     */
    @Override
    public int clearGatewayConfig(GatewayOutConfigModel model) {
        return spGatewayConfigDao.deleteSpGatewayConfig(model);
    }
}
