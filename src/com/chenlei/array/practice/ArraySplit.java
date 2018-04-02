package com.chenlei.array.practice;

import util.NumberUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 30.数组分裂
 * @author chenlei
 * @since 2017 - 05 - 19 16:10
 */
public class ArraySplit {

    //0-1背包动态规划解法。也可用回溯剪枝，但是按照题意，时间复杂度过高。
    private static List<Integer> getThisFloorInfo(int num, int capacity, List<Integer> lastFloor) {
        List<Integer> thisFloor = new ArrayList<>();
        for(int i = 1; i <= capacity; i++) {
            if(num < i) {
                int notInclude = lastFloor.get(i - 1);
                int include = lastFloor.get(i - num - 1) + num;
                thisFloor.add(include > notInclude ? include : notInclude);
            } else if(num > i) {
                thisFloor.add(lastFloor.get(i - 1));
            } else {
                //num=i
                int notInclude = lastFloor.get(i - 1);
                thisFloor.add(num > notInclude ? num : notInclude);
            }
        }
        return thisFloor;
    }

    private static int getReduce(int a[]) {
        int halfSum = NumberUtils.sum(a) / 2;
        List<Integer> lastFloor = initFirstFloor(a[0], halfSum);
        for (int i = 1; i < a.length; i++) {
            lastFloor = getThisFloorInfo(a[i], halfSum, lastFloor);
        }
        return halfSum - lastFloor.get(lastFloor.size() - 1);
    }

    private static List<Integer> initFirstFloor(int num, int capacity) {
        List<Integer> firstFloor = new ArrayList<>();
        for(int i = 1; i <= capacity; i++) {
            firstFloor.add(num <= i ? num : 0);
        }
        return firstFloor;
    }

    public static void main(String[] args) {
        int a[] = {2, 5,  6, 10};
        int reduce = getReduce(a);
        System.out.println(reduce);
    }
}
