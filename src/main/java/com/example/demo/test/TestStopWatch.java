package com.example.demo.test;

import com.example.demo.utils.StopWatch;

public class TestStopWatch {

    public static void main(String[] args) {
        StopWatch stopWatch = StopWatch.startNew();
        System.out.println(stopWatch.mark());
    }
}
