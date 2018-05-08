package com.xunyu.xunyu_tactics.dao;

import com.commons.core.dao.impl.BaseDao;
import com.xunyu.model.tactics.SysInterceptKeywordModel;
import com.xunyu.xunyu_tactics.pojo.SysInterceptKeyword;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author xym
 * @description 系统拦截关键字dao实现
 * @date 2018/5/7 17:50
 */
@Repository
public class SysInterceptKeywordDaoImpl extends BaseDao {

    /**
     * 新增红名单
     */
    public int insertKeyword(SysInterceptKeywordModel model){
        return super.insert("com.xunyu.xunyu_tactics.pojo.SysInterceptKeyword.insertKeyword",model);
    }

    /**
     * 删除
     */
    public int deleteKeyword(SysInterceptKeywordModel model){
        return super.update("com.xunyu.xunyu_tactics.pojo.SysInterceptKeyword.deleteKeyword",model);

    }
    /**
     * 查询
     */
    public List<SysInterceptKeyword> selectKeywordList(SysInterceptKeywordModel model){
        return super.selectList("com.xunyu.xunyu_tactics.pojo.SysInterceptKeyword.selectKeywordList",model);

    }

    /**
     * 为列表查询提供条数查询
     */
    public int selectTotalRows(SysInterceptKeywordModel model){
        return super.selectOne("com.xunyu.xunyu_tactics.pojo.SysInterceptKeyword.selectTotalRows",model);

    }

    /**
     * 批量删除
     */
    public int batchDeleteKeyword(SysInterceptKeywordModel model){
        return super.update("com.xunyu.xunyu_tactics.pojo.SysInterceptKeyword.batchDeleteKeyword",model);

    }

    /**
     * 导入添加
     */
    public int excelAddKeyword(List<SysInterceptKeyword> list){
        return super.insert("com.xunyu.xunyu_tactics.pojo.SysInterceptKeyword.excelAddKeyword",list);

    }

    /**
     * 导入删除
     */
    public int excelDeleteKeyword(List<SysInterceptKeyword> list){
        return super.update("com.xunyu.xunyu_tactics.pojo.SysInterceptKeyword.excelDeleteKeyword",list);
    }

    /**
     * 检查内容关键字
     */
    public List<String> checkKeyword(SysInterceptKeywordModel model){
        return super.selectList("com.xunyu.xunyu_tactics.pojo.SysInterceptKeyword.checkKeyword",model);
    }

    public SysInterceptKeywordDaoImpl(SqlSessionFactory sqlSessionFactory) {
        super(sqlSessionFactory);
    }

    @Override
    public Class getClz() {
        return null;
    }
}
