package com.xunyu.xunyu_tactics.service.impl;

import com.xunyu.model.tactics.NormalBlacklistModel;
import com.xunyu.xunyu_tactics.dao.NormalBlacklistDaoImpl;
import com.xunyu.xunyu_tactics.pojo.NormalBlacklist;
import com.xunyu.xunyu_tactics.service.NormalBlacklistService;
import com.xunyu.xunyu_tactics.vo.NormalBlacklistVO;
import com.xunyu.xunyu_tactics.vo.SysRedlistVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xym
 * @description 黑名单业务方法实现
 * @date 2018/5/4 17:16
 */
@Service
public class NormalBlacklistServiceImpl implements NormalBlacklistService{

    @Autowired
    NormalBlacklistDaoImpl dao;

    @Override
    public int addBlacklist(NormalBlacklistModel model) {
        return dao.addBlacklist(model);
    }

    @Override
    public int deleteBlacklist(NormalBlacklistModel model) {
        return dao.deleteBlacklist(model);
    }

    @Override
    public List<NormalBlacklistVO> selectBlacklist(NormalBlacklistModel model) {
        return dao.selectBlacklist(model);
    }

    @Override
    public int selectTotalRows(NormalBlacklistModel model) {
        return dao.selectTotalRows(model);
    }

    @Override
    public int batchDeleteBlacklist(NormalBlacklistModel model) {
        return dao.batchDeleteBlacklist(model);
    }

    @Override
    public int excelAddBlacklist(List<NormalBlacklist> list) {
        return dao.excelAddBlacklist(list);
    }

    @Override
    public int excelDeleteBlacklist(List<NormalBlacklist> list) {
        return dao.excelDeleteBlacklist(list);
    }
}
