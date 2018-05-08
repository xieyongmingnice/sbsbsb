package com.xunyu.xunyu_tactics.service.impl;

import com.xunyu.model.tactics.SysAuditKeywordModel;
import com.xunyu.xunyu_tactics.dao.SysAuditKeywordDaoImpl;
import com.xunyu.xunyu_tactics.pojo.SysAuditKeyword;
import com.xunyu.xunyu_tactics.service.SysAuditKeywordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xym
 * @description 系统拦截关键字service实现
 * @date 2018/5/8 17:40
 */
@Service
public class SysAuditKeywordServiceImpl implements SysAuditKeywordService {
    @Autowired
    SysAuditKeywordDaoImpl dao;

    @Override
    public int insertKeyword(SysAuditKeywordModel model) {
        return dao.insertKeyword(model);
    }

    @Override
    public int deleteKeyword(SysAuditKeywordModel model) {
        return dao.deleteKeyword(model);
    }

    @Override
    public List<SysAuditKeyword> selectKeywordList(SysAuditKeywordModel model) {
        return dao.selectKeywordList(model);
    }

    @Override
    public int selectTotalRows(SysAuditKeywordModel model) {
        return dao.selectTotalRows(model);
    }

    @Override
    public int batchDeleteKeyword(SysAuditKeywordModel model) {
        return dao.batchDeleteKeyword(model);
    }

    @Override
    public int excelAddKeyword(List<SysAuditKeyword> list) {
        return dao.excelAddKeyword(list);
    }

    @Override
    public int excelDeleteKeyword(List<SysAuditKeyword> list) {
        return dao.excelDeleteKeyword(list);
    }

    @Override
    public List<String> checkKeyword(SysAuditKeywordModel model) {
        return dao.checkKeyword(model);
    }
}
