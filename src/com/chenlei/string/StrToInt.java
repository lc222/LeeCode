package com.chenlei.string;

/**
 *  字符串转换为整数
 * @author chenlei
 * @since 2017 - 02 - 14 21:33
 */

public class StrToInt {

    //题目要求输入为数字的字符串，因此不做其他字符的检测
    private static int strToInt(String s) {
        int beginIndex = 0;
        boolean isPositive = true;
        if(s.charAt(0) == '+') {
            beginIndex = 1;
        } else if(s.charAt(0) == '-') {
            beginIndex = 1;
            isPositive = false;
        }
        int result = 0;
        for( ; beginIndex < s.length(); beginIndex++) {
            if(isPositive) {
                if(result > (Integer.MAX_VALUE / 10) || (result == (Integer.MAX_VALUE / 10) && (s.charAt(beginIndex) - '0') > (Integer.MAX_VALUE  % 10))) {
                    //会溢出
                    return Integer.MAX_VALUE;
                }
            } else {
                if(result > (Integer.MAX_VALUE / 10) || (result == (Integer.MAX_VALUE / 10) && (s.charAt(beginIndex) - '0') >= (Integer.MAX_VALUE  % 10 + 1))) {
                    //会溢出
                    return Integer.MIN_VALUE;
                }
            }
            result = result * 10 + s.charAt(beginIndex) - '0';
        }
        return isPositive ? result : -result;
    }

    public static void main(String[] args) {
        System.out.println(strToInt("123"));
        System.out.println(strToInt("-1234"));
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        System.out.println(strToInt("2147483647"));
        System.out.println(strToInt("21474836479"));
        System.out.println(strToInt("2147483648"));
        System.out.println(strToInt("-2147483648"));
        System.out.println(strToInt("-2147483649"));
        System.out.println(strToInt("-21474836487"));
    }
}
