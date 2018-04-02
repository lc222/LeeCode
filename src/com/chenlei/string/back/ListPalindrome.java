package com.chenlei.string.back;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

/**
 *  1.5.1 链表回文
 * @author chenlei
 * @since 2017 - 02 - 15 20:18
 */
public class ListPalindrome {

    static boolean isListPalindrome(List<Integer> list) {
        Stack<Integer> stack = new Stack<>();
        stack.addAll(list);
        for(Integer i : list) {
            Integer reverse = stack.pop();
            if(!Objects.equals(i, reverse)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(2);
        list.add(1);
        System.out.println(isListPalindrome(list));
    }
}
