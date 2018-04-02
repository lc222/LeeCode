package com.chenlei.array.practice;

import java.util.ArrayList;
import java.util.List;

/**
 *  34. 相邻数的差
 * @author chenlei
 * @since 2017 - 05 - 20 16:43
 */
public class MaxReduceOfCloseNum {

    /**
     * 桶方法
     */
    private static double maxReduce(double[] a) {
        List<Bucket> buckets =  initBuckets(a);
        Double max = Double.MIN_VALUE, min = Double.MAX_VALUE;
        for(double num : a) {
            if(num > max) {
                max = num;
            }
            if(num < min) {
                min = num;
            }
        }

        for(double num : a) {
            int bucketIndex = getBucketIndex(a, min, max, num);
            Bucket bucket = buckets.get(bucketIndex);
            if(bucket.max == null || bucket.min == null) {
                bucket.max = num;
                bucket.min = num;
            } else if(num > bucket.max) {
                bucket.max = num;
            } else if(num < bucket.min) {
                bucket.min = num;
            }
        }

        double lastNum = buckets.get(0).max;
        double maxDistance = Double.MIN_VALUE;
        for(int i = 1; i < buckets.size(); i++) {
            Bucket bucket = buckets.get(i);
            if(bucket.min != null) {
                if((bucket.min - lastNum) > maxDistance) {
                    maxDistance = bucket.min - lastNum;
                }
                lastNum = bucket.max;
            }
        }
        return maxDistance;
    }

    public static void main(String[] args) {
//        double a[] = {3, 4.3, 5.7, 7};
        double[] a = {3, 1, 2, 4, 9, 8 ,7};
        System.out.println(maxReduce(a));
    }

    /**
     * 求num应该在
     */
    private static int getBucketIndex(double[] a, double min, double max, double num) {
        double instance =  (num - min) / (max - min) * a.length;
        return (int) instance;
    }

    private static List<Bucket> initBuckets(double[] a) {
        List<Bucket> buckets = new ArrayList<>();
        for (double ignored : a) {
            buckets.add(new Bucket());
        }
        buckets.add(new Bucket());
        return buckets;
    }


    private static class Bucket {
        Double min;
        Double max;
    }
}
