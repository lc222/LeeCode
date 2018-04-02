package com.chenlei.string.back;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *  1.5.2 栈回文
 * @author chenlei
 * @since 2017 - 02 - 15 20:27
 */
public class StackPalindrome {

    private static boolean isStackPalindrome(Stack<Integer> obj) {
        List<Integer> list = new ArrayList<>();
        while(!obj.empty()) {
            Integer i = obj.pop();
            list.add(i);
        }
        for(int index = list.size() - 1; index >= 0; index--) {
            obj.push(list.get(index));
        }
        return ListPalindrome.isListPalindrome(list);

    }

    public static void main(String[] args) {
        Stack<Integer> obj = new Stack<>();
        obj.push(1);
        obj.push(2);
        obj.push(3);
        obj.push(4);
        obj.push(5);
        System.out.println(isStackPalindrome(obj));
        System.out.println(obj);
    }
}
