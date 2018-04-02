package com.chenlei.array.practice;

import java.util.ArrayList;
import java.util.List;

/**
 *  22. 最长子序列问题
 * @author chenlei
 * @since 2017 - 03 - 22 9:47
 */
public class LS {

    //最长递增子序列基本dp解法时间o(n^2)
    private static List<Integer> lisBasicDp(int a[]) {
        List<Integer> lis = new ArrayList<>();
        lis.add(1);
        for(int i = 1; i < a.length; i++) {
            int max = 1;
            for(int j = 0; j < i; j++) {
                if(a[i] > a[j]) {
                    max = max > lis.get(j) + 1 ? max : lis.get(j) + 1;
                }
            }
            lis.add(max);
        }
        return lis;
    }

    //最长递减子序列dp基本解法o(n^2)
    static List<Integer> ldsBasicDp(int a[]) {
        List<Integer> lds = new ArrayList<>();
        lds.add(1);
        for(int i = a.length - 2; i >= 0; i--) {
            int max = 1;
            for(int j = a.length - 1; j > i; j--) {
                if(a[i] > a[j]) {
                    max = max > lds.get(j - i - 1) + 1 ? max : lds.get(j - i - 1) + 1;
                }
            }
            lds.add(0, max);
        }
        return lds;
    }

    //最长递增子序列二分解法，时间O(nlogn)
    static List<Integer> lisBinary(int a[]) {
        List<Integer> lis = new ArrayList<>();
        List<Integer> tempLis = new ArrayList<>();
        lis.add(1);
        tempLis.add(a[0]);
        for(int i = 1; i < a.length; i++) {
            int index = lisBinarySearch(tempLis, a[i]);
            if(index >= tempLis.size()) {
                tempLis.add(a[i]);
            } else {
                tempLis.set(index, a[i]);
            }
            lis.add(index + 1);
        }
        return lis;
    }

    //lis的特定二分查找，找到k应该在list的位置，如果k < list(0)，返回0，如果k > list(length- 1),返回length，其他情况返回顺位
    private static int lisBinarySearch(List<Integer> list, int k) {
        int begin = 0, end = list.size() - 1;
        while(begin <= end) {
            int middle = (begin + end) / 2;
            if(list.get(middle) == k) {
                return middle;
            } else if(list.get(middle) < k) {
                begin = middle + 1;
            } else {
                end = middle - 1;
            }
        }
        if(end < 0) {
            return 0;
        } else if(begin > list.size() - 1) {
            return list.size();
        } else {
            return begin;
        }
    }

    public static void main(String[] args) {
        int a[] = {2, 1, 5, 3, 6, 4, 8, 9, 7};
        System.out.println(lisBasicDp(a));
        System.out.println(lisBinary(a));
//        int b[] = {9, 4, 3, 2, 5, 4, 3, 2};
        System.out.println(ldsBasicDp(a));
    }
}
