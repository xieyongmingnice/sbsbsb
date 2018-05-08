package com.xunyu.xunyu_tactics.service.impl;

import com.xunyu.model.tactics.SysInterceptKeywordModel;
import com.xunyu.xunyu_tactics.dao.SysInterceptKeywordDaoImpl;
import com.xunyu.xunyu_tactics.pojo.SysInterceptKeyword;
import com.xunyu.xunyu_tactics.service.SysInterceptKeywordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xym
 * @description 系统拦截关键字 service实现
 * @date 2018/5/7 17:52
 */
@Service
public class SysInterceptKeywordServiceImpl implements SysInterceptKeywordService {

    @Autowired
    SysInterceptKeywordDaoImpl dao;

    @Override
    public int insertKeyword(SysInterceptKeywordModel model) {
        return dao.insertKeyword(model);
    }

    @Override
    public int deleteKeyword(SysInterceptKeywordModel model) {
        return dao.deleteKeyword(model);
    }

    @Override
    public List<SysInterceptKeyword> selectKeywordList(SysInterceptKeywordModel model) {
        return dao.selectKeywordList(model);
    }

    @Override
    public int selectTotalRows(SysInterceptKeywordModel model) {
        return dao.selectTotalRows(model);
    }

    @Override
    public int batchDeleteKeyword(SysInterceptKeywordModel model) {
        return dao.batchDeleteKeyword(model);
    }

    @Override
    public int excelAddKeyword(List<SysInterceptKeyword> list) {
        return dao.excelAddKeyword(list);
    }

    @Override
    public int excelDeleteKeyword(List<SysInterceptKeyword> list) {
        return dao.excelDeleteKeyword(list);
    }
}
