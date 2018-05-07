package com.xunyu.xunyu_tactics.service;

import com.xunyu.model.tactics.NormalWhitelistModel;
import com.xunyu.xunyu_tactics.pojo.NormalWhitelist;

import java.util.List;

/**
 * @author xym
 * @description 普通白名单service接口
 * @date 2018/5/7 13:46
 */
public interface NormalWhitelistService {

    /**
     * 添加
     */
    int insertWhitelist(NormalWhitelistModel model);

    /**
     * 删除
     */
    int deleteWhitelist(NormalWhitelistModel model);
    /**
     * 导入添加
     */
    int excelInsertWhitelist(List<NormalWhitelist> list);
    /**
     * 查询列表
     */
    List<NormalWhitelist> selectWhitelist(NormalWhitelistModel model);
    /**
     * 批量删除
     */
    int batchDeleteWhitelist(NormalWhitelistModel model);
    /**
     * 查询总条数
     */
    int selectTotalRows(NormalWhitelistModel model);
}
