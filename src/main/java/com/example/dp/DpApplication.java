package com.example.dp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.dp.dao")
public class DpApplication {

    public static void main(String[] args) {
        SpringApplication.run(DpApplication.class, args);
    }

}
