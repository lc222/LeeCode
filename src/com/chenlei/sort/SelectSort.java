package com.chenlei.sort;

import util.NumberUtils;

/**
 * @author chenlei
 * @since 2016 - 11 - 16 21:33
 */
public class SelectSort {

    private static void selectSort(Integer []array) {
        for(int i = 0; i < array.length - 1; i++) {
            int minIndex = i;
            for(int j = i + 1; j < array.length; j++) {
                if(array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            NumberUtils.swapInteger(array, i, minIndex);
        }
    }

    public static void main(String[] args) {
        Integer[] array = {3, 2, 5, 4, 7};
        selectSort(array);
        NumberUtils.printArray(array);
    }
}
