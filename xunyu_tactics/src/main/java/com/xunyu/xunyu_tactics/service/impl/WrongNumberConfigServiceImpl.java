package com.xunyu.xunyu_tactics.service.impl;

import com.xunyu.model.tactics.WrongNumberConfigModel;
import com.xunyu.xunyu_tactics.dao.WrongNumberConfigDaoImpl;
import com.xunyu.xunyu_tactics.pojo.WrongNumConfig;
import com.xunyu.xunyu_tactics.service.WrongNumberConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * @author xym
 * @description 错号空号配置service实现
 * @date 2018/5/9 16:01
 */
@Service
public class WrongNumberConfigServiceImpl implements WrongNumberConfigService {

    @Autowired
    WrongNumberConfigDaoImpl dao;

    @Override
    public int insertWrongNumber(WrongNumberConfigModel model) {
        return dao.insertWrongNumber(model);
    }

    @Override
    public int deleteWrongNumber(WrongNumberConfigModel model) {
        return dao.deleteWrongNumber(model);
    }

    @Override
    public int excelInsertWrongNumber(List<WrongNumConfig> list) {
        return dao.excelInsertWrongNumber(list);
    }

    @Override
    public List<WrongNumConfig> selectWrongNumberList(WrongNumberConfigModel model) {
        return dao.selectWrongNumberList(model);
    }

    @Override
    public int batchDeleteWrongNumber(WrongNumberConfigModel model) {
        return dao.batchDeleteWrongNumber(model);
    }

    @Override
    public int selectTotalRows(WrongNumberConfigModel model) {
        return dao.selectTotalRows(model);
    }
}
