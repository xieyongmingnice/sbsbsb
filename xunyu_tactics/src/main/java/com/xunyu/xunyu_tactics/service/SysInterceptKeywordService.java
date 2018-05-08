package com.xunyu.xunyu_tactics.service;

import com.xunyu.model.tactics.SysInterceptKeywordModel;
import com.xunyu.xunyu_tactics.pojo.SysInterceptKeyword;

import java.util.List;

/**
 * @author xym
 * @description 系统拦截关键词service接口
 * @date 2018/5/7 17:43
 */
public interface SysInterceptKeywordService {

    /**
     * 新增红名单
     */
    int insertKeyword(SysInterceptKeywordModel model);

    /**
     * 删除
     */
    int deleteKeyword(SysInterceptKeywordModel model);
    /**
     * 查询
     */
    List<SysInterceptKeyword> selectKeywordList(SysInterceptKeywordModel model);

    /**
     * 为列表查询提供条数查询
     */
    int selectTotalRows(SysInterceptKeywordModel model);

    /**
     * 批量删除
     */
    int batchDeleteKeyword(SysInterceptKeywordModel model);

    /**
     * 导入添加
     */
    int excelAddKeyword(List<SysInterceptKeyword> list);

    /**
     * 导入删除
     */
    int excelDeleteKeyword(List<SysInterceptKeyword> list);

    /**
     * 检查内容关键字
     * @return 内容中存在的关键字list
     */
    List<String> checkKeyword(SysInterceptKeywordModel model);

}
