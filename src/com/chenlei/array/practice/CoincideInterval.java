package com.chenlei.array.practice;

import java.util.ArrayList;
import java.util.List;

/**
 * 56. 重合区间段
 *
 * @author chenlei
 * @since 2017 - 05 - 27 10:31
 */
public class CoincideInterval {

    private static int getCoincide(List<Interval> intervals) {
        int maxRight = 0;
        int maxCoinCide =Integer.MIN_VALUE;
        for (Interval interval : intervals) {
            int coinCide = interval.begin < maxRight ? maxRight - interval.begin : 0;
            if(coinCide > maxCoinCide) {
                maxCoinCide = coinCide;
            }
            if(interval.end > maxRight) {
                maxRight = interval.end;
            }
        }
        return maxCoinCide;
    }

    public static void main(String[] args) {
        Interval interval1 = new Interval();
        interval1.begin = 0;
        interval1.end = 3;
        Interval interval2 = new Interval();
        interval2.begin = 1;
        interval2.end = 5;
        Interval interval3 = new Interval();
        interval3.begin = 2;
        interval3.end = 6;
        Interval interval4 = new Interval();
        interval4.begin = 6;
        interval4.end = 8;
        List<Interval> intervals = new ArrayList<>();
        intervals.add(interval1);
        intervals.add(interval2);
        intervals.add(interval3);
        intervals.add(interval4);
        System.out.println(getCoincide(intervals));
    }

    private static class Interval {
        int begin;
        int end;
    }
}
