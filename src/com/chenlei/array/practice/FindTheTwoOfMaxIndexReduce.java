package com.chenlei.array.practice;

import com.chenlei.sort.QuickSort;
import util.NumberUtils;

/**
 *  16.寻找下标差值最大的两个数
 * @author chenlei
 * @since 2017 - 03 - 20 20:06
 */
public class FindTheTwoOfMaxIndexReduce {

    //问题转换为求数组中两个数的最大差值(后面的数-前面的数)，时间O(n)，空间O(n)
    private static void findTheTwoOfMaxIndexReduce(int a[]) {
        int maxReduce = Integer.MIN_VALUE;
        int before = 0, after = 0;
        for(int i = 1; i < a.length; i++) {
            if(a[i] < a[before]) {
                before = i;
            } else {
                if(a[i] - a[before] > maxReduce) {
                    maxReduce = a[i] - a[before];
                    after = i;
                }
            }
        }
        System.out.println("before = " + before + " after = " + after);
    }

    public static void main(String[] args) {
        //先对数组排序，并替换下标
        int a[] = {3, 1, 2, 5, 4};
        QuickSort.quickSort(a, 0, a.length - 1);
        NumberUtils.printInArray(a);
        a[0] = 1;
        a[1] = 2;
        a[2] = 0;
        a[3] = 4;
        a[4] = 3;
        NumberUtils.printInArray(a);
        findTheTwoOfMaxIndexReduce(a);
    }
}
