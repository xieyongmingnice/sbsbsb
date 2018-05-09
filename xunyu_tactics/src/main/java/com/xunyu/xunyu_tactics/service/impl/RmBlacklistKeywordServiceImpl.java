package com.xunyu.xunyu_tactics.service.impl;

import com.xunyu.model.tactics.RmBlacklistKeywordModel;
import com.xunyu.xunyu_tactics.dao.BlacklistKeywordDaoImpl;
import com.xunyu.xunyu_tactics.dao.RmBlacklistKeywordDaoImpl;
import com.xunyu.xunyu_tactics.pojo.RmBlacklistKeyword;
import com.xunyu.xunyu_tactics.service.RmBlacklistKeywordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xym
 * @description 回复去黑关键字 service实现
 * @date 2018/5/9 14:31
 */
@Service
public class RmBlacklistKeywordServiceImpl implements RmBlacklistKeywordService {

    @Autowired
    RmBlacklistKeywordDaoImpl dao;


    @Override
    public int insertKeyword(RmBlacklistKeywordModel model) {
        return dao.insertKeyword(model);
    }

    @Override
    public int deleteKeyword(RmBlacklistKeywordModel model) {
        return dao.deleteKeyword(model);
    }

    @Override
    public List<RmBlacklistKeyword> selectKeywordList(RmBlacklistKeywordModel model) {
        return dao.selectKeywordList(model);
    }

    @Override
    public int selectTotalRows(RmBlacklistKeywordModel model) {
        return dao.selectTotalRows(model);
    }

    @Override
    public int batchDeleteKeyword(RmBlacklistKeywordModel model) {
        return dao.batchDeleteKeyword(model);
    }

    @Override
    public int excelAddKeyword(List<RmBlacklistKeyword> list) {
        return dao.excelAddKeyword(list);
    }
}
