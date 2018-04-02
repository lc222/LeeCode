package com.chenlei.array.practice;

import util.NumberUtils;

/**
 *  18. 数组中的最小绝对值
 * @author chenlei
 * @since 2017 - 03 - 21 19:34
 */
public class MinAbs {

    private static int minAbs(int a[], int before, int after) {
        int begin = before, end = after;
        while(begin <= end) {
            int middle = (begin + end) / 2;
            if(a[middle] == 0) {
                return 0;
            } else if(a[middle] < 0) {
                begin = middle + 1;
            } else {
                end = middle - 1;
            }
        }
        if(end < before) {
            return a[begin];
        } else if(begin > after) {
            return a[after];
        } else {
            return NumberUtils.abs(a[begin]) < NumberUtils.abs(a[end]) ? a[begin] : a[end];
        }
    }

    public static void main(String[] args) {
        int a[] = {-3, -2, -1, 2, 3, 4};
        System.out.println(minAbs(a, 0, a.length - 1));
    }
}
