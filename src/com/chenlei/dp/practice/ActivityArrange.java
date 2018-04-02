package com.chenlei.dp.practice;

import util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 2. 带权活动安排
 * @author chenlei
 * @since 2017 - 06 - 09 17:25
 */
public class ActivityArrange {


    //dp[i] = max{dp[j], j.f <= i.s} + i[w]
    private static Integer maxBenefit(List<Activity> activities) {
        List<Integer> maxBenefit = new ArrayList<>();
        for(int i = 0; i < activities.size(); i++) {
            int max = 0;
            for(int j = 0; j < i; j++) {
                if(activities.get(j).f <= activities.get(i).s && maxBenefit.get(j) > max) {
                    max = maxBenefit.get(j);
                }
            }
            maxBenefit.add(max + activities.get(i).w);
        }
        return maxBenefit.stream().max(Integer::compareTo).orElse(-1);
    }

    public static void main(String[] args) {
        Activity d = new Activity(2, 4, 5);
        Activity b = new Activity(1, 3, 4);
        Activity a = new Activity(0, 2, 2);
        Activity c = new Activity(3, 5, 5);
        Activity e = new Activity(4, 5, 2);
        List<Activity> activities = CollectionUtils.asList(a, b, c, d, e);
        activities.sort((o1, o2) -> o1.f - o2.f);
        System.out.println(maxBenefit(activities));
    }

    private static class Activity {
        Activity(int s, int f, int w) {
            this.s = s;
            this.f = f;
            this.w = w;
        }
        int s; //开始时间, 以0分作为起点
        int f; //结束时间
        int w; //收益
    }

}
