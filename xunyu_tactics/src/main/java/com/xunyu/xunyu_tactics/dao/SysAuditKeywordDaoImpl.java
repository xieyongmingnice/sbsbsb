package com.xunyu.xunyu_tactics.dao;

import com.commons.core.dao.impl.BaseDao;
import com.xunyu.model.tactics.SysAuditKeywordModel;
import com.xunyu.model.tactics.SysWhitelistKeywordModel;
import com.xunyu.xunyu_tactics.pojo.SysAuditKeyword;
import com.xunyu.xunyu_tactics.pojo.SysWhitelistKeyword;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author xym
 * @description 系统审核关键字管理dao实现
 * @date 2018/5/8 15:11
 */
@Repository
public class SysAuditKeywordDaoImpl extends BaseDao{

    /**
     * 新增关键字
     */
    public int insertKeyword(SysAuditKeywordModel model){
        return super.insert("com.xunyu.xunyu_tactics.pojo.SysAuditKeyword.insertKeyword",model);
    }

    /**
     * 删除
     */
    public int deleteKeyword(SysAuditKeywordModel model){
        return super.update("com.xunyu.xunyu_tactics.pojo.SysAuditKeyword.deleteKeyword",model);
    }
    /**
     * 查询
     */
    public List<SysAuditKeyword> selectKeywordList(SysAuditKeywordModel model){
        return super.selectList("com.xunyu.xunyu_tactics.pojo.SysAuditKeyword.selectKeywordList",model);
    }

    /**
     * 为列表查询提供条数查询
     */
    public int selectTotalRows(SysAuditKeywordModel model){
        return super.selectOne("com.xunyu.xunyu_tactics.pojo.SysAuditKeyword.selectTotalRows",model);
    }

    /**
     * 批量删除
     */
    public int batchDeleteKeyword(SysAuditKeywordModel model){
        return super.update("com.xunyu.xunyu_tactics.pojo.SysAuditKeyword.batchDeleteKeyword",model);
    }

    /**
     * 导入添加
     */
    public int excelAddKeyword(List<SysAuditKeyword> list){
        return super.insert("com.xunyu.xunyu_tactics.pojo.SysAuditKeyword.excelAddKeyword",list);
    }

    /**
     * 导入删除
     */
    public int excelDeleteKeyword(List<SysAuditKeyword> list){
        return super.update("com.xunyu.xunyu_tactics.pojo.SysAuditKeyword.excelDeleteKeyword",list);
    }

    /**
     * 检查内容关键字
     * @return 内容中存在的关键字list
     */
    public List<String> checkKeyword(SysAuditKeywordModel model){
        return super.selectList("com.xunyu.xunyu_tactics.pojo.SysAuditKeyword.checkKeyword",model);
    }


    public SysAuditKeywordDaoImpl(SqlSessionFactory sqlSessionFactory) {
        super(sqlSessionFactory);
    }

    @Override
    public Class getClz() {
        return null;
    }
}
