package com.chenlei.array.practice;

import util.NumberUtils;
import util.tuple.Tuple;
import util.tuple.Tuple3;

/**
 *  2. 三个只出现一次的数
 * @author chenlei
 * @since 2017 - 03 - 09 19:04
 */
public class ThreeOnceAppeared {

    private static Tuple3<Integer, Integer, Integer> getThreeOnceAppeared(int a[]) {
        int bit0Count, bit1Count;
        int bit0XorNum, bit1XorNum;
        int firstNum = 0, secondNum = 0;
        int third = 0, otherTwoXor = 0, zeroOrOne = 0;
        int i;
        for(i = 0; i < 32; i++) {
            bit0Count = 0;
            bit1Count = 0;
            bit0XorNum = 0;
            bit1XorNum = 0;
            for(int anA : a) {
                if((anA & (1 << i)) == 0) {
                    bit0Count++;
                    bit0XorNum ^= anA;
                } else {
                    bit1Count++;
                    bit1XorNum ^= anA;
                }
            }
            if(bit0Count % 2 == 0 && bit0XorNum != 0) {
                otherTwoXor = bit0XorNum;
                zeroOrOne = 0;
                third = bit1XorNum;
                break;
            }
            if(bit1Count % 2 == 0 && bit1XorNum != 0) {
                otherTwoXor = bit1XorNum;
                zeroOrOne = 1;
                third = bit0XorNum;
                break;
            }
        }
        int bitOfOne = NumberUtils.getBitOne(otherTwoXor);
        for(int anA : a) {
            if((anA & (1 << i)) == zeroOrOne) {
                if((anA & (1 << (bitOfOne - 1))) == 0 ) {
                    firstNum ^= anA;
                } else {
                    secondNum ^= anA;
                    continue;
                }
            }
        }
        return Tuple.of(firstNum, secondNum, third);
    }



    public static void main(String[] args) {
        int a[] = {1, 2, 4, 16, 17, 2, 1};
        Tuple3<Integer, Integer, Integer> result = getThreeOnceAppeared(a);
        System.out.println(result._1().orElse(null) + " " + result._2().orElse(null) + " " + result._3().orElse(null));

    }
}
