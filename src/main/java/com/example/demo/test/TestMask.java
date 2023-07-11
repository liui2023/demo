package com.example.demo.test;

import com.example.demo.utils.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestMask {

    public static void main(String[] args) {
        String message = "1234";
        sensistiveMask(message, "[1-9]{1}[0-9]{5}[19,20]{2}[0-9]{2}[0,1]{1}[0-9][0-3][0-9]{4}[0-9,xX]");
    }

    private static String sensistiveMask(String message, String regex) {
        Pattern idNoPattern = Pattern.compile(regex);

        for(Matcher matcher = idNoPattern.matcher(message); matcher.find(); message = message.replace(matcher.group(), mask(matcher.group(), 3, 4))) {
        }
        System.out.println(message);
        return message;
    }

    public static String mask(String idNo, int s, int e) {
        if (!StringUtils.isEmpty(idNo) && idNo.length() >= s + e) {
            StringBuilder result = new StringBuilder();
            result.append(StringUtils.rightPad(idNo.substring(0, s), "*", idNo.length() - e));
            if (e > 0) {
                result.append(StringUtils.subString(idNo, -e));
            }

            return result.toString();
        } else {
            return idNo;
        }
    }
}
