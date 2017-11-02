package BinarySearch;

/*

719. Find K-th Smallest Pair Distance

Given an integer array, return the k-th smallest distance among all the pairs. The distance of a pair (A, B) is defined as the absolute difference between A and B.

Example 1:
Input:
nums = [1,3,1]
k = 1
Output: 0

Explanation:
Here are all the pairs:
(1,3) -> 2
(1,1) -> 0
(3,1) -> 2
Then the 1st smallest distance pair is (1,1), and its distance is 0.

Note:
2 <= len(nums) <= 10000.
0 <= nums[i] < 1000000.
1 <= k <= len(nums) * (len(nums) - 1) / 2.

 */

import java.util.Arrays;

public class smallestDistancePair {

    //TLE
    public int smallestDistancePair(int[] nums, int k) {
        int [] res = new int[k];
        int count = 0, dis;
        for(int i=0; i<nums.length; i++){
            for(int j=i+1; j<nums.length; j++){
                dis = Math.abs(nums[j] - nums[i]);
                if(count < k)
                    res[count] = dis;
                else if(count == k) {
                    Arrays.sort(res);
                    help(res, dis);
                }
                else
                    help(res, dis);
                count++;
            }
        }
        return res[k-1];
    }

    public void help(int [] nums, int num){
        if(num < nums[nums.length-1]){
            for(int i=nums.length-2; i>=0; i--){
                if(num < nums[i])
                    nums[i+1] = nums[i];
                else{
                    nums[i+1] = num;
                    break;
                }
            }
            if(num < nums[0])
                nums[0] = num;
        }
    }

    //TLE
    public int smallestDistancePair1(int[] nums, int k) {
        int [] res = new int[nums.length*(nums.length-1)/2];
        int count = 0;
        for(int i=0; i<nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                res[count++] = Math.abs(nums[j] - nums[i]);
            }
        }
        Arrays.sort(res);
        return res[k-1];
    }

    public static int smallestDistancePair2(int[] nums, int k) {
        Arrays.sort(nums);
        int low = nums[1] - nums[0], high = nums[nums.length-1] - nums[0], mid;
        for(int i=1; i<nums.length - 1; i++)
            low = Math.min(low, nums[i+1] - nums[i]);

        while(low < high){
            mid = (low + high)/2;
            if(count(nums, mid) < k)
                low = mid + 1;
            else
                high = mid;
        }
        return low;
    }

    public static int count(int[] nums, int k){
        int res = 0;
        for(int i=0; i<nums.length; i++){
            int j = i+1;
            while(j<nums.length && nums[j] - nums[i] <= k) j++;
            res += j-i-1;
        }
        return res;
    }

    public int smallestDistancePair3(int[] nums, int k) {
        int len=nums.length;
        int len2=1000000;
        int[] dp= new int[len2];
        for(int i=1;i<len;i++){
            for(int j=0;j<i;j++){
                int dif= Math.abs(nums[i]-nums[j]);
                dp[dif]++;
            }
        }
        int sum=0;
        for(int i=0;i<len2;i++){
            sum+=dp[i];
            if(sum>=k) return i;
        }
        return 0;
    }

    public static void main(String[] args){
        int [] nums = {1,3,1};
        smallestDistancePair2(nums, 1);
    }
}
