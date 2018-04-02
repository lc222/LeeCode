package com.chenlei.string.back;

import util.StringUtils;

/**
 *  1.1 单词反转
 * @author chenlei
 * @since  2016 - 09 - 04 11:42
 */
public class ReverseWord {
    private static String reverseWord(String string) {
        char[] chars = string.toCharArray();
        StringUtils.reverseCharArray(chars, 0, chars.length - 1);
        int first = 0, second;
        do{
            //firstIndex指向第一个不等于空的字符
            while(first < chars.length && chars[first] == ' ') first++;
            if(first >= chars.length) break;
            second = first; // second指向该word的最后一个字符
            while(second < chars.length - 1  && chars[second + 1] != ' ') second++;
            StringUtils.reverseCharArray(chars, first, second);
            first = second + 1;
        } while(true);
        return String.valueOf(chars);
    }

    public static void main(String[] args) {
        System.out.println(reverseWord(" I am a student."));
    }
}
