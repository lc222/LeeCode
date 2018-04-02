package com.chenlei.string;

import util.StringUtils;

/**
 * 1.5 回文判断
 * @author chenlei
 * @since  2016 - 09 - 06 21:30
 */
public class Palindrome {

    private static boolean isPalindrome(String str) {
        if(StringUtils.isBlank(str)) {
            return false;
        }
        int before = 0, after = str.length() - 1;
        while(before < after) {
            if(str.charAt(before) != str.charAt(after)) {
                return false;
            }
            before++;
            after--;
        }
        return true;
    }

    private static boolean isPalindromeByMiddle(String str) {
        int before = str.length() / 2 - 1, after;
        if(str.length() % 2 == 0) {
            after = str.length() / 2;
        } else {
            after = str.length() / 2 + 1;
        }
        while(before >= 0) {
            if(str.charAt(before) != str.charAt(after)) {
                return false;
            }
            before--;
            after++;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("issi"));
        System.out.println(isPalindrome("abcba"));
        System.out.println(isPalindrome("abcea"));
        System.out.println(isPalindromeByMiddle("issi"));
        System.out.println(isPalindromeByMiddle("abcba"));
        System.out.println(isPalindromeByMiddle("abcea"));
    }
}
