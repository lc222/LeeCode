package com.chenlei.find;

/**
 *  有序旋转数组的查找
 * @author chenlei
 * @since 2017 - 06 - 05 15:47
 */
public class FindInRotateArray {

    //找到返回下标，找不到返回-1
    private static int find(int []a, int begin, int end, int target) {
        int before = begin, after = end;
        while (before <= after) {
            int middle = (before + after) / 2;
            if(a[middle] == target) {
                return middle;
            }
            if(a[before] < a[middle]) {
                //前半段为升序
                if(target >= a[before] && target < a[middle]) {
                    after = middle - 1;
                } else {
                    before = middle + 1;
                }
            } else if(a[before] > a[middle]) {
                //后半段为升序
                if(target > a[middle] && target <= a[after]) {
                    before = middle + 1;
                } else {
                    after = middle - 1;
                }
            } else {
                //a[before == a[middle]
                if(a[middle] == a[after]) {
                    //先找前半段
                    int index = find(a, begin, middle - 1, target);
                    if(index != -1) {
                        return index;
                    } else {
                        //再找后半段
                        return find(a, middle + 1, after, target);
                    }
                } else {
                    //前半段都为a[middle]
                    before = middle + 1;
                }
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int a[] = {15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14};
        System.out.println(find(a, 0, a.length - 1, 9));
        int b[] = {8, 9, 1, 2, 3, 4, 5};
        System.out.println(find(b, 0, b.length - 1, 7));
        int c[] = {1, 0, 1, 1, 1, 1};
        System.out.println(find(c, 0, c.length - 1, 0));
    }
}
