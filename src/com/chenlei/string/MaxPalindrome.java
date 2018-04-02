package com.chenlei.string;

import util.NumberUtils;
import util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 *  1.6 最长回文子串
 * @author chenlei
 * @since  2016 - 09 - 07 20:02
 */
public class MaxPalindrome {

    private static int maxPalindromeLength(String str) {
        if(StringUtils.isBlank(str)) {
            return 0;
        }
        int maxLength = 0;
        for(int i = 1; i < str.length() - 1; i++) {
            //中心位置的前后必须有值
            int oddLength = palindromeLength(str, i - 1,  i + 1);
            if(oddLength != 0) {
                oddLength = oddLength * 2 + 1;
                if(oddLength > maxLength) {
                    maxLength = oddLength;
                }
            }
            int evenLength = palindromeLength(str, i, i + 1);
            if(evenLength != 0) {
                evenLength = evenLength * 2;
                if(evenLength > maxLength) {
                    maxLength = evenLength;
                }
            }
        }
        return maxLength;
    }

    private static int palindromeLength(String str, int begin, int end) {
        int length = 0;
        while(begin >= 0 && end <= (str.length() - 1)) {
            if(str.charAt(begin) == str.charAt(end)) {
                length++;
                begin--;
                end++;
            } else {
                break;
            }
        }
        return length;
    }

    public static void buildManacher(String str, List<Integer> values) {
        int mx = 0;
        int id = 0;
        int value;
        for(int i = 0; i < str.length(); i++) {
            if(mx > i) {
                value = NumberUtils.min(values.get(2*id - i), mx - i);
            } else {
                value = 1;
            }
            while( (i - value) >= 0  && (i + value) < str.length() ) {
                if(str.charAt(i - value) != str.charAt(i + value)) {
                    break;
                }
                value++;
            }
            if(i + value > mx) {
                mx = i + value;
                id = i;
            }
            values.add(value);
        }
    }

    private static int manacher(String str) {
        if(StringUtils.isBlank(str)) {
            return 0;
        }
        List<Integer> values = new ArrayList<>();
        buildManacher(buildStr(str), values);
        int maxLength = 0;
        for(Integer value : values) {
            if(value > maxLength) {
                maxLength = value;
            }
        }
        return maxLength - 1;
    }

    public static String buildStr(String str) {
        StringBuilder buffer = new StringBuilder(str);
        int i = 0;
        while(i != buffer.length()) {
            buffer.insert(i, '#');
            i += 2;
        }
        buffer.insert(buffer.length(),"#");
        return buffer.toString();
    }

    public static void main(String[] args) {
        System.out.println( maxPalindromeLength("abcde") );
        System.out.println( maxPalindromeLength("abcbae") );
        //将自身单个字符算1
        System.out.println(manacher("abcde"));
        System.out.println(manacher("abcbae"));
    }
}
