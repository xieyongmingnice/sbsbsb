package com.xunyu.xunyu_tactics.dao;

import com.commons.core.dao.impl.BaseDao;
import com.xunyu.model.tactics.NormalBlacklistModel;
import com.xunyu.xunyu_tactics.pojo.NormalBlacklist;
import com.xunyu.xunyu_tactics.vo.NormalBlacklistVO;
import com.xunyu.xunyu_tactics.vo.SysRedlistVO;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author xym
 * @description 黑名单dao实现
 * @date 2018/5/4 17:17
 */
@Repository
public class NormalBlacklistDaoImpl extends BaseDao{

    /**
     * 新增红名单
     */
    public int addBlacklist(NormalBlacklistModel model){
        return super.insert("com.xunyu.xunyu_tactics.pojo.NormalBlacklist.addBlacklist",model);
    }

    /**
     * 删除
     */
    public int deleteBlacklist(NormalBlacklistModel model){
        return super.update("com.xunyu.xunyu_tactics.pojo.NormalBlacklist.deleteBlacklist",model);
    }
    /**
     * 查询列表
     */
    public  List<NormalBlacklistVO> selectBlacklist(NormalBlacklistModel model){
        return super.selectList("com.xunyu.xunyu_tactics.pojo.NormalBlacklist.selectBlacklist",model);
    }

    /**
     * 为列表查询提供条数查询
     */
    public int selectTotalRows(NormalBlacklistModel model){
        return super.selectOne("com.xunyu.xunyu_tactics.pojo.NormalBlacklist.selectTotalRows",model);
    }

    /**
     * 批量删除
     */
    public int batchDeleteBlacklist(NormalBlacklistModel model){
        return super.update("com.xunyu.xunyu_tactics.pojo.NormalBlacklist.batchDeleteBlacklist",model);
    }

    /**
     * 导入添加
     */
    public int excelAddBlacklist(List<NormalBlacklist> list){
        return super.insert("com.xunyu.xunyu_tactics.pojo.NormalBlacklist.excelAddBlacklist",list);
    }

    /**
     * 导入删除
     */
    public int excelDeleteBlacklist(List<NormalBlacklist> list){
        return super.insert("com.xunyu.xunyu_tactics.pojo.NormalBlacklist.excelDeleteBlacklist",list);
    }

    public NormalBlacklistDaoImpl(SqlSessionFactory sqlSessionFactory) {
        super(sqlSessionFactory);
    }

    @Override
    public Class getClz() {
        return null;
    }
}
