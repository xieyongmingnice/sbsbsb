package com.xunyu.xunyu_tactics.dao;

import com.commons.core.dao.impl.BaseDao;
import com.xunyu.model.tactics.WrongNumberConfigModel;
import com.xunyu.xunyu_tactics.pojo.WrongNumConfig;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author xym
 * @description 错号空号配置 dao实现
 * @date 2018/5/9 16:08
 */
@Repository
public class WrongNumberConfigDaoImpl extends BaseDao {

    /**
     * 添加
     * @param model
     * @return sql影响条数
     */
    public int insertWrongNumber(WrongNumberConfigModel model){
        return insert("com.xunyu.xunyu_tactics.pojo.WrongNumConfig.insertWrongNumber",model);
    }


    /**
     * 删除
     * @param model
     * @return sql影响条数
     */
    public int deleteWrongNumber(WrongNumberConfigModel model){
        return update("com.xunyu.xunyu_tactics.pojo.WrongNumConfig.deleteWrongNumber",model);
    }

    /**
     * 导入添加
     * @param list
     * @return sql影响条数
     */
    public int excelInsertWrongNumber(List<WrongNumConfig> list){
        return insert("com.xunyu.xunyu_tactics.pojo.WrongNumConfig.excelInsertWrongNumber",list);
    }

    /**
     * 查询列表
     * @param model
     * @return 错号空号结果集
     */
    public List<WrongNumConfig> selectWrongNumberList(WrongNumberConfigModel model){
        return selectList("com.xunyu.xunyu_tactics.pojo.WrongNumConfig.selectWrongNumberList",model);
    }
    /**
     * 批量删除
     * @param model
     * @return sql影响条数
     */
    public int batchDeleteWrongNumber(WrongNumberConfigModel model){
        return update("com.xunyu.xunyu_tactics.pojo.WrongNumConfig.batchDeleteWrongNumber",model);
    }
    /**
     * 查询总条数
     * @param model
     * @return 总条数
     */
    public int selectTotalRows(WrongNumberConfigModel model){
        return selectOne("com.xunyu.xunyu_tactics.pojo.WrongNumConfig.selectTotalRows",model);
    }

    public WrongNumberConfigDaoImpl(SqlSessionFactory sqlSessionFactory) {
        super(sqlSessionFactory);
    }

    @Override
    public Class getClz() {
        return null;
    }
}
