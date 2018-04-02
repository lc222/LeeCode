package com.chenlei.dp;

import util.NumberUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 2. 字符串的编辑距离
 * @author chenlei
 * @since 2017 - 06 - 08 15:22
 */
public class EditDistance {

    //dp : dp[i][j] = min{dp[i][j-1]+1, dp[i-1][j]+1, dp[i-1][j-1] + t[i]==s[i] ? 0 : 1}
    private static int editDistance(String target, String source) {
        List<List<Integer>> dp = initDP(target);
        for(int i = 0; i <= source.length(); i++) {
            //对dp[0][0...source.length]赋值
            dp.get(0).add(i);
        }
        for(int j = 1; j <= target.length(); j++) {
            dp.get(j).add(j);
        }
        for(int i = 1; i <= target.length(); i++) {
            for(int j = 1; j <= source.length(); j++) {
                int distance;
                if(target.charAt(i - 1) == source.charAt(j - 1)) {
                    //比较第i个和第j个字符
                    distance = dp.get(i - 1).get(j - 1);
                } else {
                    distance = 1 + NumberUtils.minOfThree(dp.get(i - 1).get(j), dp.get(i).get(j - 1), dp.get(i - 1).get(j - 1));
                }
                dp.get(i).add(distance);
            }
        }
        return dp.get(target.length()).get(source.length());
    }


    private static List<List<Integer>> initDP(String target) {
        List<List<Integer>> dp = new ArrayList<>();
        for(int i = 0; i <= target.length(); i++) {
            dp.add(new ArrayList<>());
        }
        return dp;
    }

    public static void main(String[] args) {
        String target = "ALTRUISTIC";
        String source = "ALGORITHM";
        System.out.println(editDistance(target, source));
    }
}
