package com.chenlei.find;

import java.util.ArrayList;
import java.util.List;

/**
 * 4. 字符串的查找(kmp)
 * @author chenlei
 * @since 2017 - 02 - 25 12:38
 */
public class StringMatch {

    //找到返回在s中起始坐标，没找到返回-1
    private static Integer matchByForce(String s, String p) {
        for(int i = 0; i <= s.length() - p.length(); i++) {
            for(int k = 0; k < p.length(); k++) {
                if(s.charAt(k+i) != p.charAt(k)) {
                    break;
                }
                if(k == p.length() - 1) {
                    return i;
                }
            }
        }
        return -1;
    }

    private static Integer kmpSearch(String s, String p) {
        List<Integer> nextArray = getNextArray(p);
        int sIndex = 0, pIndex = 0;
        while(sIndex < s.length() && pIndex < p.length()) {
            if(pIndex == -1 || s.charAt(sIndex) == p.charAt(pIndex)) {
                sIndex++;
                pIndex++;
            } else {
                pIndex = nextArray.get(pIndex);
            }
        }
        if(pIndex == p.length()) {
            return sIndex - p.length();
        } else {
            return -1;
        }
    }

    private static List<Integer> getNextArray(String str) {
        List<Integer> next = new ArrayList<>();
        if(str == null) {
            return next;
        }
        next.add(-1);
        int j = 0;
        int k = -1;
        while(j < str.length() - 1) {
            if(k == -1 || str.charAt(k) == str.charAt(j)) {
                k++;
                j++;
                next.add(k);
            } else {
                k = next.get(k);
            }
        }
        return next;
    }



    public static void main(String[] args) {
        System.out.println(matchByForce("i want get it", "get"));
        System.out.println(matchByForce("i want get it", "gea"));
        System.out.println(getNextArray("ABCDABD"));
        System.out.println(kmpSearch("i want get it", "get"));
        System.out.println(kmpSearch("BBC ABCDAB ABCDABCDABDE", "ABCDABD"));
    }
}
