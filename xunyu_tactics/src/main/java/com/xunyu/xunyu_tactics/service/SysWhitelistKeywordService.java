package com.xunyu.xunyu_tactics.service;


import com.xunyu.model.tactics.SysWhitelistKeywordModel;
import com.xunyu.xunyu_tactics.pojo.SysWhitelistKeyword;

import java.util.List;

/**
 * @author xym
 * @description 系统白名单关键字管理service
 * @date 2018/5/8 15:11
 */
public interface SysWhitelistKeywordService {
    /**
     * 新增关键字
     */
    int insertKeyword(SysWhitelistKeywordModel model);

    /**
     * 删除
     */
    int deleteKeyword(SysWhitelistKeywordModel model);
    /**
     * 查询
     */
    List<SysWhitelistKeyword> selectKeywordList(SysWhitelistKeywordModel model);

    /**
     * 为列表查询提供条数查询
     */
    int selectTotalRows(SysWhitelistKeywordModel model);

    /**
     * 批量删除
     */
    int batchDeleteKeyword(SysWhitelistKeywordModel model);

    /**
     * 导入添加
     */
    int excelAddKeyword(List<SysWhitelistKeyword> list);


    /**
     * 检查内容关键字
     * @return 内容中存在的关键字list
     */
    List<String> checkKeyword(SysWhitelistKeywordModel model);
}
