package com.chenlei.dp.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 1. 子序列的个数
 * @author chenlei
 * @since 2017 - 06 - 09 11:24
 */
public class SubSeqCount {

    /**
     * dp[k]=2*dp[k-1]+1;如果a[k]与前k-1个字符都不相同
     * dp[k]=2*dp[k-1]-dp[t-1],如果a[k]与前k-1个字符有相同的，t是与之相同的最近的一个下标
     */
    private static int getSubSeqCount(int a[]) {
        Map<Integer, Integer> index = new HashMap<>();
        index.put(a[0], 0);
        List<Integer> dp = new ArrayList<>();
        for(int i = 1; i < a.length; i++) {
            if(!index.containsKey(a[i])) {
                dp.add(2*dp.get(dp.size() - 1) + 1);
            } else {
                dp.add(2*dp.get(dp.size() - 1) - dp.get(index.get(a[i])));
            }
            index.put(a[i], i);
        }
        return dp.get(dp.size() - 1);
    }

    public static void main(String[] args) {
        int a[] = {4, 13, 14, 1, 2, 3};
        System.out.println(getSubSeqCount(a));
    }
}
