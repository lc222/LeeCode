package com.chenlei.string.practice;

/**
 *  15 均分01
 * @author chenlei
 * @since 2016 - 11 - 09 22:26
 */
public class Per01 {

    private static void per01(String str) {
        int total0 = 0;
        int total0Now = 0;
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '0') {
                total0++;
                if(i < str.length() / 2) {
                    total0Now++;
                }
            }
        }
        int total0Half = total0 / 2;

        int beforeIndex = 0;
        while(total0Now != total0Half) {
            if(str.charAt(beforeIndex) == '0') {
                total0Now--;
            }
            if(str.charAt(beforeIndex+ (str.length() / 2)) == '0') {
                total0Now++;
            }
            beforeIndex++;
        }
        System.out.println("beforeIndex is " + beforeIndex);
    }

    public static void main(String[] args) {
        per01("010111");
    }
}
