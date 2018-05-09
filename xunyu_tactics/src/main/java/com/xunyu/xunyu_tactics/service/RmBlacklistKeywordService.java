package com.xunyu.xunyu_tactics.service;

import com.xunyu.model.tactics.RmBlacklistKeywordModel;
import com.xunyu.xunyu_tactics.pojo.RmBlacklistKeyword;

import java.util.List;

/**
 * @author xym
 * @description 回复去黑关键词service接口
 * @date 2018/5/9 14:24
 */
public interface RmBlacklistKeywordService {

    /**
     * 新增关键字
     */
    int insertKeyword(RmBlacklistKeywordModel model);

    /**
     * 删除
     */
    int deleteKeyword(RmBlacklistKeywordModel model);
    /**
     * 查询
     */
    List<RmBlacklistKeyword> selectKeywordList(RmBlacklistKeywordModel model);

    /**
     * 为列表查询提供条数查询
     */
    int selectTotalRows(RmBlacklistKeywordModel model);

    /**
     * 批量删除
     */
    int batchDeleteKeyword(RmBlacklistKeywordModel model);

    /**
     * 导入添加
     */
    int excelAddKeyword(List<RmBlacklistKeyword> list);

}
