package com.chenlei.sort;

import util.NumberUtils;

/**
 * @author chenlei
 * @since 2016 - 11 - 16 22:11
 */
public class MergeSort {

    private static void mergeSort(Integer []array, int before, int end, int []temp) {
        if(before < end) {
            int middle = (before + end) / 2;
            mergeSort(array, before, middle, temp);
            mergeSort(array, middle + 1, end, temp);
            merge(array, before, end, temp);
        }
    }

    private static void merge(Integer []array, int before, int end, int []temp) {
        int middle = (before + end) / 2;
        int first = before, second = middle + 1;
        int tempIndex = before;
        while (first <= middle && second <= end) {
            if(array[first] <= array[second]) {
                temp[tempIndex++] = array[first++];
            } else {
                temp[tempIndex++] = array[second++];
            }
        }
        while (first <= middle) {
            temp[tempIndex++] = array[first++];
        }
        while(second <= end) {
            temp[tempIndex++] = array[second++];
        }
        while(before <= end) {
            array[before] = temp[before];
            before++;
        }
    }

    public static void main(String[] args) {
        Integer[] array = {3, 2, 5, 4, 7};
        int[] temp = {0, 0, 0, 0, 0};
        mergeSort(array, 0, 4, temp);
        NumberUtils.printArray(array);
    }

}
