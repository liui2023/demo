package com.example.demo.test;

/**
 * @Author mac777
 * @Date 2023/7/12 19:23
 * @Desc 又是充满希望的一天
 */
public class TestString {

    public static void main(String[] args) {
        String s = "1_decimalScale_1";
        int i = indexOf(s, "decimalScale", 0, 1);
        String subString = subString(s, i, 0);
        String replace = replace(subString, "\\D", "");
        System.out.println(replace);
        System.out.println(s.replaceAll("\\D",""));
    }
    public static String replace(String str, String regex, String replacement) {
        try {
            if (str != null && regex != null) {
                return str.replaceAll(regex, defaultString(replacement));
            }
        } catch (Exception var4) {
        }

        return str;
    }
    public static String defaultString(String str) {
        return defaultString(str, "");
    }

    public static String defaultString(String str, String defVal) {
        return str == null ? defVal : str;
    }
    public static boolean isEmpty(String str) {
        return str == null || str.length() == 0;
    }
    public static String subString(String msg, int start, int end) {
        if (isEmpty(msg)) {
            return msg;
        } else {
            if (start < 0) {
                start = Math.max(0, msg.length() + start);
            }

            if (end <= 0) {
                end += msg.length();
            }

            end = Math.min(end, msg.length());
            return start < msg.length() && end <= msg.length() && start < end ? msg.substring(start, end) : "";
        }
    }

    public static int indexOf(String src, String target, int offset, int occurTimes) {
        if (!isEmpty(src) && !isEmpty(target) && occurTimes > 0) {
            if (offset < 0) {
                offset = Math.max(0, src.length() + offset);
            }

            if (target.length() + offset > src.length()) {
                return -1;
            } else {
                while(occurTimes-- > 0) {
                    int pos = src.indexOf(target, offset);
                    if (pos == -1) {
                        return -1;
                    }

                    offset = pos + 1;
                }

                return offset - 1;
            }
        } else {
            return -1;
        }
    }
}
