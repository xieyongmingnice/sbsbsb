package com.xunyu.system.dao.errcode;

import com.commons.core.dao.impl.BaseDao;
import com.xunyu.system.pojo.errcode.ErrorCode;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author dth
 * @date 2018/5/2 16:06
 **/
@Repository
public class ErrCodeDaoImpl extends BaseDao<ErrorCode,Long> {
    public ErrCodeDaoImpl(SqlSessionFactory sqlSessionFactory) {
        super(sqlSessionFactory);
    }

    @Override
    public Class<ErrorCode> getClz() {
        return ErrorCode.class;
    }

    /**
     * 添加
     */
    public int addErrCodeConfig(ErrorCode ec){
        return super.insert("com.xunyu.system.pojo.errcode.ErrorCode.addErrCodeConfig",ec);
    }

    /**
     * 修改
     */
    public int updateErrCodeConfig(ErrorCode ec){
        return super.update("com.xunyu.system.pojo.errcode.ErrorCode.updateErrCodeConfig",ec);
    }

    /**
     * 删除
     */
    public int delErrCodeConfig(Map<String,Object> map){
        return super.update("com.xunyu.system.pojo.errcode.ErrorCode.delErrCodeConfig",map);
    }

    /**
     * 详情
     */
    public ErrorCode getErrCodeConfigDetail(Map<String,Object> map){
        return super.selectForObject("com.xunyu.system.pojo.errcode.ErrorCode.getErrCodeConfigDetail",map);
    }

    /**
     * 列表
     */
    public int errCodeConfigCount(Map<String,Object> map){
        return super.selectForObject("com.xunyu.system.pojo.errcode.ErrorCode.errCodeConfigCount",map);
    }
    public List<ErrorCode> errCodeConfigList(Map<String,Object> map){
        return super.selectForListObject("com.xunyu.system.pojo.errcode.ErrorCode.errCodeConfigList",map);
    }
}
