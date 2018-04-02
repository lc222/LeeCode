package com.chenlei.array;

import com.chenlei.sort.QuickSort;

/**
 * 2.1 寻找最小的k个数
 * @author chenlei
 * @since 2016 - 09 - 11 17:30
 */
public class FindTheKMin {

    private static int findK(int []a, int low, int high, int k) {
        int index = QuickSort.partition(a, low, high);
        if(k == (index - low + 1)) {
            return a[index];
        }
        if(k < (index - low + 1)) {
            return findK(a, low, index - 1, k);
        } else {
            return findK(a, index + 1, high, k - (index - low + 1));
        }
    }

    private static int findK(int []a, int k) {
        return findK(a, 0, a.length - 1, k);
    }

    public static void main(String[] args) {
        int[] a = {3,6,2,1,5,7};
        System.out.println(findK(a,2));
    }
}
