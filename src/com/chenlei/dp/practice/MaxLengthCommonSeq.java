package com.chenlei.dp.practice;

import util.NumberUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 3. 最长公共子序列
 * @author chenlei
 * @since 2017 - 06 - 10 13:00
 */
public class MaxLengthCommonSeq {

    //dp[i][j] = a[i] == b[j] ? dp[i-1][j-1] + 1 : max{dp[i-1][j], dp[i][j-1]}
    private static int maxLengthOfCommonSeq(int a[], int b[]) {
        List<List<Integer>> dp = initDP(a.length);
        for (int aB : b) {
            if (a[0] == aB) {
                dp.get(0).add(1);
            } else {
                dp.get(0).add(0);
            }
        }
        for(int j = 1; j < a.length; j++) {
            if(b[0] == a[j]) {
                dp.get(j).add(1);
            } else {
                dp.get(j).add(0);
            }
        }
        for(int i = 1; i < a.length; i++) {
            for(int j = 1; j < b.length; j++) {
                if(a[i] == b[j]) {
                    dp.get(i).add(dp.get(i - 1).get(j - 1) + 1);
                } else {
                    dp.get(i).add(NumberUtils.max(dp.get(i - 1).get(j), dp.get(i).get(j - 1)));
                }
            }
        }
        return dp.get(a.length - 1).get(b.length - 1);
    }

    private static List<List<Integer>> initDP(int length) {
        List<List<Integer>> dp = new ArrayList<>();
        for(int i = 0; i < length; i++) {
            dp.add(new ArrayList<>());
        }
        return dp;
    }

    public static void main(String[] args) {
        int a[] = {1, 3, 4, 5, 5};
        int b[] = {2, 4, 5, 5, 7, 6};
        System.out.println(maxLengthOfCommonSeq(a, b));
    }
}
