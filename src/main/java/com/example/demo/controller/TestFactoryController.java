package com.example.demo.controller;


import com.example.demo.service.TestFactoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/factory")
public class TestFactoryController {

    @Autowired
    private TestFactoryService testFactoryService;
    @GetMapping
    public void test(){
        testFactoryService.test();
    }
}
