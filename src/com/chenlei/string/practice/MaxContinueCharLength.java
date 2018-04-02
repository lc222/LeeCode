package com.chenlei.string.practice;

/**
 * 12 最长连续字符递归写法
 * @author chenlei
 * @since  2016 - 10 - 23 10:25
 */
public class MaxContinueCharLength {

    private static int maxContinueCharLength(String str, int index) {
        if(index < 0 || index >= str.length()) {
            return 0;
        }
        int after = index+1;
        while(after < str.length()) {
            if(str.charAt(after - 1) == str.charAt(after)) {
                after++;
            } else {
                break;
            }
        }
        if(after >= str.length()) {
            return after - index;
        } else {
            int otherMaxLength = maxContinueCharLength(str, after);
            return (after - index) > otherMaxLength ? (after - index) : otherMaxLength;
        }
    }

    public static void main(String[] args) {
        System.out.println(maxContinueCharLength("aaaabbcc",0));
        System.out.println(maxContinueCharLength("aabb",0));
        System.out.println(maxContinueCharLength("ab",0));
    }
}
