package com.chenlei.array.practice;

import java.util.Stack;

/**
 * 17. 寻找直方图中面积最大的矩形
 * @author chenlei
 * @since 2017 - 03 - 21 18:19
 */
public class FindTheMaxRectangle {

    private static void findTheMaxRectangle(int a[]) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int maxRectangle = a[0];
        for(int i = 1; i < a.length; i++) {
            if(stack.empty() || a[i] >= a[stack.peek()]) {
                stack.push(i);
            } else {
                int topIndex = stack.pop();
                maxRectangle = maxRectangle > (i - topIndex) * a[topIndex] ? maxRectangle : (i - topIndex) * a[topIndex];
                i--;
            }
        }
        System.out.println("maxRectangle is " + maxRectangle);
    }

    public static void main(String[] args) {
        int a[] = {2, 1, 5, 6, 2, 3};
        findTheMaxRectangle(a);
    }
}
