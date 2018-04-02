package com.chenlei.string.back;

import java.util.ArrayList;

/**
 * 1.3.2 字符的所有组合
 * @author chenlei
 * @since 2016 - 09 - 04 21:00
 */
public class StrCombination {

    private static void combination(char a[], ArrayList<Character> list, int index) {
        if(index == a.length) {
            if(list.size() > 0) {
                System.out.println(list);
            }
            return;
        }
        combination(a, list, index + 1);
        list.add(a[index]);
        combination(a, list, index + 1);
        list.remove(list.size() -1);
    }

    private static void combinationByBit(char a[]) {
        int times = 1;
        for (char ignored : a) {
            times *= 2;
        }
        for(int printTemplate = 1; printTemplate < times; printTemplate++) {
            printCombination(a, printTemplate);
        }
    }

    private static void printCombination(char a[], int printTemplate) {
        for(int i = 0; i < a.length; i++) {
            if((printTemplate & (1 << i)) != 0) {
               System.out.print(a[a.length - i - 1]);
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        char c[] = {'a', 'b', 'c'};
        ArrayList<Character> list = new ArrayList<>();
        combination(c, list, 0);
        combinationByBit(c);
    }
}
