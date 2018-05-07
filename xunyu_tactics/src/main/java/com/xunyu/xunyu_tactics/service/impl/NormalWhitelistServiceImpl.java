package com.xunyu.xunyu_tactics.service.impl;

import com.xunyu.model.tactics.NormalWhitelistModel;
import com.xunyu.xunyu_tactics.dao.NormalWhitelistDaoImpl;
import com.xunyu.xunyu_tactics.pojo.NormalWhitelist;
import com.xunyu.xunyu_tactics.service.NormalWhitelistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xym
 * @description 普通白名单service实现
 * @date 2018/5/7 13:46
 */
@Service
public class NormalWhitelistServiceImpl implements NormalWhitelistService{

    @Autowired
    NormalWhitelistDaoImpl dao;

    @Override
    public int insertWhitelist(NormalWhitelistModel model) {
        return dao.insertWhitelist(model);
    }

    @Override
    public int deleteWhitelist(NormalWhitelistModel model) {
        return dao.deleteWhitelist(model);
    }

    @Override
    public int excelInsertWhitelist(List<NormalWhitelist> list) {
        return dao.excelInsertWhitelist(list);
    }

    @Override
    public List<NormalWhitelist> selectWhitelist(NormalWhitelistModel model) {
        return dao.selectWhitelist(model);
    }

    @Override
    public int batchDeleteWhitelist(NormalWhitelistModel model) {
        return dao.batchDeleteWhitelist(model);
    }

    @Override
    public int selectTotalRows(NormalWhitelistModel model) {
        return dao.selectTotalRows(model);
    }
}
