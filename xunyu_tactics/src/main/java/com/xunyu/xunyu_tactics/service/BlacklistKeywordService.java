package com.xunyu.xunyu_tactics.service;

import com.xunyu.model.tactics.BlacklistKeywordModel;
import com.xunyu.model.tactics.SysInterceptKeywordModel;
import com.xunyu.xunyu_tactics.pojo.BlacklistKeyword;
import com.xunyu.xunyu_tactics.pojo.SysInterceptKeyword;

import java.util.List;

/**
 * @author xym
 * @description 系统拦截关键词service接口
 * @date 2018/5/7 17:43
 */
public interface BlacklistKeywordService {

    /**
     * 新增关键字
     */
    int insertKeyword(BlacklistKeywordModel model);

    /**
     * 删除
     */
    int deleteKeyword(BlacklistKeywordModel model);
    /**
     * 查询
     */
    List<BlacklistKeyword> selectKeywordList(BlacklistKeywordModel model);

    /**
     * 为列表查询提供条数查询
     */
    int selectTotalRows(BlacklistKeywordModel model);

    /**
     * 批量删除
     */
    int batchDeleteKeyword(BlacklistKeywordModel model);

    /**
     * 导入添加
     */
    int excelAddKeyword(List<BlacklistKeyword> list);

}
