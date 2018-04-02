package com.chenlei.array.back;

import util.NumberUtils;

/**
 *  2.9.1 完美洗牌逆运算
 * @author chenlei
 * @since 2017 - 03 - 07 21:31
 */
public class PerfectShuffleReverse {

    //逆走环算法
    private static void doReverseCircle(int a[], int k, int begin, int n) {
        int index = begin, num = a[k + begin - 1];
        int nextIndex;
        do {
            if(index % 2 == 0) {
                //是偶数
                nextIndex = index / 2;
            } else {
                //奇数
                nextIndex = index - index / 2 + n;
            }
            int temp = num;
            num = a[k + nextIndex - 1];
            a[k + nextIndex - 1] = temp;
            index = nextIndex;
        } while(nextIndex != begin);
    }

    //完美洗牌
    private static void perfectShuffleReverse(int a[]) {
        int reserveLength = a.length;
        int rangeIndex = 0;
        while (reserveLength > 0) {
            int k  = 1;
            while((NumberUtils.ciFang(3, k) - 1) <= reserveLength) {
                k++;
            }
            k--;
            int n = (NumberUtils.ciFang(3, k) - 1) / 2;
            for(int i = 0; i < k; i++) {
                doReverseCircle(a, rangeIndex, NumberUtils.ciFang(3, i), n);
            }
            NumberUtils.reverseNoChanged(a, rangeIndex / 2, rangeIndex, rangeIndex + n  - 1);
            reserveLength -= 2*n;
            rangeIndex += 2*n;
        }
    }

    public static void main(String[] args) {
        int a[] = {6, 1, 7, 2, 8, 3, 9, 4, 10, 5};
        perfectShuffleReverse(a);
        NumberUtils.printInArray(a);
    }
}
