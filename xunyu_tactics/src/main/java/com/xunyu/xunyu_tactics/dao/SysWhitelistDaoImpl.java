package com.xunyu.xunyu_tactics.dao;

import com.commons.core.dao.impl.BaseDao;
import com.xunyu.model.tactics.SysWhitelistModel;
import com.xunyu.xunyu_tactics.pojo.SysWhitelist;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author xym
 * @description 系统白名单dao实现
 * @date 2018/5/3 17:07
 */
@Repository
public class SysWhitelistDaoImpl extends BaseDao{

    /**
     * 添加
     */
    public int insertWhitelist(SysWhitelistModel model){
        return super.insert("com.xunyu.xunyu_tactics.pojo.SysWhitelist.insertWhitelist",model);
    }

    /**
     * 删除
     */
    public int deleteWhitelist(SysWhitelistModel model){
        return super.update("com.xunyu.xunyu_tactics.pojo.SysWhitelist.deleteWhitelist",model);
    }
    /**
     * 导入添加
     */
    public int excelInsertWhitelist(List<SysWhitelist> list){
        return super.insert("com.xunyu.xunyu_tactics.pojo.SysWhitelist.excelInsertWhitelist",list);
    }
    /**
     * 查询列表
     */
    public List<SysWhitelist> selectWhitelist(SysWhitelistModel model){
        return super.selectList("com.xunyu.xunyu_tactics.pojo.SysWhitelist.selectWhitelist",model);
    }
    /**
     * 批量删除
     */
    public int batchDeleteWhitelist(SysWhitelistModel model){
        return super.update("com.xunyu.xunyu_tactics.pojo.SysWhitelist.batchDeleteWhitelist",model);
    }
    /**
     * 查询总条数
     */
    public int selectTotalRows(SysWhitelistModel model){
        return super.selectOne("com.xunyu.xunyu_tactics.pojo.SysWhitelist.selectTotalRows",model);
    }


    public SysWhitelistDaoImpl(SqlSessionFactory sqlSessionFactory) {
        super(sqlSessionFactory);
    }

    @Override
    public Class getClz() {
        return null;
    }
}
