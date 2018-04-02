package com.chenlei.array.practice;

import util.NumberUtils;

import java.util.ArrayList;
import java.util.List;

/**
 *  53.测试鸡蛋的硬度
 * @author chenlei
 * @since 2017 - 05 - 26 9:58
 */
public class HardnessOfEgg {


    //两个鸡蛋在m层的最差情况下的最少尝试次数
    //f(n) = min{ 1 + max(i-1, f(n-i) ) }
    private static int getLeastTryTimesByTwoEgg(int m, List<Integer> info) {
        info.add(0);
        for(int n = 1; n <= m; n++) {
            int min = Integer.MAX_VALUE;
            for(int i = 1; i <= n; i++) {
                int iFloorTimes = 1 + NumberUtils.max(i - 1, info.get(n - i));
                if(iFloorTimes < min) {
                    min = iFloorTimes;
                }
            }
            info.add(min);
        }
        return info.get(info.size() - 1);
    }

    //m个鸡蛋在n层的最差情况下的最少尝试次数
    //f(n,m) = min{ 1 + max( f(i - 1, m - 1), f(n - i, m) ) }
    private static int getLeastTryTimes(int n, int m, List<List<Integer>> info) {
        List<Integer> thisFloor = new ArrayList<>();
        for(int i = 0; i <= m; i++) {
            thisFloor.add(0);
        }
        info.add(thisFloor);

        for(int i = 1; i <= n; i++) {
            thisFloor = new ArrayList<>();
            thisFloor.add(0);
            for(int j = 1; j <= m; j++) {
                int min = Integer.MAX_VALUE;
                for(int q = 1; q <= i; q++) {
                    if(j == 1 && q > 1) {
                        break;
                    }
                    int value = 1 + NumberUtils.max(info.get(q - 1).get(j - 1), info.get(i - q).get(j));
                    if(value < min) {
                        min = value;
                    }
                }
                thisFloor.add(min);
            }
            info.add(thisFloor);
        }

        return info.get(n).get(m);
    }

    public static void main(String[] args) {
        System.out.println(getLeastTryTimesByTwoEgg(1000, new ArrayList<>()));

        System.out.println(getLeastTryTimes(1000, 2, new ArrayList<>()));
    }
}
