package com.xunyu.xunyu_tactics.service.impl;

import com.xunyu.model.tactics.SysWhitelistModel;
import com.xunyu.xunyu_tactics.dao.SysWhitelistDaoImpl;
import com.xunyu.xunyu_tactics.pojo.SysWhitelist;
import com.xunyu.xunyu_tactics.service.SysWhitelistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xym
 * @description 系统白名单service实现
 * @date 2018/5/3 18:39
 */
@Service
public class SysWhitelistServiceImpl implements SysWhitelistService {

    @Autowired
    SysWhitelistDaoImpl dao;

    @Override
    public int insertWhitelist(SysWhitelistModel model) {
        return dao.insertWhitelist(model);
    }

    @Override
    public int deleteWhitelist(SysWhitelistModel model) {
        return dao.deleteWhitelist(model);
    }

    @Override
    public int excelInsertWhitelist(List<SysWhitelist> list) {
        return dao.excelInsertWhitelist(list);
    }

    @Override
    public List<SysWhitelist> selectWhitelist(SysWhitelistModel model) {
        return dao.selectWhitelist(model);
    }

    @Override
    public int batchDeleteWhitelist(SysWhitelistModel model) {
        return dao.batchDeleteWhitelist(model);
    }

    @Override
    public int selectTotalRows(SysWhitelistModel model) {
        return dao.selectTotalRows(model);
    }
}
