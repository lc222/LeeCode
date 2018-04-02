package com.chenlei.array.practice;

/**
 *  12 寻找和为定值的连续序列
 * @author chenlei
 * @since 2017 - 03 - 12 11:15
 */
public class FindContinueSeqSumOfTarget {

    private static void findContinueSeqSumOfTarget(int n) {
        int before = 1, after = 2;
        int nowValue = 1 + 2;
        while (before < after && after <= (n / 2 + 1)) {
            if(nowValue == n) {
                print(before, after);
                nowValue -= before++;
                nowValue += ++after;
            } else if(nowValue < n) {
                nowValue += ++after;
            } else {
                nowValue -= before++;
            }
        }
    }

    private static void print(int begin, int end) {
        for(int i = begin; i <= end; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        findContinueSeqSumOfTarget(15);
    }
}
