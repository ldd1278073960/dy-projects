package com.example.dp.service.impl;

import com.example.dp.dao.JmeterTableDAO;
import com.example.dp.dao.XxlJobInfoDAO;
import com.example.dp.domain.JmeterTable;
import com.example.dp.domain.XxlJobInfo;
import com.example.dp.enums.DataDashLGAppTypeEnum;
import com.example.dp.service.TestService;
import com.example.dp.thread.InsertTask;
import com.example.dp.thread.ThreadQuery;
import com.example.dp.utils.SplitUtil;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.*;

@Service
public class TestServiceImpl implements TestService {

    private final int corePoolSize = 5;
    private final int maximumPoolSize = 8;
    private final int keepAliveTime = 10;

    @Autowired
    private XxlJobInfoDAO xxlJobInfoDAO;

    @Autowired
    private JmeterTableDAO jmeterTableDAO;

    @Override
    public List<XxlJobInfo> get() {
        XxlJobInfo xxlJobInfo = xxlJobInfoDAO.selectByPrimaryKey(2);
        return Collections.singletonList(xxlJobInfo);
    }

    @Override
    public Boolean insertJmeterTable() {
        ArrayBlockingQueue<Runnable> queue=new ArrayBlockingQueue<>(8,true);
        ThreadPoolExecutor.DiscardPolicy policy=new ThreadPoolExecutor.DiscardPolicy();
        ThreadPoolExecutor executor=new ThreadPoolExecutor(10,10,10, TimeUnit.SECONDS
                ,queue,policy);
        List<InsertTask> tasks= Lists.newLinkedList();
        for (int j=0;j<10;j++){
            tasks.add(new InsertTask(jmeterTableDAO));
        }
        try {
            executor.invokeAll(tasks);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return true;
    }

    @Override
    public List<JmeterTable> getJmeterTables() {
        ExecutorService executorService = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, TimeUnit.SECONDS, new ArrayBlockingQueue<>(10));
        int countAll = jmeterTableDAO.getCountAll();
        Map<String, String> splitMap = SplitUtil.splitMap(countAll, corePoolSize);
        List<ThreadQuery> tasks = new ArrayList<>();
        for (int i = 1; i <= corePoolSize; i++) {
            String[] split = splitMap.get(String.valueOf(i)).split(":");
            // 查询结果的索引值
            int index = Integer.parseInt(split[0]);
            // 查询的数量
            int num = Integer.parseInt(split[1]);

            //获得结果
            ThreadQuery threadQuery = new ThreadQuery(() -> jmeterTableDAO.selectJmeterTablesPage(index, num));
            tasks.add(threadQuery);
        }

        List<JmeterTable> result  = new ArrayList<>();

        try {
            // Future获取结果
            List<Future<List>> futures = executorService.invokeAll(tasks);
            if (futures.size() > 0) {
                // 迭代结果
                for (Future<List> future : futures) {
                    result.addAll(future.get());
                }
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            // 关闭线程池
            executorService.shutdown();
            while (true){
                if (executorService.isTerminated()){
                    System.out.println("任务已完成");
                    break;
                }
            }
        }
        return result;
    }

    @Override
    public List<JmeterTable> getJmeterTablesAll() {
        return jmeterTableDAO.selectJmeterTableAll();
    }

    @Override
    public List<String> getLgType() {
        List<String> result = new ArrayList<>();
        result.add(DataDashLGAppTypeEnum.SIM_CERT.getType());
        result.add(DataDashLGAppTypeEnum.SIM_CARD_SMALL.getType());
        result.add(DataDashLGAppTypeEnum.SIM_SHIELD.getType());
        result.add(DataDashLGAppTypeEnum.SIM_TRAFFIC.getType());
        result.add(DataDashLGAppTypeEnum.SIM_ACCESS_CARD.getType());
        return result;
    }
}