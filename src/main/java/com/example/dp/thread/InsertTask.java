package com.example.dp.thread;

import com.example.dp.dao.JmeterTableDAO;
import com.example.dp.domain.JmeterTable;

import java.util.Date;
import java.util.UUID;
import java.util.concurrent.Callable;

public class InsertTask implements Callable<Boolean> {

    private final JmeterTableDAO jmeterTableDAO;

    public InsertTask(JmeterTableDAO jmeterTableDAO) {
        this.jmeterTableDAO = jmeterTableDAO;
    }

    @Override
    public Boolean call() throws Exception {
        JmeterTable j ;
        for (int i = 0; i < 5000; i++) {
            j = new JmeterTable();
            j.setId(UUID.randomUUID().toString());
            j.setCode(UUID.randomUUID() + "" + System.currentTimeMillis());
            j.setCreateTime(new Date());
            jmeterTableDAO.insert(j);
        }
        return true;
    }
}
