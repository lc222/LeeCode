package com.chenlei.array.practice;

import util.NumberUtils;

import static com.chenlei.sort.QuickSort.quickSort;

/**
 *  9. 寻找满足条件的数对
 * @author chenlei
 * @since 2017 - 03 - 11 10:24
 */
public class FindThePair {

    private static void printThePair(int a[]) {
        int first = 0, second = 1;
        while(second < a.length) {
            if(a[first] * 2 == a[second]) {
                System.out.println("first is " + a[first] + ", second is " + a[second]);
                first++;
                second++;
            } else {
                if(a[first] * 2 < a[second]) {
                    first++;
                } else {
                    second++;
                }
            }
        }
    }

    public static void main(String[] args) {
        int array[] = {10, 3, 2, 5, 4, 7, 1};
        quickSort(array, 0, array.length - 1);
        NumberUtils.printInArray(array);
        printThePair(array);
    }
}
