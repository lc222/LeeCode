package com.chenlei.array.back;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 2.5.2 投硬币问题
 * @author chenlei
 * @since 2016 - 11 - 23 11:42
 */
public class Coin {

    //基本的剪枝搜索，类似于for循环
    private static int fBasic(int val, List<Integer> coins, int index) {
        if (val == 0) {
            return 1;
        }
        if (index == coins.size()) {
            return 0;
        }
        int count = 0;
        while (val >= 0) {
            count += fBasic(val, coins, index + 1);
            val -= coins.get(index);
        }
        return count;
    }

    //动态规划(O(n^2))
    private static int fDp(int val, List<Integer> coins) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < coins.size(); i++) {
            map.put(i, new ArrayList<>());
        }
        for(int i = 0; i < coins.size(); i++) {
            List<Integer> before = map.get(i);

            before.add(1);

            for(int j = 1; j <= val; j++) {
                int k = j;
                int count = 0;
                if(i == 0) {
                    if(j % coins.get(i) == 0) {
                        count = 1;
                    }
                } else {
                    while(k >= 0) {
                        count += map.get(i - 1).get(k);
                        k -= coins.get(i);
                    }
                }
                before.add(count);
            }
        }
        return map.get(coins.size() - 1).get(val);
    }

    public static void main(String[] args) {
        List<Integer> coins = new ArrayList<>();
        coins.add(1);
        coins.add(2);
        coins.add(5);
        coins.add(10);
        System.out.println(fBasic(100, coins, 0));
        System.out.println(fDp(100, coins));
    }

}
