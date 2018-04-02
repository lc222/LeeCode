package com.chenlei.string;

import util.StringUtils;

/**
 * 1.1 字符串的旋转
 * @author chenlei
 * @since  2016 - 09 - 04 10:31
 */
public class RotateString {

    private static String rotateStringByForce(String obj, Integer n) {
        if(StringUtils.isBlank(obj) || n == null || n <= 0) {
            return "";
        }
        StringBuilder buffer = new StringBuilder(obj);
        for(int i = 0; i < n; i++) {
            char temp = buffer.charAt(0);
            for(int j = 0; j < buffer.length() - 1; j++) {
                buffer.setCharAt(j, buffer.charAt(j+1));
            }
            buffer.setCharAt(buffer.length() - 1, temp);
        }
        return buffer.toString();
    }

    private static String rotateString(String obj, Integer n) {
        if(StringUtils.isBlank(obj) || n == null || n <= 0) {
            return "";
        }
        int revertStep = n % obj.length();
        if(revertStep == 0) {
            return obj;
        }
        char[] strArray = obj.toCharArray();
        StringUtils.reverseCharArray(strArray, 0, strArray.length - 1);
        StringUtils.reverseCharArray(strArray, 0, strArray.length - 1 - revertStep);
        StringUtils.reverseCharArray(strArray, strArray.length - revertStep, strArray.length -1);
        return  String.valueOf(strArray);
    }


    public static void main(String[] args) {
        String obj = "abcdef";
        System.out.println(rotateStringByForce(obj, 10));
        System.out.println(rotateString(obj, 10));
    }
}
