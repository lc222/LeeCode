package com.chenlei.array.back;

import com.chenlei.sort.QuickSort;
import util.NumberUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 2.3.3 寻找和为S的K个数的组合
 * @author chenlei
 * @since 2017 - 03 - 01 20:46
 */
public class FindSumOfManyInKNum {

    private static void findTheSumOfManyByCut(int a[], int s, int k, int index, List<Integer> list, int leftTotal) {
        if(s == 0 && list.size() == k) {
            System.out.println(list);
            return;
        }
        if(index >= a.length || list.size() > k) {
            return;
        }
        if(s - a[index] >= 0) {
            list.add(a[index]);
            findTheSumOfManyByCut(a, s - a[index], k, index + 1, list, leftTotal - a[index]);
            list.remove(list.size() - 1);
        }

        if(leftTotal - a[index] >= s) {
            while((index + 1) < a.length && a[index] == a[index+1]) {
                index++;
            }
            findTheSumOfManyByCut(a, s, k, index + 1, list, leftTotal - a[index]);
        }
    }

    public static void main(String[] args) {
        int a[] = {0, 1, 1, 1, 2, 3};
        QuickSort.quickSort(a, 0, a.length - 1);
        NumberUtils.printInArray(a);
        findTheSumOfManyByCut(a, 3, 2, 0, new ArrayList<>(), NumberUtils.sum(a));
    }
}
