package com.chenlei.array.back;

import com.chenlei.sort.QuickSort;

/**
 * 2.2.2 找到所有满足和为定值的整数对
 *
 * @author chenlei
 * @since 2016 - 11 - 19 11:58
 */
public class FindTheSumOfTwoAll {

    private static void findTheSumOfTwoAll(int a[], int sum) {
        QuickSort.quickSort(a, 0, a.length - 1);
        int low = 0, high = a.length - 1;
        while (low < high) {
            int currentSum = a[low] + a[high];
            if (currentSum == sum) {
                System.out.println(a[low] + "+" + a[high] + "=" + sum);
                low++;
                high--;
                continue;
            }
            if (currentSum > sum) {
                high--;
            } else {
                low++;
            }
        }
    }

    public static void main(String[] args) {
        int a[] = {3, 4, 1, 5, 9, 2, 6};
        findTheSumOfTwoAll(a, 6);
    }
}
