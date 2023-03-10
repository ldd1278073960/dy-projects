package com.example.dp.service;

import com.example.dp.domain.JmeterTable;
import com.example.dp.domain.XxlJobInfo;

import java.util.List;

public interface TestService {


    List<XxlJobInfo> get();

    Boolean insertJmeterTable();

    List<JmeterTable> getJmeterTables();

    List<JmeterTable> getJmeterTablesAll();


    List<String> getLgType();
}
