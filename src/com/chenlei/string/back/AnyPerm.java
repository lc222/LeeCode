package com.chenlei.string.back;

import java.util.Arrays;

/**
 *  1.3.1 字典序的所有排列
 * @author chenlei
 * @since  2016 - 09 - 04 20:27
 */
public class AnyPerm {

    private static void anyPerm(char a[], char temp[]) {
        Arrays.sort(a);
        perm(temp, a, 0);
    }

    private static void perm(char current[], char inOrder[], int index) {
        if(index > inOrder.length - 1) {
            System.out.println(current);
            return;
        }
        for (char anInOrder : inOrder) {
            current[index] = anInOrder;
            perm(current, inOrder, index + 1);
        }
    }

    public static void main(String[] args) {
        char c[] = {'a','b','c'};
        char temp[] = new char[3];
        anyPerm(c, temp);
    }
}
