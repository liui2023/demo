package com.example.demo.test;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

public class TestExpressionParser {

    private static ExpressionParser parser = new SpelExpressionParser();

    public static void main(String[] args) {
        System.out.println(Boolean.valueOf("false"));
        Expression _expression = parser.parseExpression("1" + "2");
        System.out.println(_expression.getValue());
    }
}
