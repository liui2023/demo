package com.example.demo.dto;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Author LiuYi
 * @Date 2023/6/5  11:03
 * @Desc 又是充满希望的一天
 */

@Data
@Builder
@Table(name = "user")
public class Test {
    @Id
    private Integer id;
    private String name;
    private Integer age;
    private String sex;
}
