package com.chenlei.array.practice;

import util.NumberUtils;

/**
 *  26. 把数组排成最小的数
 * @author chenlei
 * @since 2017 - 05 - 17 14:18
 */
public class SortArrayMinNum {

    private static void specialSort(Integer a[]) {
        for(int i = 0; i < a.length - 1; i++) {
            int minIndex = i;
            for(int j = i + 1; j < a.length; j++) {
                if(specialMin(a[j], a[minIndex]) == a[j]) {
                    minIndex = j;
                }
            }
            NumberUtils.swapInteger(a, i, minIndex);
        }
    }

    private static int specialMin(int a, int b) {
        StringBuilder strA = new StringBuilder(String.valueOf(a));
        StringBuilder strB = new StringBuilder(String.valueOf(b));
        int compareLength = strA.length() > strB.length() ? strA.length() : strB.length();
        for(int i = 0; i < compareLength; i++) {
            char charA = strA.charAt(i % strA.length());
            char charB = strB.charAt(i % strB.length());
            if(charA < charB) {
                return a;
            }
            if(charA > charB) {
                return b;
            }
        }
        //相等
        return a;
    }

    public static void main(String[] args) {
        Integer a[] = {3, 32, 321};
        specialSort(a);
        NumberUtils.printArray(a);
    }
}
