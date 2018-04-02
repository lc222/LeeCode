package com.chenlei.array.back;

import util.NumberUtils;

/**
 *  2.4.4 连续子数组的最大乘积
 * @author chenlei
 * @since 2017 - 03 - 03 20:41
 */
public class MaxProductOfContinueSubArray {

    private static int maxProduct(int a[]) {
        int maxProductEver = a[0];
        int maxProductForNow = a[0], minProductForNow = a[0];
        for(int i = 1; i < a.length; i++) {
            maxProductForNow = NumberUtils.maxOfThree(a[i], maxProductForNow * a[i], minProductForNow*a[i]);
            minProductForNow = NumberUtils.minOfThree(a[i], maxProductForNow * a[i], minProductForNow*a[i]);
            if(maxProductForNow > maxProductEver) {
                maxProductEver = maxProductForNow;
            }
        }
        return maxProductEver;
    }

    public static void main(String[] args) {
        int a[] = {1, -2, 3, 10, -4, 7, 2, -5};
        System.out.println(maxProduct(a));
        int b[] = {2, 3, -2, 4};
        System.out.println(maxProduct(b));
    }
}
