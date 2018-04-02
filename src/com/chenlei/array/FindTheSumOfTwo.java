package com.chenlei.array;

import com.chenlei.sort.QuickSort;

/**
 *  2.2 寻找和为定值的两个数
 * @author chenlei
 * @since  2016 - 09 - 11 20:16
 */
public class FindTheSumOfTwo {

    private static void findTheSumOfTwo(int a[], int sum) {
        QuickSort.quickSort(a, 0, a.length - 1);
        int low = 0, high = a.length - 1;
        while (low < high) {
            int currentSum = a[low] + a[high];
            if (currentSum == sum) {
                System.out.println(a[low] + "+" + a[high] + "=" + sum);
                break;
            }
            if (currentSum > sum) {
                high--;
            } else {
                low++;
            }
        }
    }

    public static void main(String[] args) {
//        int a[] = {1, 2, 3, 5, 6, 8, 9};
        int a[] = {3, 8, 1, 5, 9, 2, 6};
        findTheSumOfTwo(a, 6);
    }
}
