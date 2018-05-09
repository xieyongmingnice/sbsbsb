package com.xunyu.xunyu_tactics.dao;

import com.commons.core.dao.impl.BaseDao;
import com.xunyu.model.tactics.BlacklistKeywordModel;
import com.xunyu.model.tactics.RmBlacklistKeywordModel;
import com.xunyu.xunyu_tactics.pojo.BlacklistKeyword;
import com.xunyu.xunyu_tactics.pojo.RmBlacklistKeyword;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author xym
 * @description 回复去黑关键字 dao实现
 * @date 2018/5/9 14:31
 */
@Repository
public class RmBlacklistKeywordDaoImpl extends BaseDao {

    /**
     * 新增红名单
     */
    public int insertKeyword(RmBlacklistKeywordModel model){
        return super.insert("com.xunyu.xunyu_tactics.pojo.RmBlacklistKeyword.insertKeyword",model);
    }

    /**
     * 删除
     */
    public int deleteKeyword(RmBlacklistKeywordModel model){
        return super.update("com.xunyu.xunyu_tactics.pojo.RmBlacklistKeyword.deleteKeyword",model);

    }
    /**
     * 查询
     */
    public List<RmBlacklistKeyword> selectKeywordList(RmBlacklistKeywordModel model){
        return super.selectList("com.xunyu.xunyu_tactics.pojo.RmBlacklistKeyword.selectKeywordList",model);

    }

    /**
     * 为列表查询提供条数查询
     */
    public int selectTotalRows(RmBlacklistKeywordModel model){
        return super.selectOne("com.xunyu.xunyu_tactics.pojo.RmBlacklistKeyword.selectTotalRows",model);

    }

    /**
     * 批量删除
     */
    public int batchDeleteKeyword(RmBlacklistKeywordModel model){
        return super.update("com.xunyu.xunyu_tactics.pojo.RmBlacklistKeyword.batchDeleteKeyword",model);

    }

    /**
     * 导入添加
     */
    public int excelAddKeyword(List<RmBlacklistKeyword> list){
        return super.insert("com.xunyu.xunyu_tactics.pojo.RmBlacklistKeyword.excelAddKeyword",list);

    }

    public RmBlacklistKeywordDaoImpl(SqlSessionFactory sqlSessionFactory) {
        super(sqlSessionFactory);
    }

    @Override
    public Class getClz() {
        return null;
    }
}
