package com.chenlei.string;

/** 1.2 字符串包含
 * @author chenlei
 * @since  2016 - 09 - 04 15:22
 */
public class StringContain {

    private static boolean stringContainByHash(String a, String b) {
        boolean[] array = new boolean[26];
        for(char c : a.toCharArray()) {
            array[c - 'A'] = true;
        }
        for(char c : b.toCharArray()) {
            if(!array[c - 'A']) {
                return false;
            }
        }
        return true;
    }

    private static boolean stringContainByBit(String a, String b) {
        int aBit = 0;
        for(char c : a.toCharArray()) {
            aBit |= 1 << (c - 'A');
        }
        for(char c : b.toCharArray()) {
            if((aBit & (1 << (c - 'A'))) == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(stringContainByHash("ABCD","BD"));
        System.out.println(stringContainByBit("ABCD","BCDE"));
    }
}
