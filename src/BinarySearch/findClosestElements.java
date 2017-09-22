package BinarySearch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*

题目：

Given a sorted array, two integers k and x, find the k closest elements to x in the array. The result should also be sorted in ascending order. If there is a tie, the smaller elements are always preferred.

Example 1:
Input: [1,2,3,4,5], k=4, x=3
Output: [1,2,3,4]
Example 2:
Input: [1,2,3,4,5], k=4, x=-1
Output: [1,2,3,4]
Note:
The value k is positive and will always be smaller than the length of the sorted array.
Length of the given array is positive and will not exceed 104
Absolute value of elements in the array and x will not exceed 104

 */


public class findClosestElements {
    public List<Integer> findClosestElements(List<Integer> arr, int k, int x) {
        int index = Collections.binarySearch(arr, x);
        if(index < 0) index = -(index + 1);
        int i = index - 1, j = index;
        while(k-- > 0){
            if(i<0 || (j<arr.size() && Math.abs(arr.get(i) - x) > Math.abs(arr.get(j) - x) ))j++;
            else i--;
        }
        return arr.subList(i+1, j);
    }


    public List<Integer> findClosestElements1(List<Integer> arr, int k, int x) {
        Collections.sort(arr, (a,b) -> a == b ? a - b : Math.abs(a-x) - Math.abs(b-x));
        arr = arr.subList(0, k);
        Collections.sort(arr);
        return arr;
    }

    public List<Integer> findClosestElements2(List<Integer> arr, int k, int x) {
        int lo = 0, hi = arr.size() - k;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (x - arr.get(mid) > arr.get(mid+k) - x)
                lo = mid + 1;
            else
                hi = mid;
        }
        return arr.subList(lo, lo + k);
    }

}
