package com.chenlei.array.practice;

/**
 * 4. n个整数中1出现的次数
 * @author chenlei
 * @since 2016 - 12 - 11 19:45
 */
public class OneOccurrence {

    private static int one(String sb) {
        if(sb.length() == 1) {
            if(Integer.valueOf(sb) == 0) {
                return 0;
            } else {
                return 1;
            }
        }
        Integer firstNum = sb.charAt(0) - '0';
        Integer otherNum = Integer.valueOf(sb.substring(1, sb.length()));
        int firstOneCount = 1;
        if(firstNum == 1) {
            firstOneCount = otherNum + 1;
        } else {
            for(int i = 0; i < sb.length() - 1; i++) {
                firstOneCount *= 10;
            }
        }
        StringBuilder temp = new StringBuilder();
        for(int i = 0; i < sb.length() - 1; i++) {
            temp.append(9);
        }
        return firstNum * one(temp.toString()) + one(otherNum.toString()) + firstOneCount;
    }

    public static void main(String[] args) {
        int times = one("102");
        System.out.println(times);
    }
}
