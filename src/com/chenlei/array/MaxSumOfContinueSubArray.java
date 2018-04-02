package com.chenlei.array;

/**
 *  2.4 最大连续子数组的和
 * @author chenlei
 * @since 2016 - 11 - 21 20:01
 */
public class MaxSumOfContinueSubArray {

    public static Integer maxSum(int array[]) {
        Integer lastSum = array[0];
        Integer maxSum = array[0];

        for(int i = 1; i < array.length; i++) {
            if(lastSum > 0) {
                lastSum = lastSum + array[i];
            } else {
                lastSum = array[i];
            }
            if(lastSum > maxSum) {
                maxSum = lastSum;
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int array[] = {1, -2, 3, 10, -4, 7, 2, -5};
        System.out.println(maxSum(array));
    }
}
