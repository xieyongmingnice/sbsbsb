package com.xunyu.xunyu_tactics.service.impl;

import com.xunyu.model.tactics.SysWhitelistKeywordModel;
import com.xunyu.xunyu_tactics.dao.SysWhitelistKeywordDaoImpl;
import com.xunyu.xunyu_tactics.pojo.SysWhitelistKeyword;
import com.xunyu.xunyu_tactics.service.SysWhitelistKeywordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xym
 * @description 系统白名单关键字管理service实现
 * @date 2018/5/8 15:11
 */
@Service
public class SysWhitelistKeywordServiceImpl implements SysWhitelistKeywordService {

    @Autowired
    SysWhitelistKeywordDaoImpl dao;

    @Override
    public int insertKeyword(SysWhitelistKeywordModel model) {
        return dao.insertKeyword(model);
    }

    @Override
    public int deleteKeyword(SysWhitelistKeywordModel model) {
        return dao.deleteKeyword(model);
    }

    @Override
    public List<SysWhitelistKeyword> selectKeywordList(SysWhitelistKeywordModel model) {
        return dao.selectKeywordList(model);
    }

    @Override
    public int selectTotalRows(SysWhitelistKeywordModel model) {
        return dao.selectTotalRows(model);
    }

    @Override
    public int batchDeleteKeyword(SysWhitelistKeywordModel model) {
        return dao.batchDeleteKeyword(model);
    }

    @Override
    public int excelAddKeyword(List<SysWhitelistKeyword> list) {
        return dao.excelAddKeyword(list);
    }

    @Override
    public List<String> checkKeyword(SysWhitelistKeywordModel model) {
        return dao.checkKeyword(model);
    }
}
