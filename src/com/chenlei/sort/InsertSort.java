package com.chenlei.sort;

import util.NumberUtils;

/**
 * @author chenlei
 * @since 2016 - 11 - 16 20:05
 */
public class InsertSort {

    private static void insertSort(Integer[] array) {
        for(int i = 1; i < array.length; i++) {
            int target = array[i];
            int j = i - 1;
            for( ; j >= 0 ; j --) {
                if(array[j] > target) {
                    array[j + 1] = array[j];
                } else {
                    break;
                }
            }
            array[j + 1] = target;
        }
    }

    public static void main(String[] args) {
        Integer[] array = {3, 2, 5, 4, 7};
        insertSort(array);
        NumberUtils.printArray(array);
    }
}
