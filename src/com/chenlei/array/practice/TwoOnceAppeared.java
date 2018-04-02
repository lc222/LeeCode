package com.chenlei.array.practice;

import util.NumberUtils;
import util.tuple.Tuple;
import util.tuple.Tuple2;

/**
 *  3. 两个只出现一次的数字
 * @author chenlei
 * @since 2017 - 03 - 08 20:31
 */
public class TwoOnceAppeared {

    private static Tuple2<Integer, Integer> twoOnce(int a[]) {
        int xor = 0;
        for (int anA : a) {
            xor = xor ^ anA;
        }
        int bitOfOne = NumberUtils.getBitOne(xor);
        int firstNum = 0, secondNum = 0;
        for (int anA : a) {
            if ((anA & (1 << (bitOfOne - 1))) != 0) {
                firstNum = firstNum ^ anA;
            } else {
                secondNum = secondNum ^ anA;
            }
        }
        return Tuple.of(firstNum, secondNum);
    }

    public static void main(String[] args) {
        int a[] = {1, 4, 8, 2, 3, 8, 4, 1};
        Tuple2<Integer, Integer> result = twoOnce(a);
        System.out.println("firstNum is " + result._1().orElse(null) + ", secondNum is " + result._2().orElse(null));
    }
}
