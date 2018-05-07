package com.xunyu.xunyu_tactics.dao;

import com.commons.core.dao.impl.BaseDao;
import com.xunyu.model.tactics.NormalWhitelistModel;
import com.xunyu.xunyu_tactics.pojo.NormalWhitelist;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author xym
 * @description 普通白名单dao实现
 * @date 2018/5/7 13:44
 */
@Repository
public class NormalWhitelistDaoImpl extends BaseDao{

    /**
     * 添加
     */
    public int insertWhitelist(NormalWhitelistModel model){
        return super.insert("com.xunyu.xunyu_tactics.pojo.NormalWhitelist.insertWhitelist",model);
    }

    /**
     * 删除
     */
    public int deleteWhitelist(NormalWhitelistModel model){
        return super.update("com.xunyu.xunyu_tactics.pojo.NormalWhitelist.deleteWhitelist",model);
    }
    /**
     * 导入添加
     */
    public int excelInsertWhitelist(List<NormalWhitelist> list){
        return super.insert("com.xunyu.xunyu_tactics.pojo.NormalWhitelist.excelInsertWhitelist",list);
    }
    /**
     * 查询列表
     */
    public List<NormalWhitelist> selectWhitelist(NormalWhitelistModel model){
        return super.selectList("com.xunyu.xunyu_tactics.pojo.NormalWhitelist.selectWhitelist",model);
    }
    /**
     * 批量删除
     */
    public int batchDeleteWhitelist(NormalWhitelistModel model){
        return super.update("com.xunyu.xunyu_tactics.pojo.NormalWhitelist.batchDeleteWhitelist",model);
    }
    /**
     * 查询总条数
     */
    public int selectTotalRows(NormalWhitelistModel model){
        return super.selectOne("com.xunyu.xunyu_tactics.pojo.NormalWhitelist.selectTotalRows",model);
    }

    public NormalWhitelistDaoImpl(SqlSessionFactory sqlSessionFactory) {
        super(sqlSessionFactory);
    }

    @Override
    public Class getClz() {
        return null;
    }
}
