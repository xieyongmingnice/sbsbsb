package com.xunyu.xunyu_tactics.service;

import com.xunyu.model.tactics.SysRedlistModel;
import com.xunyu.xunyu_tactics.pojo.SysRedlist;
import com.xunyu.xunyu_tactics.vo.SysRedlistVO;

import java.util.List;

/**
 * @author xym
 * @description 系统红名单service接口
 * @date 2018/4/28 12:05
 */
public interface SysRedlistService {

    /**
     * 新增红名单
     */
    int addSysRedlist(SysRedlistModel model);

    /**
     * 删除
     */
    int deleteSysRedlist(SysRedlistModel model);
    /**
     * 查询
     */
    List<SysRedlistVO> selectSysRedlist(SysRedlistModel model);

    /**
     * 导入添加
     */
    int excelAddRedlist(List<SysRedlist> list);

    /**
     * 导入删除
     */
    int excelDeleteRedlist(List<SysRedlist> list);

    /**
     * 为列表查询提供条数查询
     */
    int selectTotalRows(SysRedlistModel model);

    /**
     * 批量删除
     */
    int batchDeleteRedlist(SysRedlistModel model);

}
