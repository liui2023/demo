package com.example.demo.mapper;

import com.example.demo.dto.Test;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author LiuYi
 * @Date 2023/6/5  11:02
 * @Desc 又是充满希望的一天
 */
@Mapper
public interface TestMapper{

    void insert(Test test);
}
