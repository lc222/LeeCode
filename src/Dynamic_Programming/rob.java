package Dynamic_Programming;

/**

 198. House Robber

 You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed,

 the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and

 it will automatically contact the police if two adjacent houses were broken into on the same night.

 Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of

 money you can rob tonight without alerting the police.

 */

public class rob {

    public int rob(int[] nums) {
        if(nums.length==0) return 0;
        if(nums.length==1) return nums[0];
        int [] res = new int[nums.length];
        res[0] = nums[0];
        res[1] = Math.max(nums[0], nums[1]);
        for(int i=2; i<nums.length; i++){
            res[i] = Math.max(res[i-2] + nums[i], res[i-1]);
        }
        return res[nums.length-1];
    }

    public int rob1(int[] num) {
        int prevNo = 0;
        int prevYes = 0;
        for (int n : num) {
            int temp = prevNo;
            prevNo = Math.max(prevNo, prevYes);
            prevYes = n + temp;
        }
        return Math.max(prevNo, prevYes);
    }

    public int rob2(int[] num) {
        int[][] dp = new int[num.length + 1][2];
        for (int i = 1; i <= num.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = num[i - 1] + dp[i - 1][0];
        }
        return Math.max(dp[num.length][0], dp[num.length][1]);
    }
}
