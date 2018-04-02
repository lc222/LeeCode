package com.chenlei.array;

import util.NumberUtils;

/**
 *  2.6 奇偶数排序
 * @author chenlei
 * @since 2016 - 11 - 29 20:32
 */
public class OddEvenSort {

    private static void byMiddle(int []array) {
        int before = 0, after = array.length - 1;
        while (true) {
            while(before <= after && NumberUtils.isOdd(array[before])) before++;
            while(before <= after && !NumberUtils.isOdd(array[after])) after--;
            if(before > after) {
                break;
            }
            NumberUtils.swapInt(array, before, after);
        }
        NumberUtils.printInArray(array);
    }

    private static void byLeft(int []array) {
        int before = 0, after;
        while(true) {
            while(before < array.length && NumberUtils.isOdd(array[before])) before++;
            after = before + 1;
            while(after < array.length && !NumberUtils.isOdd(array[after])) after++;
            if(after >= array.length) {
                break;
            }
            NumberUtils.swapInt(array, before, after);
        }
        NumberUtils.printInArray(array);
    }


    public static void main(String[] args) {
        int []array = {3, 2, 4, 5, 7, 6};
        byMiddle(array);
        byLeft(array);
    }
}
