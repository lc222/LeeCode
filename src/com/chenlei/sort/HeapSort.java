package com.chenlei.sort;

import util.NumberUtils;

/**
 * @author chenlei
 * @since 2016 - 11 - 17 20:22
 */
public class HeapSort {

    private static void initHeap(Integer[] array) {
        //初始化从非叶子节点开始
        for(int i = (array.length - 2) / 2; i >= 0; i--) {
            sickDown(array, i, array.length - 1);
        }
    }

    private static void heapSort(Integer[] array) {
        for(int i = array.length - 1; i >= 0; i--) {
            NumberUtils.swapInteger(array, 0, i);
            sickDown(array, 0, i);
        }
    }

    /**
     * 第q个结点向下沉
     */
    private static void sickDown(Integer[] array, int q, int p) {
        int leftChild = 2 * q + 1;
        while(leftChild < p) {
            //q有左子结点
            int min = q;
            if(array[leftChild] < array[min]) {
                min = leftChild;
            }
            if(leftChild + 1 < p && array[leftChild + 1] < array[min]) {
                min = leftChild + 1;
            }
            if(min == q) {
                break;
            }
            NumberUtils.swapInteger(array, q, min);
            q = min;
            leftChild = 2 * q + 1;
        }
    }


    public static void main(String[] args) {
        Integer[] array = {3, 2, 5, 4, 7};
        initHeap(array);
        heapSort(array);
        NumberUtils.printArray(array);
    }
}
