package com.xunyu.xunyu_tactics.service;


import com.xunyu.model.tactics.SysAuditKeywordModel;
import com.xunyu.model.tactics.SysWhitelistKeywordModel;
import com.xunyu.xunyu_tactics.pojo.SysAuditKeyword;
import com.xunyu.xunyu_tactics.pojo.SysWhitelistKeyword;

import java.util.List;

/**
 * @author xym
 * @description 系统审核关键字管理service
 * @date 2018/5/8 15:11
 */
public interface SysAuditKeywordService {
    /**
     * 新增关键字
     */
    int insertKeyword(SysAuditKeywordModel model);

    /**
     * 删除
     */
    int deleteKeyword(SysAuditKeywordModel model);
    /**
     * 查询
     */
    List<SysAuditKeyword> selectKeywordList(SysAuditKeywordModel model);

    /**
     * 为列表查询提供条数查询
     */
    int selectTotalRows(SysAuditKeywordModel model);

    /**
     * 批量删除
     */
    int batchDeleteKeyword(SysAuditKeywordModel model);

    /**
     * 导入添加
     */
    int excelAddKeyword(List<SysAuditKeyword> list);

    /**
     * 导入删除
     */
    int excelDeleteKeyword(List<SysAuditKeyword> list);

    /**
     * 检查内容关键字
     * @return 内容中存在的关键字list
     */
    List<String> checkKeyword(SysAuditKeywordModel model);
}
