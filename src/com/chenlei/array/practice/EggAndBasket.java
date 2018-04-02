package com.chenlei.array.practice;

import java.util.ArrayList;
import java.util.List;

/**
 *  28. 鸡蛋放篮子
 * @author chenlei
 * @since 2017 - 05 - 18 14:20
 */
public class EggAndBasket {


    //回溯剪枝
    private static void printAllWays(int eggs, int baskets, List<Integer> oneMethod) {
        if(eggs == 0 || baskets == 0) {
            if(eggs == 0 && baskets == 0) {
                //刚好分完
                System.out.println(oneMethod);
            }
            return;
        }
        for(int i = 1; i <= eggs; i++) {
            if(oneMethod.size() != 0) {
                if(i > oneMethod.get(oneMethod.size() - 1)) {
                    //鸡蛋分配必须按照降序
                    break;
                }
            }
            if(i * baskets < eggs) {
                continue;
            }
            oneMethod.add(i);
            printAllWays(eggs - i, baskets - 1, oneMethod);
            oneMethod.remove(oneMethod.size() - 1);
        }
    }


    public static void main(String[] args) {
        printAllWays(9, 5, new ArrayList<>());
    }
}
