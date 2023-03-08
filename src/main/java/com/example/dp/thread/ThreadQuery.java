package com.example.dp.thread;


import java.util.List;
import java.util.concurrent.Callable;

public class ThreadQuery implements Callable<List> {

    private CommonService baseService;

    public ThreadQuery() {}

    public ThreadQuery(CommonService baseService) {
        this.baseService = baseService;
    }

    @Override
    public List call() throws Exception {
        // 查询数据库
        return (List)  baseService.template();
    }

    public CommonService getBaseService() {
        return baseService;
    }

    public void setBaseService(CommonService baseService) {
        this.baseService = baseService;
    }
}