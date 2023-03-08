package com.example.dp.dao;

import com.example.dp.domain.JmeterTable;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface JmeterTableDAO {
    int deleteByPrimaryKey(String id);

    int insert(JmeterTable record);

    int insertSelective(JmeterTable record);

    JmeterTable selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(JmeterTable record);

    int updateByPrimaryKey(JmeterTable record);

    int getCountAll();

    List<JmeterTable> selectJmeterTablesPage(@Param("pageNum") int pageNum, @Param("pageSize")int pageSize);


    List<JmeterTable> selectJmeterTableAll();
}