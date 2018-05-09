package com.xunyu.xunyu_tactics.service.impl;

import com.xunyu.model.tactics.BlacklistKeywordModel;
import com.xunyu.xunyu_tactics.dao.BlacklistKeywordDaoImpl;
import com.xunyu.xunyu_tactics.pojo.BlacklistKeyword;
import com.xunyu.xunyu_tactics.service.BlacklistKeywordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xym
 * @description 回复加黑关键字 service实现
 * @date 2018/5/9 10:52
 */
@Service
public class BlacklistKeywordServiceImpl implements BlacklistKeywordService {

    @Autowired
    BlacklistKeywordDaoImpl dao;


    @Override
    public int insertKeyword(BlacklistKeywordModel model) {
        return dao.insertKeyword(model);
    }

    @Override
    public int deleteKeyword(BlacklistKeywordModel model) {
        return dao.deleteKeyword(model);
    }

    @Override
    public List<BlacklistKeyword> selectKeywordList(BlacklistKeywordModel model) {
        return dao.selectKeywordList(model);
    }

    @Override
    public int selectTotalRows(BlacklistKeywordModel model) {
        return dao.selectTotalRows(model);
    }

    @Override
    public int batchDeleteKeyword(BlacklistKeywordModel model) {
        return dao.batchDeleteKeyword(model);
    }

    @Override
    public int excelAddKeyword(List<BlacklistKeyword> list) {
        return dao.excelAddKeyword(list);
    }
}
