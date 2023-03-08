package com.example.dp.utils;

import com.example.dp.dao.JmeterTableDAO;
import com.example.dp.domain.JmeterTable;
import com.example.dp.thread.InsertTask;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.*;

@Component
public class CopyOnWriteArrayListTest {


    @Autowired
    private JmeterTableDAO jmeterTableDAO;

    public static void main(String[] args) throws InterruptedException {

    }

}
