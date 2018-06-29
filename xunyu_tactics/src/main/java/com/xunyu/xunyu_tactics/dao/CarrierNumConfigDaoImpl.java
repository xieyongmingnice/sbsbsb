package com.xunyu.xunyu_tactics.dao;

import com.commons.core.dao.impl.BaseDao;
import com.xunyu.xunyu_tactics.pojo.CarrierNumConfig;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 
 * @description 
 * @date 2018/6/28 15:18
 */
@Repository
public class CarrierNumConfigDaoImpl extends BaseDao {


    /**
     * 删除
     */
    public int deleteNums(){
        return update("com.xunyu.xunyu_tactics.pojo.CarrierNumConfig.deleteNums");
    }

    /**
     * 批量插入
     */
    public int batchInsert(List<CarrierNumConfig> list){
        return insert("com.xunyu.xunyu_tactics.pojo.CarrierNumConfig.batchInsert",list);
    }

    /**
     * 查询
     */
    public List<CarrierNumConfig> selectNums(){
        return selectList("com.xunyu.xunyu_tactics.pojo.CarrierNumConfig.selectNums");
    }

    public CarrierNumConfigDaoImpl(SqlSessionFactory sqlSessionFactory) {
        super(sqlSessionFactory);
    }

    @Override
    public Class getClz() {
        return null;
    }
}
