package com.chenlei.array.practice;

import util.NumberUtils;

/**
 * 45. 只能进行0与其他数的交换操作的排序
 * @author chenlei
 * @since 2017 - 05 - 22 18:21
 */
public class SortByZero {

    //利用0来作为中间变量，指针不回溯来保证O(n)复杂度
    private static void sortByZero(int a[]) {
        if(a.length <=1) {
            return;
        }
        int zeroIndex = 0;
        for(int i = 0; i < a.length; i++) {
            if(a[i] == 0) {
                zeroIndex = i;
                break;
            }
        }
        //把0换到0的位置
        NumberUtils.swapInt(a, zeroIndex, 0);
        int currentIndex = 1;
        while (currentIndex < a.length) {
            if(a[currentIndex] == currentIndex) {
                currentIndex++;
            } else {
                int targetIndex = a[currentIndex];
                NumberUtils.swapInt(a, 0, targetIndex);
                NumberUtils.swapInt(a, currentIndex, targetIndex);
                NumberUtils.swapInt(a, 0, currentIndex);
            }
        }
    }

    public static void main(String[] args) {
        int a[] = {4, 2, 6, 0, 7, 3, 1, 5};
        sortByZero(a);
        NumberUtils.printInArray(a);
    }
}
