package com.chenlei.array.practice;

import java.util.ArrayList;
import java.util.List;

/**
 * 54.不用除法运算
 * @author chenlei
 * @since 2017 - 05 - 26 16:16
 */
public class NotDivisionConquer {

    //一个数的值等于左边乘积x右边乘积
    private static void conquer(int a[], List<Integer> result) {
        int lastMatrix = 1;
        for(int i : a) {
            result.add(lastMatrix);
            lastMatrix = lastMatrix * i;
        }
        lastMatrix = 1;
        for(int i = result.size() - 1; i >= 0; i--) {
            result.set(i, result.get(i) * lastMatrix);
            lastMatrix = lastMatrix * a[i];
        }
    }

    public static void main(String[] args) {
        int a[] = {2, 3, 4, 5, 6, 7};
        List<Integer> b = new ArrayList<>();
        conquer(a, b);
        System.out.println(b);
    }
}
