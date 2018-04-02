package com.chenlei.dp;

import java.util.ArrayList;
import java.util.List;

/**
 *  4. 交替字符串
 * @author chenlei
 * @since 2017 - 06 - 09 8:13
 */
public class MergeString {

    //dp[i][j] = true =  {s1[i-1] == s3[i+j-1] && dp[i-1][j]==true || s2[j-1] == s3[i+j-1] && dp[i][j-1]==true}
    //dp方法时间O(n^2)，空间O(n^2)
    private static boolean isMergeStringByDP(String s1, String s2, String s3) {
        List<List<Boolean>> dp = initDP(s1);
        //边界赋值
        dp.get(0).add(true); //dp[0][0]为零
        for(int i = 1; i <= s2.length(); i++) {
            if(dp.get(0).get(dp.get(0).size() - 1)) {
                if(s3.charAt(i - 1) == s2.charAt(i - 1)) {
                    dp.get(0).add(true);
                } else {
                    dp.get(0).add(false);
                }
            } else {
                dp.get(0).add(false);
            }
        }
        for(int j = 1; j <= s1.length(); j++) {
            if(dp.get(j - 1).get(0)) {
                if(s3.charAt(j - 1) == s1.charAt(j - 1)) {
                    dp.get(j).add(true);
                } else {
                    dp.get(j).add(false);
                }
            } else {
                dp.get(j).add(false);
            }
        }
        for(int i = 1; i <= s1.length(); i++) {
            for(int j = 1;j <= s2.length(); j++) {
                if(s1.charAt(i - 1) == s3.charAt(i + j - 1) && dp.get(i - 1).get(j)) {
                    dp.get(i).add(true);
                } else if(s2.charAt(j - 1) == s3.charAt(i + j - 1) && dp.get(i).get(j - 1)) {
                    dp.get(i).add(true);
                } else {
                    dp.get(i).add(false);
                }
            }
        }
        return dp.get(s1.length()).get(s2.length());
    }

    private static List<List<Boolean>> initDP(String target) {
        List<List<Boolean>> dp = new ArrayList<>();
        for(int i = 0; i <= target.length(); i++) {
            dp.add(new ArrayList<>());
        }
        return dp;
    }

    public static void main(String[] args) {
        System.out.println(isMergeStringByDP("aabcc", "dbbca", "aadbbcbcac"));
        System.out.println(isMergeStringByDP("aabcc", "dbbca", "accabdbbca"));
    }
}
