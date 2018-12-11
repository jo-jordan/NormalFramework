package com.lzjlxebr.util;

/**
 * create: lzjlxebr
 * time: 2018/12/11 下午11:16
 * description:
 **/
public class StringUtil {
    public static boolean isEmpty(String str) {
        return null == str || "".equals(str);
    }

    public static boolean canConvertToNumber(String str) {
        try {
            Double.parseDouble(str);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public static Number convertToNumber(String str) {
        return Double.parseDouble(str);
    }

    public static void main(String[] args) {
        canConvertToNumber("12.01");
    }

    public static boolean isNormalOperator(String str) {

        return "+".equals(str) || "-".equals(str) || "*".equals(str) || "/".equals(str);
    }

    public static boolean isHighLevelOperator(String str) {

        return "*".equals(str) || "/".equals(str);
    }
}
