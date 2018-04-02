package com.chenlei.array.practice;

import util.NumberUtils;

/**
 * 43. 逆序对的数量
 * @author chenlei
 * @since 2017 - 05 - 22 15:38
 */
public class InvertedPair {

    //逆序对，遍历解法，稳定O(n^2)
    private static int basic(int a[]) {
        int total = 0;
        for(int i = 1; i < a.length; i++) {
            for(int j = 0; j < i; j++) {
                if(a[i] < a[j])
                    total++;
            }
        }
        return total;
    }

    //冒泡排序解法，最好O(n)原本有序，最差O(n^2)
    private static int bubbleWay(int a[]) {
        int total = 0;
        for (int i = 0; i < a.length - 1; i++) {
            boolean changed = false;
            for (int j = a.length - 1; j > i; j--) {
                if (a[j] < a[j - 1]) {
                    changed = true;
                    NumberUtils.swapInt(a, j - 1, j);
                    total++;
                }
            }
            if(!changed) {
                break;
            }
        }
        return total;
    }


    //归并排序解法，时间复杂度稳定在O(nlogn)，空间o(n)
    private static int mergeSortWay(int []array, int before, int end, int []temp) {
        int num = 0;
        if(before < end) {
            int middle = (before + end) / 2;
            num += mergeSortWay(array, before, middle, temp);
            num += mergeSortWay(array, middle + 1, end, temp);
            num += specialMerge(array, before, end, temp);
        }
        return num;
    }

    private static int specialMerge(int []array, int before, int end, int []temp) {
        int middle = (before + end) / 2;
        int first = before, second = middle + 1;
        int tempIndex = before;
        int num = 0;
        while (first <= middle && second <= end) {
            if(array[first] <= array[second]) {
                temp[tempIndex++] = array[first++];
            } else {
                num += (middle - first + 1);
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
        return num;
    }

    public static void main(String[] args) {
        int a[] = {1, 7, 2, 9, 6, 4, 5, 3};
        System.out.println(basic(a));
        System.out.println(bubbleWay(a));

        int b[] = {1, 7, 2, 9, 6, 4, 5, 3};
        int temp[] = {0, 0, 0, 0, 0, 0, 0, 0};
        System.out.println(mergeSortWay(b, 0, 7, temp));
    }
}
