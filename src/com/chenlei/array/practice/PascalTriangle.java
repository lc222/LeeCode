package com.chenlei.array.practice;

import util.NumberUtils;

import java.util.ArrayList;
import java.util.List;


/**
 *  50. 杨辉三角的变形
 * @author chenlei
 * @since 2017 - 05 - 24 15:07
 */
public class PascalTriangle {

    //求前m行的杨辉三角的数据
    private static List<Integer> getTriangle(int m) {
        List<Integer> data = new ArrayList<>();
        data.add(1);
        for(int i = 2; i <= m; i++) {
            for(int j = 1; j <= (2*i - 1); j++) {
                int value = 0;
                int upColumn = j - 1;
                if(upColumn - 1 > 0) {
                    //左上有元素
                    value += getValue(data, i - 1, upColumn - 1);
                }
                if(upColumn >= 1 && upColumn <= (2*i - 3)) {
                    //上面有元素
                    value += getValue(data, i - 1, upColumn);
                }
                if(upColumn + 1<= (2*i - 3)) {
                    //右上有元素
                    value += getValue(data, i - 1, upColumn + 1);
                }
                data.add(value);
            }
        }
        return data;
    }

    private static int getValue(List<Integer> data, int row, int column) {
        return data.get( (row - 1) * (row - 1) + column - 1);
    }

    //输出第M行的第一个偶数位置，程序解法。
    private static int getEvenOfLineM(List<Integer> triangle, int m) {
        int startIndex = (m - 1) * (m - 1);
        for(int i = startIndex; i < triangle.size(); i++) {
            if(!NumberUtils.isOdd(triangle.get(i))) {
                return i - startIndex + 1;
            }
        }
        return -1;
    }

    //查找数学规律
    private static int getEvenOfLineM(int num) {
        if(num <= 2) {
            return -1;
        } else if(num % 2 == 1) {
            return 2;
        }
        if(num % 4 == 0) {
            return 3;
        }
        if(num % 4 ==2) {
            return 4;
        }
        return -1;
    }

    public static void main(String[] args) {
        List<Integer> triangle = getTriangle(4);
        System.out.println(getEvenOfLineM(triangle, 4));
        System.out.println(getEvenOfLineM(4));
    }
}
