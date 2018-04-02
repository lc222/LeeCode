package com.chenlei.array.practice;

import util.NumberUtils;

import java.util.ArrayList;
import java.util.List;


/**
 * 52. 格子涂色
 * @author chenlei
 * @since 2017 - 05 - 25 10:32
 */
public class ColorGrid {

    //穷举，0表示黄色，1表示蓝色，求m个连续蓝色出现的涂色方法
    private static void basicPrint(int n, int m, List<Integer> list) {
        if(n == 0) {
            int blueCount = 0;
            for(int i = 0; i < list.size(); i++) {
                if(list.get(i) == 1) {
                    blueCount++;
                    if(blueCount >= m) {
                        System.out.println(list);
                        return;
                    }
                } else {
                    blueCount = 0;
                }
            }
            return;
        }
        list.add(0);
        basicPrint(n - 1, m, list);
        list.remove(list.size() - 1);
        list.add(1);
        basicPrint(n - 1, m, list);
        list.remove(list.size() - 1);
    }

    //dp方法。list[i] = 2*list[i-1] + (i-m)^2 - list[i - m-1]
    private static int dp(int n, int m, List<Integer> list) {
        for(int i = 0; i < n; i++) {
            if(i < m - 1) {
                list.add(0);
            } else if(i == m - 1) {
                list.add(1);
            } else {
                int before = NumberUtils.ciFang(2, i - m);
                int reduce = list.get((i- m - 1) < 0 ? 0 : (i - m - 1));
                list.add(2*list.get(i-1) + before - reduce);
            }
        }
        return list.get(list.size() - 1);
    }

    public static void main(String[] args) {
        basicPrint(6, 3, new ArrayList<>());
        System.out.println(dp(6, 3, new ArrayList<>()));
    }
}
