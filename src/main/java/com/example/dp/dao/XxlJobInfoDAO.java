package com.example.dp.dao;

import com.example.dp.domain.XxlJobInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface XxlJobInfoDAO {
    int deleteByPrimaryKey(Integer id);

    int insert(XxlJobInfo record);

    int insertSelective(XxlJobInfo record);

    XxlJobInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(XxlJobInfo record);

    int updateByPrimaryKey(XxlJobInfo record);
}