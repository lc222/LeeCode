package com.chenlei.tree;

/**
 *  3. 判断某个序列是否是二叉查找树的后序遍历结果
 * @author chenlei
 * @since 2017 - 05 - 31 16:36
 */
public class IsPostOrder {

    private static boolean isPostOrder(int a[], int begin ,int end) {
        if(begin >= end) {
            //只有一个元素
            return true;
        }

        //最后一个数为根节点
        int root = a[end];
        for(int i = begin; i <= end; i++) {
            //假设以i划分左右子数
            int leftMax = maxInArray(a, begin, i);
            int rightMin = minInArray(a, i, end);
            if(root >= leftMax && root <= rightMin) {
                //满足后序要求，进行下一步左右子树检查
                boolean result = isPostOrder(a, begin, i - 1) && isPostOrder(a, i, end - 1);
                if(result)
                    return true;
            }
        }
        return false;
    }

    //区间[begin, end)
    private static int maxInArray(int a[], int begin, int end) {
        if(begin >= end)
            return Integer.MIN_VALUE;
        int maxValue = Integer.MIN_VALUE;
        for(int i = begin; i < end; i++) {
            if(a[i] > maxValue) {
                maxValue = a[i];
            }
        }
        return maxValue;
    }

    //区间[begin, end)
    private static int minInArray(int a[], int begin, int end) {
        if(begin >= end)
            return Integer.MAX_VALUE;
        int minValue = Integer.MAX_VALUE;
        for(int i = begin; i < end; i++) {
            if(a[i] < minValue) {
                minValue = a[i];
            }
        }
        return minValue;
    }

    public static void main(String[] args) {
        int a[] = {5, 7, 6, 9, 11, 10, 8};
        System.out.println(isPostOrder(a, 0, a.length - 1));
        int b[] = {7, 4, 6, 5};
        System.out.println(isPostOrder(b, 0, b.length - 1));
    }

}
