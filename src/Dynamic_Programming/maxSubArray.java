package Dynamic_Programming;


/**

 53. Maximum Subarray

 Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

 For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
 the contiguous subarray [4,-1,2,1] has the largest sum = 6.

 click to show more practice.

 More practice:
 If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.

 */

public class maxSubArray {

    /**
     Base case: 1 element, return nums[0]

     Other cases:

     If dp[i-1] < 0, dp[i] = nums[i]

     if dp[i-1] >0, dp[i] = nums[i] + dp[i-1]

     then pick the max sum.

     We only need dp[i-1], so i use prev to record it, the space complexity is reduced to O(1).
     */
    public int maxSubArray(int[] A) {
        int dp[] = new int[A.length]; int max = A[0]; dp[0] = A[0];
        for (int i = 1; i < A.length; i++) {
            dp[i] = Math.max(dp[i-1] + A[i] ,A[i]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public int maxSubArray1(int[] A) {
        int res = Integer.MIN_VALUE, sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum = Math.max(sum, 0) + A[i];
            res = Math.max(res, sum);
        }
        return res;
    }

    public int maxSubArray2(int[] A) {
        if (A == null || A.length == 0) return 0;
        int max = A[0], minSum = Integer.MAX_VALUE;
        int sum[] = new int[A.length];
        sum[0] = A[0];
        for (int i = 1; i < A.length; i++) {
            sum[i] = sum[i-1] + A[i];
            minSum = Math.min(0, Math.min(minSum, sum[i-1]));
            max = Math.max(max, sum[i] - minSum);
        }
        return max;
    }

}
