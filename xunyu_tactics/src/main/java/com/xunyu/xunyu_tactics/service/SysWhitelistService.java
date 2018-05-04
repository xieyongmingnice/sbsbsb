package com.xunyu.xunyu_tactics.service;

import com.xunyu.model.tactics.SysWhitelistModel;
import com.xunyu.xunyu_tactics.pojo.SysWhitelist;

import java.util.List;

/**
 * @author xym
 * @description 系统白名单service接口
 * @date 2018/5/3 17:07
 */
public interface SysWhitelistService {

    /**
     * 添加
     */
    int insertWhitelist(SysWhitelistModel model);

    /**
     * 删除
     */
    int deleteWhitelist(SysWhitelistModel model);
    /**
     * 导入添加
     */
    int excelInsertWhitelist(List<SysWhitelist> list);
    /**
     * 查询列表
     */
    List<SysWhitelist> selectWhitelist(SysWhitelistModel model);
    /**
     * 批量删除
     */
    int batchDeleteWhitelist(SysWhitelistModel model);
    /**
     * 查询总条数
     */
    int selectTotalRows(SysWhitelistModel model);

}
