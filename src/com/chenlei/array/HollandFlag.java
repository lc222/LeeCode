package com.chenlei.array;

import util.NumberUtils;

/**
 *  2.7 荷兰国旗
 * @author chenlei
 * @since 2016 - 11 - 30 20:27
 */
public class HollandFlag {

    private static void improve(int[] arr) {
        int left = 0, current = 0, right = arr.length - 1;
        while(current <= right) {
            if(arr[current] == 0) {
                NumberUtils.swapInt(arr, left, current);
                left++;
                current++;
            } else if(arr[current] == 1) {
                current++;
            }  else {
                NumberUtils.swapInt(arr, current, right);
                right--;
            }
        }
        NumberUtils.printInArray(arr);
    }

    public static void main(String[] args) {
        int[] array1 = {2, 0, 1, 0, 0, 2, 1, 1, 2};
        improve(array1);
        int[] array2 = {0, 1, 2, 1, 1, 2, 0, 2, 1, 0};
        improve(array2);
    }
}
