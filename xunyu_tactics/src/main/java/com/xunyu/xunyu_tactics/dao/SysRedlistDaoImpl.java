package com.xunyu.xunyu_tactics.dao;

import com.commons.core.dao.impl.BaseDao;
import com.xunyu.model.tactics.SysRedlistModel;
import com.xunyu.xunyu_tactics.pojo.SysRedlist;
import com.xunyu.xunyu_tactics.vo.SysRedlistVO;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author xym
 * @description 系统红名单dao 实现
 * @date 2018/4/28 14:12
 */
@Repository
public class SysRedlistDaoImpl extends BaseDao {

    /**
     * 新增红名单
     */
    public int insertSysRedlist(SysRedlistModel model){
        return super.insert("com.xunyu.xunyu_tactics.pojo.insertSysRedlist",model);
    }

    /**
     * 删除
     */
    public int deleteSysRedlist(SysRedlistModel model){
        return super.delete("com.xunyu.xunyu_tactics.pojo.deleteSysRedlist",model);
    }
    /**
     * 查询
     */
    public List<SysRedlistVO> selectSysRedlist(SysRedlistModel model){
        return super.selectList("com.xunyu.xunyu_tactics.pojo.selectSysRedlist",model);
    }

    /**
     * 导入添加系统红名单
     */
    public int batchInsert(List<SysRedlist> list){
        return super.insert("com.xunyu.xunyu_tactics.pojo.batchInsert",list);
    }

    /**
     * 导入添加系统红名单
     */
    public int batchDelete(List<SysRedlist> list){
        return super.insert("com.xunyu.xunyu_tactics.pojo.batchDelete",list);
    }


    public SysRedlistDaoImpl(SqlSessionFactory sqlSessionFactory) {
        super(sqlSessionFactory);
    }

    @Override
    public Class getClz() {
        return null;
    }
}
