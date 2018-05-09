package com.xunyu.xunyu_tactics.dao;

import com.commons.core.dao.impl.BaseDao;
import com.xunyu.model.tactics.BlacklistKeywordModel;
import com.xunyu.model.tactics.SysInterceptKeywordModel;
import com.xunyu.xunyu_tactics.pojo.BlacklistKeyword;
import com.xunyu.xunyu_tactics.pojo.SysInterceptKeyword;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author xym
 * @description 回复加黑关键字dao实现
 * @date 2018/5/9 10:56
 */
@Repository
public class BlacklistKeywordDaoImpl extends BaseDao {

    /**
     * 新增红名单
     */
    public int insertKeyword(BlacklistKeywordModel model){
        return super.insert("com.xunyu.xunyu_tactics.pojo.BlacklistKeyword.insertKeyword",model);
    }

    /**
     * 删除
     */
    public int deleteKeyword(BlacklistKeywordModel model){
        return super.update("com.xunyu.xunyu_tactics.pojo.BlacklistKeyword.deleteKeyword",model);

    }
    /**
     * 查询
     */
    public List<BlacklistKeyword> selectKeywordList(BlacklistKeywordModel model){
        return super.selectList("com.xunyu.xunyu_tactics.pojo.BlacklistKeyword.selectKeywordList",model);

    }

    /**
     * 为列表查询提供条数查询
     */
    public int selectTotalRows(BlacklistKeywordModel model){
        return super.selectOne("com.xunyu.xunyu_tactics.pojo.BlacklistKeyword.selectTotalRows",model);

    }

    /**
     * 批量删除
     */
    public int batchDeleteKeyword(BlacklistKeywordModel model){
        return super.update("com.xunyu.xunyu_tactics.pojo.BlacklistKeyword.batchDeleteKeyword",model);

    }

    /**
     * 导入添加
     */
    public int excelAddKeyword(List<BlacklistKeyword> list){
        return super.insert("com.xunyu.xunyu_tactics.pojo.BlacklistKeyword.excelAddKeyword",list);

    }

    public BlacklistKeywordDaoImpl(SqlSessionFactory sqlSessionFactory) {
        super(sqlSessionFactory);
    }

    @Override
    public Class getClz() {
        return null;
    }
}
