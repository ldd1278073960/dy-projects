package com.example.dp.utils;

import java.util.HashMap;
import java.util.Map;

public class SplitUtil {

    // 根据查询记录数和线程数量分配每条线程查询记录数
    public static Map<String, String> splitMap(int count, int threadCoreNum) {
        Map<String, String> splitMap = new HashMap<>(threadCoreNum);

        // 每个线程分配的查询记录数
        int offsetNum = count / threadCoreNum;
        int residue = count % threadCoreNum;

        for (int i = 1; i <= threadCoreNum; i++) {
            if (i == 1) {
                splitMap.put(String.valueOf(i), 0 + ":" + offsetNum);
            } else if(i < threadCoreNum) {
                splitMap.put(String.valueOf(i), (i - 1) * offsetNum + ":" + offsetNum);
            } else {
                splitMap.put(String.valueOf(i), (i - 1) * offsetNum + ":" + (offsetNum + residue));
            }
        }

        return splitMap;
    }

    public static void main(String[] args) {
        Map<String, String> splitMap = splitMap(50000, 5);
        for (int i = 1; i <= 5; i++) {
            String[] split = splitMap.get(String.valueOf(i)).split(":");
            int index = Integer.parseInt(split[0]);
            // 查询的数量
            int num = Integer.parseInt(split[1]);
            System.out.println(index);
            System.out.println( index+num);
        }

    }
}