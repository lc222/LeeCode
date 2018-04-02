package com.chenlei.string.back;

import com.chenlei.string.MaxPalindrome;
import util.StringUtils;
import util.tuple.Tuple;
import util.tuple.Tuple2;

import java.util.ArrayList;
import java.util.List;

/**
 *  1.6.1 输出最长回文子串
 * @author chenlei
 * @since 2017 - 02 - 19 10:30
 */
public class PrintMaxPalindrome {

    private static Tuple2<Integer, Integer> getMaxPalidrome(String str) {
        List<Integer> values = new ArrayList<>();
        String buildStr = MaxPalindrome.buildStr(str);
        MaxPalindrome.buildManacher(buildStr, values);
        int maxLength = 0, maxIndex = 0;
        for(int i = 0; i < values.size(); i++) {
            if(values.get(i) > maxLength) {
                maxIndex = i;
                maxLength = values.get(i);
            }
        }
        maxLength = maxLength - 1;
        int firstIndex, secondIndex;
        if(buildStr.charAt(maxIndex) == '#') {
            firstIndex = maxIndex / 2 - 1 - (maxLength / 2 - 1);
            secondIndex = maxIndex / 2 + (maxLength / 2 - 1);
        } else {
            firstIndex = maxIndex / 2  - maxLength / 2;
            secondIndex = maxIndex / 2 + maxLength / 2;
        }
        return Tuple.of(firstIndex, secondIndex);
    }

    private static void printMaxPalindrome(String str) {
        if(StringUtils.isBlank(str)) {
            return;
        }
        Tuple2<Integer, Integer> maxPalindromeIndex = getMaxPalidrome(str);
        Integer firstIndex = maxPalindromeIndex._1().orElse(null);
        Integer secondIndex = maxPalindromeIndex._2().orElse(null);
        System.out.println(str.substring(firstIndex, secondIndex + 1));
        if(firstIndex > 0) {
            printMaxPalindrome(str.substring(0, firstIndex));
        }
        if(secondIndex < str.length() - 1) {
            printMaxPalindrome(str.substring(secondIndex + 1));
        }
    }

    public static void main(String[] args) {
        printMaxPalindrome("habbafgh");
    }
}
