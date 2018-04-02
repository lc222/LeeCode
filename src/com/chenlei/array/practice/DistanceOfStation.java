package com.chenlei.array.practice;

import java.util.ArrayList;
import java.util.List;

/**
 * 37.站点之间的距离
 * @author chenlei
 * @since 2017 - 05 - 21 10:34
 */
public class DistanceOfStation {

    private static List<Integer> initCycles(int distance[]) {
        List<Integer> forNow = new ArrayList<>();
        int sum = 0;
        forNow.add(sum);
        for(int i : distance) {
            sum += i;
            forNow.add(sum);
        }
        return forNow;
    }

    //求两站之间的距离，由加法转化为减法
    public static void main(String[] args) {
        int distance[] = {3, 1, 7, 5, 4, 2};
        List<Integer> info = initCycles(distance);
        int i = 0, j = distance.length - 1; // 求第一个到最后一个站点的距离
        int length = info.get(j) - info.get(i);
        int total = info.get(info.size() - 1);
        System.out.println(length < total - length ? length : total - length);
    }
}
