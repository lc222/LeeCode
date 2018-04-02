package com.chenlei.find;

import util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 2. 杨氏矩阵的查找
 * @author chenlei
 * @since 2017 - 06 - 05 10:39
 */
public class YoungTableau {

    //从左下角开始查找, 时间O(n + m)
    private static boolean find(List<List<Integer>> tableau, int n, int m, int target) {
        int rowIndex = n - 1, columnIndex = 0;
        while(rowIndex >= 0 && columnIndex < m) {
            int value = tableau.get(rowIndex).get(columnIndex);
            if(value < target) {
                rowIndex--;
            } else if(value > target) {
                columnIndex++;
            } else {
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        List<List<Integer>> tableau = new ArrayList<>();
        tableau.add(CollectionUtils.asList(1, 2, 8, 9));
        tableau.add(CollectionUtils.asList(2, 4, 9, 12));
        tableau.add(CollectionUtils.asList(4, 7, 10, 13));
        tableau.add(CollectionUtils.asList(6, 8, 11, 15));
        System.out.println(find(tableau, 4, 4, 5));
    }
}
