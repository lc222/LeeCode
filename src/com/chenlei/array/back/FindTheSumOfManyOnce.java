package com.chenlei.array.back;

import java.util.ArrayList;
import java.util.List;

/**
 *  2.3.2 寻找和为定值的若干个数
 * @author chenlei
 * @since 2017 - 03 - 01 20:40
 */
public class FindTheSumOfManyOnce {

    private static boolean findTheSumOfManyByCut(int target, int i, int nowValue, List<Integer> list) {
        if(nowValue == target) {
            System.out.println(list);
            return true;
        }
        if(i < 1) {
            return false;
        }
        boolean result = false;
        if(nowValue + i <= target) {
            list.add(i);
            result = findTheSumOfManyByCut(target, i - 1, nowValue + i, list);
            list.remove(list.size() - 1);
        }
        if(!result) {
            if ((1 + i - 1) * (i - 1) / 2 >= target - nowValue) {
                result = findTheSumOfManyByCut(target, i - 1, nowValue, list);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        findTheSumOfManyByCut(15, 10, 0, new ArrayList<>());
    }
}
