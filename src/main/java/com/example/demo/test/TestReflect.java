package com.example.demo.test;

import java.lang.reflect.Method;
import java.util.Arrays;

public class TestReflect {

    public static void main(String[] args) throws ClassNotFoundException {
        Class<TestReflect> testReflectClass = TestReflect.class;
        Class<?> aClass = Class.forName("com.example.demo.test.TestReflect");
        Method[] declaredMethods = aClass.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            Class<?>[] parameterTypes = declaredMethod.getParameterTypes();
            System.out.println(Arrays.toString(parameterTypes));
            System.out.println(parameterTypes.length);
            System.out.println(declaredMethod.getName());
            System.out.println(parameterTypes[0].getName().equalsIgnoreCase("String"));
            System.out.println(parameterTypes[0].getSimpleName().equalsIgnoreCase("String"));
        }
    }

    public void test(String reflect, int t){
        int temp = 0;
        String stringTemp = "test";
    }

    public void test(String ref, int[] nums){
        int test = 1;
    }
}
