package com.chenlei.array.back;

/**
 *  2.4.5 满足条件的长度最短的连续子序列
 * @author chenlei
 * @since 2017 - 03 - 04 10:28
 */
public class ShortestSubStringOfSumS {

    private static void getShortestSubString(int a[], int s) {
        int begin = 0, end = 0, sum = 0;
        int minBegin = 0, minLength = Integer.MAX_VALUE;
        while(end < a.length) {
            if(sum < s) {
                sum += a[end];
                end++;
            } else {
                if(end - begin < minLength) {
                    minBegin = begin;
                    minLength = end - begin;
                }
                sum -= a[begin];
                begin++;
            }
        }
        System.out.println("满足条件的最短序列从"+minBegin+"开始，总长度为"+minLength);
    }


    public static void main(String[] args) {
        int a[] = {1, 2, 3, 10, 5, 7, 2, 5};
        getShortestSubString(a, 15);
    }
}
