package com.chenlei.string.practice;

/**
 *  五笔编码
 * @author chenlei
 * @since 2016 - 11 - 10 20:32
 */
public class FiveCode {

    private static final Integer PERCOUNT = 25;

    private static final Integer HEIGHT = 4;

    private static void index(String str) {
        int index = 0;
        int height = HEIGHT;
        for(int i = 0; i < str.length(); i++) {
            char thisChar = str.charAt(i);
            index = (thisChar - 'a') * nodeCount(height) + index + 1;
            height--;
        }
        System.out.println(index - 1);
    }

    private static void code(int index) {
        int count = index; //前面有count个元素
        int height = HEIGHT;
        while(true) {
            int number = count / nodeCount(height);
            System.out.print( (char) ('a' + number) );
            count = count - number *nodeCount(height);
            if(count == 0) {
                break;
            } else {
                count--;
            }
            height--;
        }
        System.out.println();
    }

    private static int nodeCount(int h) {
        int count = 1;
        int lastFLoor = 1;
        for(int i = 1; i < h; i++) {
            lastFLoor = lastFLoor * PERCOUNT;
            count += lastFLoor;
        }
        return count;
    }


    public static void main(String[] args) {
        index("b");
        code(16275);
    }
}
