package com.chenlei.array.practice;

import com.chenlei.sort.QuickSort;
import util.NumberUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * 25. 数组分割
 * @author chenlei
 * @since 2017 - 05 - 16 15:07
 */
public class ArrayPerGroup {

    //回溯剪枝
    private static boolean isPerGroups(int a[], Map<Integer, Integer> capacity, int index, int per) {
        if(index == a.length) {
            for(Map.Entry<Integer, Integer> entry : capacity.entrySet()) {
                if(entry.getValue() != per) {
                    return false;
                }
            }
            return true;
        }
        for(int i = 1; i <= capacity.size(); i++) {
            if(capacity.get(i) + a[index] <= per) {
                capacity.put(i, capacity.get(i) + a[index]);
                if(isPerGroups(a, capacity, index + 1, per)) {
                    return true;
                }
                capacity.put(i, capacity.get(i) - a[index]);
            }
        }
        return false;
    }

    private static int groups(int a[]) {
        QuickSort.quickSort(a, 0, a.length - 1);
        int sum = NumberUtils.sum(a);
        for(int i = NumberUtils.abs(sum); i > 1; i--) {
            if(NumberUtils.abs(sum) % i == 0) {
                int per = sum / i;
                if(per < a[a.length - 1]) {
                    continue;
                }
                Map<Integer, Integer> capacity = initCapacity(i);
                if(isPerGroups(a, capacity, 0, per)) {
                    return i;
                }
            }
        }
        return -1;
    }

    private static Map<Integer, Integer> initCapacity(int count) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 1; i <= count; i++) {
            map.put(i, 0);
        }
        return map;
    }

    public static void main(String[] args) {
        int a[] = {3, 2, 4, 3, 6};
        System.out.println(groups(a));
    }
}
