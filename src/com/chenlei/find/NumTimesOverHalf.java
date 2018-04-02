package com.chenlei.find;

/**
 *  3. 出现次数超过一半的数
 * @author chenlei
 * @since 2017 - 06 - 06 8:12
 */
public class NumTimesOverHalf {

    private static int findOverHalfNum(int a[]) {
        int candidate = a[0];
        int times = 1;
        for(int i = 1; i < a.length; i++) {
            if(times == 0) {
                candidate = a[i];
                times = 1;
            } else {
                if(candidate == a[i]) {
                    times++;
                } else {
                    times--;
                }
            }
        }
        return candidate;
    }

    public static void main(String[] args) {
        int a[] = {0, 1, 2, 1, 1};
        System.out.println(findOverHalfNum(a));
    }
}
