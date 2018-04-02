package com.chenlei.string.practice;

import java.util.*;

/**
 *  9 并查集
 * @author chenlei
 * @since  2016 - 10 - 26 20:05
 */
public class MergeCompo {


    private static void printMerge(String[]... arrays) {
        Map<String, String> map = new HashMap<>();
        for(String[] list : arrays) {
            for(String s : list) {
                map.put(s,s);
            }
        }
        for(String[] list : arrays) {
            String targetGroup = find(map, list[0]);
            for(int i = 1; i < list.length; i++) {
                String middleGroup = find(map, list[i]);
                if(!Objects.equals(targetGroup, middleGroup)) {
                    merge(map, targetGroup, middleGroup);
                }
            }
        }

        compress(map);

        Map<String,List<String>> map1 = new HashMap<>();
        for(Map.Entry<String,String> entry : map.entrySet()) {
            String i = entry.getValue();
            if(!map1.containsKey(i)) {
                map1.put(i,new ArrayList<>());
            }
            map1.get(i).add(entry.getKey());
        }
        System.out.println(map1);
    }

    /**
     * 求key所在的组号
     */
    private static String find(Map<String, String> map, String key) {
        while(!Objects.equals(key, map.get(key))) {
            map.put(key, map.get(map.get(key)));
            key = map.get(key);
        }
        return key;
    }

    private static void compress(Map<String, String> map) {
        for(Map.Entry<String,String> entry : map.entrySet()) {
            String key = entry.getKey();
            find(map, key);
        }
    }

    private static void merge(Map<String, String> map, String targetGroup, String middleGroup) {
        map.put(middleGroup, targetGroup);
    }

    public static void main(String[] args) {
//        String[] list1 = {"aaa","bbb","ccc"};
//        String[] list2 = {"bbb","ddd"};
//        String[] list3 = {"eee","fff"};
//        String[] list4 = {"ggg"};
//        String[] list5 = {"ddd","hhh"};
        String[] list1 = {"aaa","bbb","ccc"};
        String[] list2 = {"ddd","eee"};
        String[] list3 = {"bbb","ddd"};
        String[] list4 = {"ggg"};
        printMerge(list1,list2,list3,list4);
    }

}
