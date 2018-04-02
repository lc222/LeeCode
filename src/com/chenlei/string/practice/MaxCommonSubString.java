package com.chenlei.string.practice;

import java.util.ArrayList;
import java.util.List;

/**
 * 14 最长公共子串
 *
 * @author chenlei
 * @since 2016 - 11 - 08 21:28
 */
public class MaxCommonSubString {

    private static void basicDynamic(String str1, String str2) {
        List<List<Integer>> array = new ArrayList<>();
        initArray(str1, str2, array);

        for(int i = 0; i < str1.length(); i++) {
            if(str1.charAt(i) == str2.charAt(0)) {
                array.get(i).set(0, 1);
            } else {
                array.get(i).set(0, 0);
            }
        }

        for(int j = 0; j < str2.length(); j++) {
            if(str1.charAt(0) == str2.charAt(j)) {
                array.get(0).set(j , 1);
            } else {
                array.get(0).set(j, 0);
            }
        }

        for (int i = 1; i < str1.length(); i++) {
            for (int j = 1; j < str2.length(); j++) {
                if (str1.charAt(i) == str2.charAt(j)) {
                    array.get(i).set(j, array.get(i-1).get(j-1) + 1);
                } else {
                    array.get(i).set(j, 0);
                }
            }
        }
        int maxRepeatLength = -1;
        int index1 = 0, index2 = 0;
        for (int i = 0; i < str1.length(); i++) {
            for (int j = 0; j < str2.length(); j++) {
                if(array.get(i).get(j) > maxRepeatLength) {
                    maxRepeatLength = array.get(i).get(j);
                    index1 = i;
                    index2 = j;
                }
            }
        }
        System.out.println(str1 + " and " + str2 + ", maxRepeatLength is " + maxRepeatLength + ", beforeIndex is " + index1 + ", afterIndex is " + index2);
    }

    private static void initArray(String str1, String str2, List<List<Integer>> array) {
        for (int i = 0; i < str1.length(); i++) {
            List<Integer> list = new ArrayList<>();
            array.add(list);
            for (int j = 0; j < str2.length(); j++) {
                list.add(0);
            }
        }
    }

    private static void basic(String str1, String str2) {
        int maxRepeatLength = -1;
        int index1 = 0, index2 = 0;
        for (int i = 0; i < str1.length(); i++) {
            for (int j = 0; j < str2.length(); j++) {
                int repeatLength = repeatLength(str1, i, str2, j);
                if (repeatLength > maxRepeatLength) {
                    maxRepeatLength = repeatLength;
                    index1 = i;
                    index2 = j;
                }
            }
        }
        System.out.println(str1 + " and " + str2 + ", maxRepeatLength is " + maxRepeatLength + ", beforeIndex is " + index1 + ", afterIndex is " + index2);
    }

    private static int repeatLength(String str1, int index1, String str2, int index2) {
        int length = 0;
        while (index1 < str1.length() && index2 < str2.length() && str1.charAt(index1) == str2.charAt(index2)) {
            length++;
            index1++;
            index2++;
        }
        return length;
    }

    public static void main(String[] args) {
        basic("wepiabc", "pabcni");
        basicDynamic("wepiabc", "pabcni");
    }
}
