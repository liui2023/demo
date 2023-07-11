package com.example.demo.test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class demo {

    public static void main(String[] args) {
        demo demo = new demo();
        demo.tryCatchTest();

        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(12, -30);
        System.out.println(cal.getTime());

        System.out.println(format("yyyyMMddHHmmss", cal.getTime()));

        System.out.println(getTodayStartTime());
    }

    public boolean tryCatchTest() {

        try {
            return true;
        } catch (Exception e) {

        } finally {
            System.out.println("finally");
        }
        return true;
    }

    public void test() {
        String jobName = this.getClass().getSimpleName();
        System.out.println("JOB NAME : " + jobName);
    }

    public static Date getTodayStartTime() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        return calendar.getTime();
    }

    public static String format(String pattern, Date d) {
        return d != null && pattern != null ? (new SimpleDateFormat(pattern)).format(d) : "";
    }
}
