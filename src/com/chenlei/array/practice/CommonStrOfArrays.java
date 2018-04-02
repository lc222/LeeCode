package com.chenlei.array.practice;

import java.util.LinkedList;
import java.util.List;

/**
 * 15.寻找N个数组的公共部分
 * @author chenlei
 * @since 2017 - 03 - 20 7:41
 */
public class CommonStrOfArrays {

    @SafeVarargs
    private static void findTheCommonElementsOfArrays(List<Integer>... arrays) {
        boolean stop = false;
        while (true) {
            boolean equals = true;
            Integer minNum = arrays[0].get(0);
            Integer lastNum = arrays[0].get(0);
            //找出最小的数
            for(List<Integer> list : arrays) {
                if(list.size() == 0) {
                    stop = true;
                    break;
                }
                if(!lastNum.equals(list.get(0))) {
                    equals = false;
                    if(list.get(0) < minNum) {
                        minNum = list.get(0);
                    }
                }
                lastNum = list.get(0);
            }
            if(stop) {
                break;
            }
            if(equals) {
                //输出每个list的第一个数
                System.out.println(arrays[0].get(0));
                for(List<Integer> list : arrays) {
                    list.remove(0);
                }
            } else {
                //删除等于minNum的第一个数
                for(List<Integer> list : arrays) {
                    if(list.get(0).equals(minNum)) {
                        list.remove(0);
                    }
                }
            }

        }
    }

    public static void main(String[] args) {
        List<Integer> list1 = new LinkedList<>();
        List<Integer> list2 = new LinkedList<>();
        List<Integer> list3 = new LinkedList<>();
        list1.add(1);
        list1.add(3);
        list1.add(5);
        list1.add(7);
        list1.add(9);
        list2.add(1);
        list2.add(4);
        list2.add(7);
        list2.add(8);
        list3.add(1);
        list3.add(2);
        list3.add(7);
        list3.add(9);
        System.out.println(list1);
        System.out.println(list2);
        System.out.println(list3);
        findTheCommonElementsOfArrays(list1,list2, list3);
    }
}
