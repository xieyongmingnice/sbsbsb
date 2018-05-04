package com.xunyu.xunyu_tactics.service;

import com.xunyu.model.tactics.NormalBlacklistModel;
import com.xunyu.xunyu_tactics.pojo.NormalBlacklist;
import com.xunyu.xunyu_tactics.vo.NormalBlacklistVO;

import java.util.List;

/**
 * @author xym
 * @description 黑名单service接口
 * @date 2018/5/4 17:12
 */
public interface NormalBlacklistService {

    /**
     * 新增红名单
     */
    int addBlacklist(NormalBlacklistModel model);

    /**
     * 删除
     */
    int deleteBlacklist(NormalBlacklistModel model);
    /**
     * 查询
     */
    List<NormalBlacklistVO> selectBlacklist(NormalBlacklistModel model);

    /**
     * 为列表查询提供条数查询
     */
    int selectTotalRows(NormalBlacklistModel model);

    /**
     * 批量删除
     */
    int batchDeleteBlacklist(NormalBlacklistModel model);

    /**
     * 导入添加
     */
    int excelAddBlacklist(List<NormalBlacklist> list);

    /**
     * 导入删除
     */
    int excelDeleteBlacklist(List<NormalBlacklist> list);
}
