package com.chenlei.array.practice;

import com.chenlei.sort.QuickSort;

/**
 *  8. 求两个无序数组的中位数
 * @author chenlei
 * @since 2017 - 03 - 11 9:37
 */
public class FindTheMiddleOfTwoNoSortArray {

    private static Integer findTheK(int a[], int b[], int low, int high, int k) {
        int index = QuickSort.partitionByTwoArray(a, b, low, high);
        if(k == (index - low + 1)) {
            return index < a.length ? a[index] : b[index - a.length];
        }
        if(k < (index - low + 1)) {
            return findTheK(a, b, low, index - 1, k);
        } else {
            return findTheK(a, b, index + 1, high, k - (index - low + 1));
        }
    }

    private static Integer findTheMiddle(int a[], int b[]) {
        int middle = findTheK(a, b, 0, a.length + b.length - 1, (a.length + b.length)/2 + 1);
        if((a.length + b.length) % 2 == 0) {
            //偶数长度
            int before = findTheK(a, b, 0, a.length + b.length - 1, (a.length + b.length)/2);
            middle = (before + middle) / 2;
        }
        return middle;
    }

    public static void main(String[] args) {
        int a[] = {9, 1, 2, 7};
        int b[] = {4, 3, 9, 5, 8};
        System.out.println(findTheMiddle(a, b));
    }
}
