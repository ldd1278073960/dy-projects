package com.example.dp.domain;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * jmeter_table
 * @author 
 */
@Data
public class JmeterTable implements Serializable {
    private String id;

    private String code;

    private Date createTime;

    private static final long serialVersionUID = 1L;
}