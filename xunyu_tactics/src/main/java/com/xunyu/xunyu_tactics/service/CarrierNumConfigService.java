package com.xunyu.xunyu_tactics.service;

import com.xunyu.xunyu_tactics.pojo.CarrierNumConfig;

import java.util.List;

/**
 * @author 
 * @description 
 * @date 2018/6/27 17:19
 */
public interface CarrierNumConfigService {

    /**
     * 删除
     */
    int deleteNums();

    /**
     * 批量插入
     */
    int batchInsert(List<CarrierNumConfig> list);

    /**
     * 查询
     */
    List<CarrierNumConfig> selectList();
}
