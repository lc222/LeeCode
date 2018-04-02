package com.chenlei.array.practice;

import util.NumberUtils;

/**
 *  27. 旋转数组的最小元素
 * @author chenlei
 * @since 2017 - 05 - 18 11:17
 */
public class MinOfRotateNum {

    private static int minOfRotateNum(int []a, int begin, int end) {
        int before = begin, after = end;
        while(before < after) {
            int middle = (before + after) / 2;
            if(a[before] < a[middle]) {
                if(a[middle] <= a[after]) {
                    //整个数组升序
                    return a[before];
                }
                //最小数在后半段
                before = middle + 1;
            } else if(a[before] > a[middle]) {
                //最小数在前半段
                after = middle;
            } else {
                //a[before == a[middle]
                if(a[middle] == a[after]) {
                    return NumberUtils.min(minOfRotateNum(a, before, middle - 1), minOfRotateNum(a, middle + 1, after));
                } else if(a[middle] > a[after]) {
                    before = middle + 1;
                } else {
                    return a[before];
                }
            }
        }
        return a[before];
    }

    public static void main(String[] args) {
        int[] a = {1, 1, 1, 0, 0, 1};
        System.out.println(minOfRotateNum(a, 0, a.length - 1));
    }
}
