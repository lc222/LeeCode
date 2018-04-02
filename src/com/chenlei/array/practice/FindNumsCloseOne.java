package com.chenlei.array.practice;

import util.NumberUtils;

import java.util.ArrayList;
import java.util.List;

/**
 *  11. 寻找接近给定和的若干个数
 * @author chenlei
 * @since 2017 - 03 - 12 10:41
 */
public class FindNumsCloseOne {

    private static Integer closeValue = Integer.MAX_VALUE;

    private static void findNumsCloseOne(int a[], int index, int target, List<Integer> tempList, int nowValue, List<Integer> closeList) {
        if(NumberUtils.distance(target, nowValue) < NumberUtils.distance(target, closeValue)) {
            closeValue = nowValue;
            closeList.clear();
            closeList.addAll(tempList);
        }
        if(index >= a.length || nowValue > target) {
            return;
        }
        //不包含a[index]
        findNumsCloseOne(a, index + 1, target, tempList, nowValue, closeList);
        //包含a[index]
        tempList.add(a[index]);
        findNumsCloseOne(a, index + 1, target, tempList, nowValue + a[index], closeList);
        tempList.remove(tempList.size() - 1);
    }

    public static void main(String[] args) {
        int a[] = {1, 2, 4, 7, 8, 11, 14, 17, 23};
        List<Integer> closeList = new ArrayList<>();
        findNumsCloseOne(a, 0, 42, new ArrayList<>(), 0, closeList);
        System.out.println(closeList);
    }
}
