package com.chenlei.sort;

import util.NumberUtils;

/**
 * 冒泡排序
 * @author chenlei
 * @since 2016 - 11 - 16 21:04
 */
public class BubbleSort {

    private static void bubbleSort(Integer[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            boolean changed = false;
            for (int j = array.length - 1; j > i; j--) {
                if (array[j] < array[j - 1]) {
                    changed = true;
                    NumberUtils.swapInteger(array, j - 1, j);
                }
            }
            if(!changed) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        Integer[] array = {3, 2, 5, 4, 7};
        bubbleSort(array);
        NumberUtils.printArray(array);
    }
}
