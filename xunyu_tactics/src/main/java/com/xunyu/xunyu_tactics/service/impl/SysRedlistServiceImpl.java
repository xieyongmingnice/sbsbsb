package com.xunyu.xunyu_tactics.service.impl;

import com.xunyu.model.tactics.SysRedlistModel;
import com.xunyu.xunyu_tactics.pojo.SysRedlist;
import com.xunyu.xunyu_tactics.service.SysRedlistService;
import com.xunyu.xunyu_tactics.vo.SysRedlistVO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xym
 * @description
 * @date 2018/4/28 12:45
 */
@Service
public class SysRedlistServiceImpl implements SysRedlistService{
    @Override
    public int addSysRedlist(SysRedlistModel model) {
        return 0;
    }

    @Override
    public int deleteSysRedlist(SysRedlistModel model) {
        return 0;
    }

    @Override
    public List<SysRedlistVO> selectSysRedlist(SysRedlistModel model) {
        return null;
    }

    @Override
    public int excelAddRedlist(List<SysRedlist> list) {
        return 0;
    }

    @Override
    public int excelDeleteRedlist(List<SysRedlist> list) {
        return 0;
    }


}
