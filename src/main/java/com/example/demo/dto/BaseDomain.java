package com.example.demo.dto;

import lombok.Data;

import java.util.Date;

@Data
public abstract class BaseDomain {

    private Long id;

    private Date createTime;

    private Date updateTime;

    private String createBy;

    /**
     * 乐观锁
     */
    private Long versions;
}
