package com.chenlei.array.practice;

import java.util.ArrayList;
import java.util.List;

/**
 *  49. 约瑟夫环问题
 * @author chenlei
 * @since 2017 - 05 - 24 11:09
 */
public class JosephProblem {

    //O(n)算法
    private static void basic(List<Integer> circle, int m) {
        int nowIndex = 0;
        while(circle.size() > 1) {
            int steps = (m - 1) % circle.size(); //往前走的步数
            nowIndex = (nowIndex + steps) % circle.size();
            circle.remove(nowIndex);
        }
    }

    public static void main(String[] args) {
        List<Integer> circle = new ArrayList<>();
        for(int i = 0; i < 10; i++) {
            circle.add(i);
        }
        basic(circle, 8);
        System.out.println(circle);
    }
}
