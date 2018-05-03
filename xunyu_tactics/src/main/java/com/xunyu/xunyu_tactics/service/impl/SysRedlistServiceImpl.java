package com.xunyu.xunyu_tactics.service.impl;

import com.xunyu.model.tactics.SysRedlistModel;
import com.xunyu.xunyu_tactics.dao.SysRedlistDaoImpl;
import com.xunyu.xunyu_tactics.pojo.SysRedlist;
import com.xunyu.xunyu_tactics.service.SysRedlistService;
import com.xunyu.xunyu_tactics.vo.SysRedlistVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xym
 * @description
 * @date 2018/4/28 12:45
 */
@Service
public class SysRedlistServiceImpl implements SysRedlistService{
    @Autowired
    SysRedlistDaoImpl dao;

    @Override
    public int addSysRedlist(SysRedlistModel model) {
        return dao.insertSysRedlist(model);
    }

    @Override
    public int deleteSysRedlist(SysRedlistModel model) {
        return dao.deleteSysRedlist(model);
    }

    @Override
    public List<SysRedlistVO> selectSysRedlist(SysRedlistModel model) {
        return dao.selectSysRedlist(model);
    }

    @Override
    public int excelAddRedlist(List<SysRedlist> list) {
        return dao.batchInsert(list);
    }

    @Override
    public int excelDeleteRedlist(List<SysRedlist> list) {
        return dao.batchDelete(list);
    }

    @Override
    public int selectTotalRows(SysRedlistModel model) {
        return dao.selectTotalRows(model);
    }

    @Override
    public int batchDeleteRedlist(SysRedlistModel model) {
        return dao.batchDeleteRedlist(model);
    }


}
