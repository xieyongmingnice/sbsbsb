package com.xunyu.xunyu_tactics.service.impl;

import com.xunyu.xunyu_tactics.dao.CarrierNumConfigDaoImpl;
import com.xunyu.xunyu_tactics.pojo.CarrierNumConfig;
import com.xunyu.xunyu_tactics.service.CarrierNumConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author xym
 * @description
 * @date 2018/6/27 18:12
 */
@Service
public class CarrierNumConfigServiceImpl implements CarrierNumConfigService {

    @Autowired
    CarrierNumConfigDaoImpl dao;

    /**
     * 删除
     */
    @Override
    public int deleteNums() {
        return dao.deleteNums();
    }

    /**
     * 批量插入 插入前进行删除
     * @param list
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int batchInsert(List<CarrierNumConfig> list) {
        //删除
        dao.deleteNums();
        //插入
        return dao.batchInsert(list);
    }

    @Override
    public List<CarrierNumConfig> selectList() {
        return dao.selectNums();
    }


}
