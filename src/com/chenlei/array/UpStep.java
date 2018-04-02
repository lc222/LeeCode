package com.chenlei.array;

import java.util.ArrayList;
import java.util.List;

/**
 *  2.5 跳台阶问题
 * @author chenlei
 * @since 2016 - 11 - 28 20:53
 */
public class UpStep {

    public static int ways(int n) {
        if(n < 3) {
            return n;
        }
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        for(int i = 2; i < n; i++) {
            list.add(list.get(i - 1) + list.get(i - 2));
        }
        return list.get(list.size() - 1);
    }

    public static void main(String[] args) {
        System.out.println(ways(4));
    }
}
