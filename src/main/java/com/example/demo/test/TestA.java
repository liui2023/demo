package com.example.demo.test;

import com.example.demo.dto.Test;
import com.example.demo.mapper.TestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author LiuYi
 * @Date 2023/6/5  10:42
 * @Desc 又是充满希望的一天
 */
@Service
public class TestA {

    private static final int i = 0;

    @Autowired
    private TestMapper testMapper;

    @Transactional
    public void a(){
        testMapper.insert(Test.builder().age(123).build());
        int a = 0;
        Integer b = null;
        System.out.println(a == b);
    }
}


