package com.chenlei.string.back;

import java.util.ArrayList;

/**
 *  1.3.3 序列的打印
 * @author chenlei
 * @since  2016 - 10 - 23 21:15
 */
public class PrintCombination {

    //包含组合去重
    private static void printCombination(char a[], ArrayList<Character> list, int index, int leftPositions) {
        if(leftPositions == 0) {
            System.out.println(list);
            return;
        }
        if(index >= a.length) {
            return;
        }
        list.add(a[index]);
        printCombination(a,list,index+1,leftPositions - 1);
        list.remove(list.size() - 1);
        while((index + 1) <a.length && a[index] ==a[index + 1]) {
            index++;
        }
        printCombination(a,list,index+1,leftPositions);
    }

    //不用return的写法
    private static void printCombination2(char a[], ArrayList<Character> list, int index, int leftPositions) {
        list.add(a[index]);
        if(leftPositions - 1 == 0) {
            System.out.println(list);
        } else if(index + 1 < a.length) {
            printCombination(a, list, index + 1, leftPositions - 1);
        }
        list.remove(list.size() - 1);
        if(index + 1 < a.length) {
            printCombination(a, list, index + 1, leftPositions);
        }
    }

    public static void main(String[] args) {
        char a[] = {'a', 'b', 'c' };
        ArrayList<Character> list = new ArrayList<>();
        for(int i = 1; i <= a.length; i++) {
            printCombination(a, list, 0, i);
        }
    }
}
