package com.chenlei.string.back;

/** 1.2 变位词
 * @author chenlei
 * @since  2016 - 09 - 04 16:01
 */
public class BrotherWord {

    private static boolean isBrotherWord(String a, String b) {
        int arr[] = new int[26];
        for(char c : a.toCharArray()) {
            arr[c - 'a'] = arr[c - 'a'] + 1;
        }
        for(char c : b.toCharArray()) {
            arr[c - 'a'] = arr[c - 'a'] - 1;
        }
        for(int value : arr) {
            if(value != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isBrotherWord("bad","adbb"));
    }
}
