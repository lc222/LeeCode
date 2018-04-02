package com.chenlei.find;

/**
 * 1. 二分查找
 * @author chenlei
 * @since 2017 - 06 - 04 15:17
 */
public class BinarySearch {

    //找到返回下标，没找到返回-1
    private static int binarySearch(int a[], int target) {
        int begin = 0, end = a.length - 1;
        while(begin <= end) {
            int middle = (begin + end) / 2;
            if(a[middle] == target) {
                return middle;
            } else if(a[middle] < target) {
                begin = middle + 1;
            } else {
                end = middle - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int a[] = {-5, 2, 3,  4,  5,  7,  8,  9};
        System.out.println(binarySearch(a, 6));
    }
}
