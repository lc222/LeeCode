package com.chenlei.array.practice;

import java.util.List;

/**
 * 20. 双端LIS
 * @author chenlei
 * @since 2017 - 03 - 22 17:12
 */
public class DoubleLS {

    private static int getMinDelete(int a[]) {
        List<Integer> nega = LS.lisBinary(a);
        List<Integer> posi = LS.ldsBasicDp(a);
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < a.length; i++) {
            int iLength = nega.get(i) + posi.get(i) - 1;
            max = max > iLength ? max : iLength;
        }
        return max;
    }

    public static void main(String[] args) {
        int a[] = {2, 1, 5, 3, 6, 4, 8, 9, 7};
        System.out.println(getMinDelete(a));
    }
}
