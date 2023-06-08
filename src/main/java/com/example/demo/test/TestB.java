package com.example.demo.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author LiuYi
 * @Date 2023/6/5  10:43
 * @Desc 又是充满希望的一天
 */
@Service
public class TestB {

    @Autowired
    private TestA testA;

    @Transactional
    public void b(){
        try {
            testA.a();
        }catch (Exception e){

        }
    }
}
