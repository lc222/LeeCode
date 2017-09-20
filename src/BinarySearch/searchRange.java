package BinarySearch;

/*
题目：

Given an array of integers sorted in ascending order, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

For example,
Given [5, 7, 7, 8, 8, 10] and target value 8,
return [3, 4].

 */

public class searchRange {
    public int[] searchRange(int[] nums, int target) {
        int left=0, right=nums.length-1, mid;
        while(left <= right){
            mid = (left + right)/2;
            if(nums[mid] < target)
                left = mid + 1;
            else if(nums[mid] > target)
                right = mid - 1;
            else{
                int [] res = new int[2];
                int a=mid, b=mid;
                while(a >= 0 && nums[a] == target)
                    a -= 1;
                res[0] = Math.max(0, a+1);
                while(b <= nums.length-1 && nums[b] == target)
                    b += 1;
                res[1] = Math.min(nums.length-1, b-1);
                return res;
            }
        }
        int [] res = {-1 ,-1};
        return res;
    }
}
