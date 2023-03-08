package com.example.dp.controller;

import com.example.dp.domain.JmeterTable;
import com.example.dp.domain.XxlJobInfo;
import com.example.dp.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
public class TestController {

    @Autowired
    private TestService testService;


    @RequestMapping("/test")
    public XxlJobInfo test(){
        return testService.get().get(0);
    }


    @RequestMapping("/insertJmeter")
    public Boolean insertJmeter(){
        return testService.insertJmeterTable();
    }

    @RequestMapping("/selectAllThreadPool")
    public List<JmeterTable> selectAllThreadPool(){
        return testService.getJmeterTables();
    }

    @RequestMapping("/selectAll")
    public List<JmeterTable> selectAll(){
        return testService.getJmeterTables();
    }
}
