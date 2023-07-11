package com.example.demo.utils;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//


import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class StringUtils {
    private static final String SPLIT_DELIMITER = ",|;|\\|";
    private static final String JOIN_SEPARATOR = ",";
    public static final String EMPTY = "";
    public static final String SPACE = " ";
    public static final char SPACE_CHAR = ' ';
    private static final int LEFT = -1;
    private static final int RIGHT = 1;
    private static final int BOTH = 2;

    public static char[] toCharArray(String str) {
        return str != null ? str.toCharArray() : null;
    }

    public static String toString(char[] chars) {
        return chars != null ? new String(chars) : null;
    }

    public static String emptyAsNull(String str) {
        return str != null && !"".equals(str.trim()) ? str : null;
    }

    public static String nullAsEmpty(String str) {
        return str == null ? "" : str;
    }

    public static String formatNumber(String pattern, Object num) {
        DecimalFormat formater = new DecimalFormat(pattern);
        return formater.format(num);
    }

    public static String formatNumber(int digits, long num) {
        StringBuilder pattern = new StringBuilder();

        for(int i = 0; i < digits; ++i) {
            pattern.append("0");
        }

        return formatNumber(pattern.toString(), num);
    }

    /** @deprecated */
    @Deprecated
    public static String format(String fmt, Object... args) {
        StringWriter writer = new StringWriter();
        PrintWriter out = new PrintWriter(writer);
        out.printf(fmt, args);
        out.flush();
        return writer.toString();
    }

    public static String trim(String str) {
        return str != null ? str.trim() : null;
    }

    public static String trimAll(String str) {
        return str != null ? str.replaceAll("\\s+", "") : null;
    }

    public static String trimLeft(String str) {
        return str != null ? str.replaceAll("^\\s+", "") : null;
    }

    public static String trimRight(String str) {
        return str != null ? str.replaceAll("\\s+$", "") : null;
    }

    public static String trimLeft(String str, String tirmStr) {
        if (!isEmpty(str) && !isEmpty(tirmStr) && str.length() >= tirmStr.length()) {
            int offset;
            for(offset = 0; str.startsWith(tirmStr, offset); offset += tirmStr.length()) {
            }

            return offset > 0 ? str.substring(offset) : str;
        } else {
            return str;
        }
    }

    public static String trimRight(String str, String tirmStr) {
        if (!isEmpty(str) && !isEmpty(tirmStr) && str.length() >= tirmStr.length()) {
            int offset;
            for(offset = str.length(); str.startsWith(tirmStr, offset - tirmStr.length()); offset -= tirmStr.length()) {
            }

            return offset < str.length() ? str.substring(0, offset) : str;
        } else {
            return str;
        }
    }

    public static String trimBoth(String str, String tirmStr) {
        return trimRight(trimLeft(str, tirmStr), tirmStr);
    }

    public static String reverse(String str) {
        return isBlank(str) ? str : (new StringBuilder(str)).reverse().toString();
    }

    public static int length(String str) {
        return str == null ? 0 : str.length();
    }

    public static int length(String... strs) {
        int len = 0;
        if (strs != null) {
            String[] var2 = strs;
            int var3 = strs.length;

            for(int var4 = 0; var4 < var3; ++var4) {
                String str = var2[var4];
                if (str != null) {
                    len += str.length();
                }
            }
        }

        return len;
    }

    public static int lengthAsByte(String str) {
        return lengthAsByte(str, (String)null);
    }

    public static int lengthAsByte(String str, String charset) {
        try {
            if (str == null) {
                return 0;
            } else {
                if (charset == null) {
                    charset = Charset.defaultCharset().name();
                }

                return str.getBytes(charset).length;
            }
        } catch (UnsupportedEncodingException var3) {
            return -1;
        }
    }

    public static boolean startsWith(String msg, String prefix) {
        return msg != null && prefix != null && msg.startsWith(prefix);
    }

    public static boolean endsWith(String msg, String suffix) {
        return msg != null && suffix != null && msg.endsWith(suffix);
    }

    public static String padding(String msg, char padChar, int padLen) {
        if (padLen == 0) {
            return msg;
        } else {
            StringBuilder buff = new StringBuilder(defaultString(msg));
            if (padLen > 0) {
                while(padLen-- > 0) {
                    buff.append(padChar);
                }
            } else {
                while(padLen++ < 0) {
                    buff.insert(0, padChar);
                }
            }

            return buff.toString();
        }
    }

    public static String leftPad(String msg, String padStr, int totalLen) {
        return pad(msg, padStr, totalLen, -1);
    }

    public static String rightPad(String msg, String padStr, int totalLen) {
        return pad(msg, padStr, totalLen, 1);
    }

    public static String bothPad(String msg, String padStr, int totalLen) {
        return pad(msg, padStr, totalLen, 2);
    }

    private static String pad(String msg, String padStr, int totalLen, int padMode) {
        if (!isEmpty(padStr) && totalLen > 0 && (msg == null || msg.length() < totalLen)) {
            StringBuilder str = new StringBuilder(defaultString(msg));

            while(str.length() + padStr.length() * Math.abs(padMode) <= totalLen) {
                switch (padMode) {
                    case -1:
                        str.insert(0, padStr);
                        break;
                    case 0:
                    default:
                        return str.toString();
                    case 1:
                        str.append(padStr);
                        break;
                    case 2:
                        str.insert(0, padStr).append(padStr);
                }
            }

            return str.toString();
        } else {
            return msg;
        }
    }

    public static String format(String pattern, Date d) {
        return d != null && pattern != null ? (new SimpleDateFormat(pattern)).format(d) : "";
    }

    public static String format(String pattern, Date d, Locale locale) {
        return d != null && pattern != null ? (new SimpleDateFormat(pattern, locale)).format(d) : "";
    }

    public static Date parseToDate(String pattern, String str) {
        try {
            return str != null && pattern != null ? (new SimpleDateFormat(pattern)).parse(str) : null;
        } catch (ParseException var3) {
            throw new RuntimeException(var3);
        }
    }

    public static Date parseToDateQuietly(String pattern, String str) {
        try {
            return parseToDate(pattern, str);
        } catch (Exception var3) {
            return null;
        }
    }

    public static java.sql.Date parseToSqlDate(String pattern, String str) {
        Date date = parseToDate(pattern, str);
        return date == null ? null : new java.sql.Date(date.getTime());
    }

    public static String string2Hex(String str, String charset) {
        if (str == null) {
            return null;
        } else {
            try {
                byte[] bytes;
                if (charset != null) {
                    bytes = str.getBytes(charset);
                } else {
                    bytes = str.getBytes();
                }

                StringBuilder hex = new StringBuilder();
                byte[] var4 = bytes;
                int var5 = bytes.length;

                for(int var6 = 0; var6 < var5; ++var6) {
                    byte b = var4[var6];
                    String hs = Integer.toHexString(b & 255).toUpperCase();
                    if (hs.length() == 1) {
                        hex.append("0");
                    }

                    hex.append(hs);
                }

                return hex.toString();
            } catch (Exception var9) {
                return null;
            }
        }
    }

    public static String hex2String(String hex, String charset) {
        if (!isBlank(hex) && hex.length() % 2 == 0) {
            try {
                byte[] bytes = new byte[hex.length() / 2];

                for(int i = 0; i < bytes.length; ++i) {
                    bytes[i] = (byte)(255 & Integer.parseInt(hex.substring(i * 2, i * 2 + 2), 16));
                }

                return charset == null ? new String(bytes) : new String(bytes, charset);
            } catch (Exception var4) {
                return null;
            }
        } else {
            return null;
        }
    }

    public static Object[] parseMessage(String pattern, String msg) {
        try {
            return (new MessageFormat(pattern)).parse(msg);
        } catch (Exception var3) {
            return null;
        }
    }

    public static String formatMessage(String pattern, Object... args) {
        try {
            return MessageFormat.format(pattern, args);
        } catch (Exception var3) {
            return null;
        }
    }

    public static String formatString(String format, Object... args) {
        try {
            return String.format(format, args);
        } catch (Exception var3) {
            return null;
        }
    }

    public static boolean isEmpty(String str) {
        return str == null || str.length() == 0;
    }

    public static boolean isHasEmpty(String... strings) {
        String[] var1 = strings;
        int var2 = strings.length;

        for(int var3 = 0; var3 < var2; ++var3) {
            String str = var1[var3];
            if (isEmpty(str)) {
                return true;
            }
        }

        return false;
    }

    public static boolean isNotEmpty(String str) {
        return str != null && str.length() > 0;
    }

    public static boolean isBlank(String str) {
        return str == null || str.trim().length() == 0;
    }

    public static boolean isNotBlank(String str) {
        return str != null && str.trim().length() > 0;
    }

    public static String defaultString(String str) {
        return defaultString(str, "");
    }

    public static String defaultString(String str, String defVal) {
        return str == null ? defVal : str;
    }

    public static String defaultStringIfEmpty(String str, String defVal) {
        return isEmpty(str) ? defVal : str;
    }

    public static String defaultStringIfBlank(String str, String defVal) {
        return isBlank(str) ? defVal : str;
    }

    public static boolean contains(String str, String target) {
        return str != null && target != null ? str.contains(target) : false;
    }

//    public static boolean containsAny(String str, String... targets) {
//        if (ArrayUtil.isNotEmpty(targets)) {
//            String[] var2 = targets;
//            int var3 = targets.length;
//
//            for(int var4 = 0; var4 < var3; ++var4) {
//                String target = var2[var4];
//                if (contains(str, target)) {
//                    return true;
//                }
//            }
//        }
//
//        return false;
//    }

//    public static boolean containsAll(String str, String... targets) {
//        if (ArrayUtil.isEmpty(targets)) {
//            return false;
//        } else {
//            String[] var2 = targets;
//            int var3 = targets.length;
//
//            for(int var4 = 0; var4 < var3; ++var4) {
//                String target = var2[var4];
//                if (!contains(str, target)) {
//                    return false;
//                }
//            }
//
//            return true;
//        }
//    }

    public static int count(String str, String subStr) {
        if (!isEmpty(str) && !isEmpty(subStr)) {
            int cnt = 0;
            int idx = 0;

            for(int len = subStr.length(); (idx = str.indexOf(subStr, idx)) != -1; ++cnt) {
                idx += len;
            }

            return cnt;
        } else {
            return 0;
        }
    }

    public static String repeat(String str, int times) {
        return repeat(str, (String)null, times);
    }

    public static String repeat(String str, String separator, int times) {
        if (!isEmpty(str) && times >= 2) {
            StringBuilder buff = new StringBuilder();

            while(times-- > 0) {
                buff.append(str);
                if (separator != null && times > 0) {
                    buff.append(separator);
                }
            }

            return buff.toString();
        } else {
            return str;
        }
    }

    public static char chatAt(String msg, int idx, char defChar) {
        return msg != null && idx >= 0 && idx < msg.length() ? msg.charAt(idx) : defChar;
    }

    public static String subString(String msg, int start) {
        return subString(msg, start, 0);
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

    public static String getString(String str, int offset, int length) {
        if (isEmpty(str)) {
            return str;
        } else if (offset < str.length() && length > 0) {
            if (offset < 0) {
                offset = Math.max(0, str.length() + offset);
            }

            if (offset + length > str.length()) {
                length = str.length() - offset;
            }

            return str.substring(offset, offset + length);
        } else {
            return "";
        }
    }

    public static String find(String src, String target) {
        return find(src, target, 0, 1);
    }

    public static String find(String src, String target, int offset) {
        return find(src, target, offset, 1);
    }

    public static String find(String src, String target, int offset, int occurTimes) {
        int end = indexOf(src, target, offset, occurTimes);
        if (end == -1) {
            return null;
        } else {
            if (offset < 0) {
                offset = Math.max(0, src.length() + offset);
            }

            return src.substring(offset, end);
        }
    }

    public static int indexOf(String src, String target) {
        return indexOf(src, target, 0, 1);
    }

    public static int indexOf(String src, String target, int offset) {
        return indexOf(src, target, offset, 1);
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

    public static int lastIndexOf(String src, String target) {
        return lastIndexOf(src, target, length(src), 1);
    }

    public static int lastIndexOf(String src, String target, int offset) {
        return lastIndexOf(src, target, offset, 1);
    }

    public static int lastIndexOf(String src, String target, int offset, int occurTimes) {
        if (!isEmpty(src) && !isEmpty(target) && occurTimes > 0) {
            if (offset < 0) {
                offset = Math.max(0, src.length() + offset);
            }

            if (target.length() <= offset && offset <= src.length()) {
                while(occurTimes-- > 0) {
                    int pos = src.lastIndexOf(target, offset);
                    if (pos == -1) {
                        return -1;
                    }

                    offset = pos - 1;
                }

                return offset + 1;
            } else {
                return -1;
            }
        } else {
            return -1;
        }
    }

    public static boolean matches(String str, String pattern) {
        return str != null && pattern != null && str.matches(pattern);
    }

    public static String mark(String msg, char flag, int start, int end) {
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
            if (start < msg.length() && end <= msg.length() && start < end) {
                StringBuilder str = new StringBuilder(msg);

                for(int i = start; i < end; ++i) {
                    str.setCharAt(i, flag);
                }

                return str.toString();
            } else {
                return msg;
            }
        }
    }

//    public static String join(Collection<?> col) {
//        return join((Collection)col, (String)null, false, (Collection)null);
//    }

//    public static String join(Collection<?> col, String separator) {
//        return join((Collection)col, separator, false, (Collection)null);
//    }

//    public static String join(Collection<?> col, boolean joinElements) {
//        return join((Collection)col, (String)null, joinElements, (Collection)null);
//    }

//    public static String join(Collection<?> col, String separator, boolean joinElements) {
//        return join((Collection)col, separator, joinElements, (Collection)null);
//    }

//    private static String join(Collection<?> col, String separator, boolean joinElements, Collection<Object> context) {
//        if (col == null) {
//            return null;
//        } else if (col.isEmpty()) {
//            return "";
//        } else {
//            if (separator == null) {
//                separator = ",";
//            }
//
//            if (joinElements) {
//                if (context == null) {
//                    context = new ArrayList();
//                }
//
//                ((Collection)context).add(col);
//            }
//
//            StringBuilder str = new StringBuilder();
//            Iterator var5 = col.iterator();
//
//            while(true) {
//                while(var5.hasNext()) {
//                    Object obj = var5.next();
//                    if (joinElements && obj instanceof Collection) {
//                        if (!((Collection)context).contains(obj)) {
//                            if (str.length() > 0) {
//                                str.append(separator);
//                            }
//
//                            str.append(join((Collection)((Collection)obj), separator, joinElements, (Collection)context));
//                        }
//                    } else {
//                        if (str.length() > 0) {
//                            str.append(separator);
//                        }
//
//                        str.append(ObjectUtil.toString(obj));
//                    }
//                }
//
//                return str.toString();
//            }
//        }
//    }

//    public static String join(Object[] objs) {
//        return join((Object[])objs, (String)null, false, (Collection)null);
//    }
//
//    public static String join(Object[] objs, String separator) {
//        return join((Object[])objs, separator, false, (Collection)null);
//    }

//    public static String join(Object[] objs, boolean joinElements) {
//        return join((Object[])objs, (String)null, joinElements, (Collection)null);
//    }
//
//    public static String join(Object[] objs, String separator, boolean joinElements) {
//        return join((Object[])objs, separator, joinElements, (Collection)null);
//    }

//    private static String join(Object[] objs, String separator, boolean joinElements, Collection<Object> context) {
//        if (objs == null) {
//            return null;
//        } else if (objs.length == 0) {
//            return "";
//        } else {
//            if (separator == null) {
//                separator = ",";
//            }
//
//            if (joinElements) {
//                if (context == null) {
//                    context = new HashSet();
//                }
//
//                ((Collection)context).add(objs);
//            }
//
//            StringBuilder str = new StringBuilder();
//            Object[] var5 = objs;
//            int var6 = objs.length;
//
//            for(int var7 = 0; var7 < var6; ++var7) {
//                Object obj = var5[var7];
//                if (joinElements && obj instanceof Object[]) {
//                    if (!((Collection)context).contains(obj)) {
//                        if (str.length() > 0) {
//                            str.append(separator);
//                        }
//
//                        str.append(join((Object[])((Object[])((Object[])obj)), separator, joinElements, (Collection)context));
//                    }
//                } else {
//                    if (str.length() > 0) {
//                        str.append(separator);
//                    }
//
//                    str.append(ObjectUtil.toString(obj));
//                }
//            }
//
//            return str.toString();
//        }
//    }

    public static String[] split(String msg) {
        return split(msg, ",|;|\\|");
    }

    public static String[] split(String msg, String delimiter) {
        if (msg == null) {
            return null;
        } else {
            delimiter = defaultString(delimiter, ",|;|\\|");
            return msg.split(delimiter);
        }
    }

//    public static <T extends Collection<String>> T split(String msg, Class<? extends T> clazz) {
//        return split(msg, ",|;|\\|", clazz);
//    }

//    public static <T extends Collection<String>> T split(String msg, String delimiter, Class<? extends Collection> clazz) {
//        if (msg != null && clazz != null) {
//            delimiter = defaultString(delimiter, ",|;|\\|");
//            T collection = CollectionUtil.newCollection(clazz);
//            if (collection != null) {
//                String[] var4 = msg.split(delimiter);
//                int var5 = var4.length;
//
//                for(int var6 = 0; var6 < var5; ++var6) {
//                    String part = var4[var6];
//                    collection.add(part);
//                }
//            }
//
//            return collection;
//        } else {
//            return null;
//        }
//    }

    public static String replace(String str, String replacement, int start, int end) {
        if (!isEmpty(str) && replacement != null) {
            if (start < 0) {
                start = Math.max(0, str.length() + start);
            }

            if (end <= 0) {
                end += str.length();
            }

            end = Math.min(end, str.length());
            return start < str.length() && end <= str.length() && start < end ? (new StringBuilder(str)).replace(start, end, replacement).toString() : str;
        } else {
            return str;
        }
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

//    public static String[] subString(String str, String tag) {
//        return subStringBetween(str, tag, tag, true);
//    }
//
//    public static String[] subString(String str, String open, String close) {
//        return subStringBetween(str, open, close, true);
//    }

//    public static String[] subStringBetween(String str, String tag) {
//        return subStringBetween(str, tag, tag);
//    }

//    public static String[] subStringBetween(String str, String open, String close) {
//        return subStringBetween(str, open, close, false);
//    }
//
//    public static String replaceString(String str, String target, String[] replacement) {
//        return replaceStringBetween(str, target, target, replacement, true);
//    }

//    public static String replaceString(String str, String open, String close, String[] replacement) {
//        return replaceStringBetween(str, open, close, replacement, true);
//    }
//
//    public static String replaceStringBetween(String str, String target, String[] replacement) {
//        return replaceStringBetween(str, target, target, replacement, false);
//    }

//    public static String replaceStringBetween(String str, String open, String close, String[] replacement) {
//        return replaceStringBetween(str, open, close, replacement, false);
//    }

//    public static String[] subXML(String xml, String nodeName) {
//        return subXML(xml, nodeName, true);
//    }

//    public static String[] subXMLBetween(String xml, String nodeName) {
//        return subXML(xml, nodeName, false);
//    }

//    public static String replaceXML(String str, String nodeName, String[] replacement) {
//        return replaceXML(str, nodeName, replacement, true);
//    }
//
//    public static String replaceXMLBetween(String str, String nodeName, String[] replacement) {
//        return replaceXML(str, nodeName, replacement, false);
//    }

//    static String[] subXML(String xml, String nodeName, boolean isNodeIncluded) {
//        if (xml != null && nodeName != null) {
//            String startTag = "<" + nodeName + ">";
//            String endTag = "</" + nodeName + ">";
//            return subStringBetween(xml, startTag, endTag, isNodeIncluded);
//        } else {
//            return new String[0];
//        }
//    }

//    static String replaceXML(String xml, String nodeName, String[] replacement, boolean isNodeIncluded) {
//        if (xml != null && nodeName != null && !ArrayUtil.isEmpty(replacement)) {
//            String startTag = "<" + nodeName + ">";
//            String endTag = "</" + nodeName + ">";
//            return replaceStringBetween(xml, startTag, endTag, replacement, isNodeIncluded);
//        } else {
//            return xml;
//        }
//    }

//    private static String[] subStringBetween(String str, String open, String close, boolean isTagIncluded) {
//        if (str != null && open != null && close != null) {
//            List<String> results = new ArrayList();
//            int openStart = false;
//            int openEnd = false;
//            int closeStart = false;
//            int closeEnd = 0;
//
//            while(true) {
//                int openStart = str.indexOf(open, closeEnd);
//                if (openStart == -1) {
//                    break;
//                }
//
//                int openEnd = openStart + open.length();
//                int closeStart = str.indexOf(close, openEnd);
//                if (closeStart == -1) {
//                    break;
//                }
//
//                closeEnd = closeStart + close.length();
//                if (isTagIncluded) {
//                    results.add(str.substring(openStart, closeEnd));
//                } else {
//                    results.add(str.substring(openEnd, closeStart));
//                }
//            }
//
//            return (String[])results.toArray(new String[results.size()]);
//        } else {
//            return new String[0];
//        }
//    }

//    private static String replaceStringBetween(String str, String open, String close, String[] replacement, boolean isTagIncluded) {
//        if (str != null && open != null && close != null && !ArrayUtil.isEmpty(replacement)) {
//            StringBuilder result = new StringBuilder(str);
//            String replaceStr = null;
//            int maxRepLen = replacement.length - 1;
//            int lastRsLen = false;
//            int openStart = false;
//            int openEnd = false;
//            int closeStart = false;
//            int closeEnd = 0;
//            int count = 0;
//
//            while(true) {
//                int openStart = result.indexOf(open, closeEnd);
//                if (openStart == -1) {
//                    break;
//                }
//
//                int openEnd = openStart + open.length();
//                int closeStart = result.indexOf(close, openEnd);
//                if (closeStart == -1) {
//                    break;
//                }
//
//                closeEnd = closeStart + close.length();
//                int lastRsLen = result.length();
//                replaceStr = defaultString(replacement[count > maxRepLen ? maxRepLen : count]);
//                if (isTagIncluded) {
//                    result.replace(openStart, closeEnd, replaceStr);
//                } else {
//                    result.replace(openEnd, closeStart, replaceStr);
//                }
//
//                closeEnd += result.length() - lastRsLen;
//                ++count;
//            }
//
//            return result.toString();
//        } else {
//            return str;
//        }
//    }

    public static List<String> separateString(String string, String split, boolean tail) {
        List<String> fieldList = new ArrayList();
        int len = string.length();
        int offset = 0;
        char tag = split.trim().charAt(0);

        String field;
        for(int i = 0; i < len; ++i) {
            if (string.charAt(i) == tag) {
                field = string.substring(offset, i);
                if (field.length() == 0) {
                    field = "";
                }

                fieldList.add(field);
                offset = i + 1;
            }
        }

        if (!tail) {
            field = string.substring(offset);
            if (field == null || field.length() == 0) {
                field = "";
            }

            fieldList.add(field);
        }

        return fieldList;
    }

    private StringUtils() {
    }
}

