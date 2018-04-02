package com.chenlei.array.back;

import util.NumberUtils;

/**
 *  2.6.1 正负数重新排序(不改变相对顺序)
 * @author chenlei
 * @since 2017 - 03 - 04 21:39
 */
public class PosiNegaResort {

    private static void resort(int[] a) {
        int nega = 0, posi = 0;
        int negaEnd;
        while (posi < a.length && nega < a.length) {
            while(posi < a.length && a[posi] < 0) {
                posi++;
            }
            if(posi >= a.length) {
                break;
            }
            nega = posi + 1;
            while(nega < a.length && a[nega] >= 0) {
                nega++;
            }
            if(nega >= a.length) {
                break;
            }
            negaEnd = nega + 1;
            while(negaEnd < a.length && a[negaEnd] < 0) {
                negaEnd++;
            }
            NumberUtils.reverseNoChanged(a, posi, nega, negaEnd - 1);
            posi = negaEnd - (nega - posi);
        }
    }


    public static void main(String[] args) {
        int []a = {1, 7, -5, 9, -12, 15};
        resort(a);
        NumberUtils.printInArray(a);
    }
}
