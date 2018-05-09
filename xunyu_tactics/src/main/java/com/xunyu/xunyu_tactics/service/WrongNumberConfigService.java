package com.xunyu.xunyu_tactics.service;

import com.xunyu.model.tactics.WrongNumberConfigModel;
import com.xunyu.xunyu_tactics.pojo.WrongNumConfig;

import java.util.List;

/**
 * @author xym
 * @description 错号空号配置service接口
 * @date 2018/5/9 16:01
 */
public interface WrongNumberConfigService {

    /**
     * 添加
     * @param model
     * @return sql影响条数
     */
    int insertWrongNumber(WrongNumberConfigModel model);


    /**
     * 删除
     * @param model
     * @return sql影响条数
     */
    int deleteWrongNumber(WrongNumberConfigModel model);

    /**
     * 导入添加
     * @param list
     * @return sql影响条数
     */
    int excelInsertWrongNumber(List<WrongNumConfig> list);

    /**
     * 查询列表
     * @param model
     * @return 错号空号结果集
     */
    List<WrongNumConfig> selectWrongNumberList(WrongNumberConfigModel model);
    /**
     * 批量删除
     * @param model
     * @return sql影响条数
     */
    int batchDeleteWrongNumber(WrongNumberConfigModel model);
    /**
     * 查询总条数
     * @param model
     * @return 总条数
     */
    int selectTotalRows(WrongNumberConfigModel model);

}
