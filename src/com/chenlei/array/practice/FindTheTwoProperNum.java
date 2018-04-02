package com.chenlei.array.practice;

import util.NumberUtils;

import static com.chenlei.sort.QuickSort.quickSort;

/**
 *  10. 寻找满足条件的两个数(寻找其和最接近0的两个数)
 * @author chenlei
 * @since 2017 - 03 - 11 10:31
 */
public class FindTheTwoProperNum {

    private static void findTheTwoNum(int a[]) {
        int before = 0, after = a.length - 1;
        int min = Integer.MAX_VALUE, minBefore = -1, minAfter = -1;
        while(before < after) {
            int now = a[before] + a[after];
            if(NumberUtils.abs(now) < min) {
                min = NumberUtils.abs(now);
                minBefore = before;
                minAfter = after;
                if(min == 0) {
                    break;
                }
            }
            if(now > 0) {
                after--;
            } else {
                before++;
            }
        }
        System.out.println("min is " + min + ", before=" + a[minBefore] + ", after=" + a[minAfter]);
    }


    public static void main(String[] args) {
        int array[] = {7, -3, 2, -1, -5, -4, 6, 1};
        quickSort(array, 0, array.length - 1);
        NumberUtils.printInArray(array);
        findTheTwoNum(array);
    }
}
