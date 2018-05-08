package com.xunyu.xunyu_tactics.dao;

import com.commons.core.dao.impl.BaseDao;
import com.xunyu.model.tactics.SysWhitelistKeywordModel;
import com.xunyu.xunyu_tactics.pojo.SysWhitelistKeyword;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author xym
 * @description 系统白名单关键字管理dao实现
 * @date 2018/5/8 15:11
 */
@Repository
public class SysWhitelistKeywordDaoImpl extends BaseDao{

    /**
     * 新增关键字
     */
    public int insertKeyword(SysWhitelistKeywordModel model){
        return super.insert("com.xunyu.xunyu_tactics.pojo.SysWhitelistKeyword.insertKeyword",model);
    }

    /**
     * 删除
     */
    public int deleteKeyword(SysWhitelistKeywordModel model){
        return super.update("com.xunyu.xunyu_tactics.pojo.SysWhitelistKeyword.deleteKeyword",model);
    }
    /**
     * 查询
     */
    public List<SysWhitelistKeyword> selectKeywordList(SysWhitelistKeywordModel model){
        return super.selectList("com.xunyu.xunyu_tactics.pojo.SysWhitelistKeyword.selectKeywordList",model);
    }

    /**
     * 为列表查询提供条数查询
     */
    public int selectTotalRows(SysWhitelistKeywordModel model){
        return super.selectOne("com.xunyu.xunyu_tactics.pojo.SysWhitelistKeyword.selectTotalRows",model);
    }

    /**
     * 批量删除
     */
    public int batchDeleteKeyword(SysWhitelistKeywordModel model){
        return super.update("com.xunyu.xunyu_tactics.pojo.SysWhitelistKeyword.batchDeleteKeyword",model);
    }

    /**
     * 导入添加
     */
    public int excelAddKeyword(List<SysWhitelistKeyword> list){
        return super.insert("com.xunyu.xunyu_tactics.pojo.SysWhitelistKeyword.excelAddKeyword",list);
    }

    /**
     * 检查内容关键字
     * @return 内容中存在的关键字list
     */
    public List<String> checkKeyword(SysWhitelistKeywordModel model){
        return super.selectList("com.xunyu.xunyu_tactics.pojo.SysWhitelistKeyword.checkKeyword",model);
    }


    public SysWhitelistKeywordDaoImpl(SqlSessionFactory sqlSessionFactory) {
        super(sqlSessionFactory);
    }

    @Override
    public Class getClz() {
        return null;
    }
}
