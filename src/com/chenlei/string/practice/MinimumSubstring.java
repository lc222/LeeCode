package com.chenlei.string.practice;

import java.util.HashMap;
import java.util.Map;

/**
 * 11 最小覆盖子串
 * @author chenlei
 * @since 2016 - 11 - 06 11:16
 */
public class MinimumSubstring {

    private static void minimumSubstring(String []source, String []target) {
        Map<String, Integer> targetMap =  initTargetMap(target);
        Map<String, Integer> sourceMap = initSourceMap(source);
        int before = 0, after = -1;
        int found = 0;
        int minStart = 0, minEnd = 0, minLength = Integer.MAX_VALUE;
        while(true) {
            if(found == target.length) {
                int nowLength = after - before + 1;
                if(nowLength < minLength) {
                    minLength = nowLength;
                    minStart = before;
                    minEnd = after;
                }
                if(targetMap.containsKey(source[before])) {
                    sourceMap.put(source[before], sourceMap.get(source[before]) - 1);
                    if (sourceMap.get(source[before]) < targetMap.get(source[before])) {
                        found--;
                    }
                }
                before++;
            } else {
                after++;
                if(after < source.length) {
                    if(targetMap.containsKey(source[after])) {
                        if (sourceMap.get(source[after]) < targetMap.get(source[after])) {
                            found++;
                        }
                        sourceMap.put(source[after], sourceMap.get(source[after]) + 1);
                    }
                } else {
                    break;
                }
            }
        }
        System.out.println("min length = " + minLength + ", minStart = " + minStart + ", minEnd = " + minEnd );
    }

    private static Map<String, Integer> initTargetMap(String []strs) {
        Map<String, Integer> map = new HashMap<>();
        for(String s : strs) {
            map.put(s,map.containsKey(s) ? map.get(s)+1 : 1);
        }
        return map;
    }

    private static Map<String, Integer> initSourceMap(String []source) {
        Map<String, Integer> map = new HashMap<>();
        for(String s : source) {
            map.put(s, 0);
        }
        return map;
    }

    public static void main(String[] args) {
        String[] source = {"hello","hi","world","how","good","world","you","hello"};
        String[] target = {"hello","world","good"};
        minimumSubstring(source,target);
    }
}
