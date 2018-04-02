package com.chenlei.array.back;

import com.chenlei.array.MaxSumOfContinueSubArray;

/**
 *  2.4.6 最大子矩阵和
 * @author chenlei
 * @since 2017 - 03 - 04 10:55
 */
public class MaxSumOfSubMatrix {

    //O(n^3)
    private static int maxSum(int a[][],int b[]) {
        int maxValue = 0;
        for(int i = 0; i < a.length; i++) {
            init(b);
            for(int j = i; j < a.length; j++) {
                add(a[j], b);
                int currentMax = MaxSumOfContinueSubArray.maxSum(b);
                if(currentMax > maxValue) {
                    maxValue = currentMax;
                }
            }
        }
        return maxValue;
    }

    private static void init(int b[]) {
        for(int i = 0; i < b.length; i++) {
            b[i] = 0;
        }
    }

    private static void add(int a[], int b[]) {
        for(int i = 0; i < a.length; i++) {
            b[i] = a[i] + b[i];
        }
    }

    public static void main(String[] args) {
        int a[][] = {
                {0, -2, -7, 0},
                {9, 2, -6, 2},
                {-4, 1, -4, 1},
                {-1, 8, 0, -2}
        };
        int b[] = {0, 0, 0, 0};
        System.out.println(maxSum(a, b));
    }
}
