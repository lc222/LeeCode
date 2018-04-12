package Dynamic_Programming;

/**

 494. Target Sum

 You are given a list of non-negative integers, a1, a2, ..., an, and a target, S. Now you have 2 symbols + and -. For

 each integer, you should choose one from + and - as its new symbol.

 Find out how many ways to assign symbols to make sum of integers equal to target S.

 Example 1:
 Input: nums is [1, 1, 1, 1, 1], S is 3.
 Output: 5
 Explanation:

 -1+1+1+1+1 = 3
 +1-1+1+1+1 = 3
 +1+1-1+1+1 = 3
 +1+1+1-1+1 = 3
 +1+1+1+1-1 = 3

 There are 5 ways to assign symbols to make the sum of nums be target 3.
 Note:
 The length of the given array is positive and will not exceed 20.
 The sum of elements in the given array will not exceed 1000.
 Your output answer is guaranteed to be fitted in a 32-bit integer.

 */

public class Leet494_findTargetSumWays {
    //二维dp解法
    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for(int n : nums)
            sum += n;
        if(sum < S || sum < -S) return 0;
        int [][] dp = new int [nums.length][2*sum+1];
        //和为num[0]和-num[0]的元素只有1种可能
        dp[0][sum - nums[0]] += 1;
        dp[0][sum + nums[0]] += 1;
        for(int i=1; i<nums.length; i++){
            for(int j=0; j<2*sum+1; j++){
                if(j - nums[i] >= 0)
                    dp[i][j] += dp[i-1][j-nums[i]];
                if(j+nums[i] < 2*sum+1)
                    dp[i][j] += dp[i-1][j+nums[i]];
            }
        }
        return dp[nums.length-1][S+sum];
    }

    //一维DP解法
    public int findTargetSumWays1(int[] nums, int s) {
        int sum = 0;
        for(int i: nums) sum+=i;
        if(s>sum || s<-sum) return 0;
        int[] dp = new int[2*sum+1];
        dp[0+sum] = 1;
        for(int i = 0; i<nums.length; i++){
            int[] next = new int[2*sum+1];
            for(int k = 0; k<2*sum+1; k++){
                if(dp[k]!=0){
                    next[k + nums[i]] += dp[k];
                    next[k - nums[i]] += dp[k];
                }
            }
            dp = next;
        }
        return dp[sum+s];
    }


    //DFS method 很慢
    int result = 0;

    public int findTargetSumWays3(int[] nums, int S) {
        if(nums == null || nums.length == 0) return result;

        int n = nums.length;
        int[] sums = new int[n];
        sums[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--)
            sums[i] = sums[i + 1] + nums[i];

        helper(nums, sums, S, 0);
        return result;
    }
    public void helper(int[] nums, int[] sums, int target, int pos){
        if(pos == nums.length){
            if(target == 0) result++;
            return;
        }

        if (sums[pos] < Math.abs(target)) return;

        helper(nums, sums, target + nums[pos], pos + 1);
        helper(nums, sums, target - nums[pos], pos + 1);
    }

    //转化为k各元素求和的问题DP做法
    /**

     The original problem statement is equivalent to:
     Find a subset of nums that need to be positive, and the rest of them negative, such that the sum is equal to target

     Let P be the positive subset and N be the negative subset
     For example:
     Given nums = [1, 2, 3, 4, 5] and target = 3 then one possible solution is +1-2+3-4+5 = 3
     Here positive subset is P = [1, 3, 5] and negative subset is N = [2, 4]

     Then let’s see how this can be converted to a subset sum problem:

     sum(P) - sum(N) = target
     sum(P) + sum(N) + sum(P) - sum(N) = target + sum(P) + sum(N)
     2 * sum(P) = target + sum(nums)
     So the original problem has been converted to a subset sum problem as follows:
     Find a subset P of nums such that sum(P) = (target + sum(nums)) / 2

     Note that the above formula has proved that target + sum(nums) must be even

     * @param nums
     * @param s
     * @return
     */
    public int findTargetSumWays2(int[] nums, int s) {
        int sum = 0;
        for (int n : nums)
            sum += n;
        return sum < s || (s + sum) % 2 > 0 ? 0 : subsetSum(nums, (s + sum) >>> 1);
    }

    public int subsetSum(int[] nums, int s) {
        int[] dp = new int[s + 1];
        dp[0] = 1;
        for (int n : nums)
            for (int i = s; i >= n; i--)
                dp[i] += dp[i - n];
        return dp[s];
    }
}
