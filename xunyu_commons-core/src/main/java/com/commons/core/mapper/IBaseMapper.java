package com.commons.core.mapper;

import com.commons.core.sql.dto.DataRecord;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.StatementType;

import java.util.List;
import java.util.Map;


public interface IBaseMapper {
    /**
     * 插入单条
     *
     * @param params
     */
    @Insert("${sql}")
    @SelectKey(before = false, keyProperty = "id", resultType = Long.class, statementType = StatementType.STATEMENT, statement = "SELECT LAST_INSERT_ID() AS id")
    Integer insert(Map<String, Object> params);

    @Update("${sql}")
    int update(Map<String, Object> params);

    @Delete("${sql}")
    int delete(Map<String, Object> params);

    @Select("${sql}")
    List<DataRecord> select(Map<String, Object> params);

    @Select("${sql}")
    <T> T selectOne(Map<String, Object> params);

    @Select("${sql}")
    DataRecord selectObject(Map<String, Object> params);

    /**
     * 批量插入
     *
     * @param params
     * @return
     */
    @Insert("${sql}")
    int insertBatch(Map<String, Object> params);

}
