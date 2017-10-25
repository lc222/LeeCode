package BinarySearch;

/**
 * Created by liuchong on 2017/10/17.

 410. Split Array Largest Sum

 Given an array which consists of non-negative integers and an integer m, you can split the array into m non-empty continuous subarrays. Write an algorithm to minimize the largest sum among these m subarrays.

 Note:
 If n is the length of array, assume the following constraints are satisfied:

 1 ≤ n ≤ 1000
 1 ≤ m ≤ min(50, n)
 Examples:

 Input:
 nums = [7,2,5,10,8]
 m = 2

 Output:
 18

 Explanation:
 There are four ways to split nums into two subarrays.
 The best way is to split it into [7,2,5] and [10,8],
 where the largest sum among the two subarrays is only 18.

 */
public class splitArray {
    public int splitArray(int[] nums, int m) {
        int max = 0; long sum = 0;
        for (int num : nums) {
            max = Math.max(num, max);
            sum += num;
        }
        if (m == 1) return (int)sum;
        //binary search
        long l = max; long r = sum;
        while (l <= r) {
            long mid = (l + r)/ 2;
            if (valid(mid, nums, m)) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return (int)l;
    }
    public boolean valid(long target, int[] nums, int m) {
        int count = 1;
        long total = 0;
        for(int num : nums) {
            total += num;
            if (total > target) {
                total = num;
                count++;
                if (count > m) {
                    return false;
                }
            }
        }
        return true;
    }

    public int splitArray1(int[] nums, int m)
    {
        int L = nums.length;
        int[] S = new int[L+1];
        S[0]=0;
        for(int i=0; i<L; i++)
            S[i+1] = S[i]+nums[i];

        int[] dp = new int[L];
        for(int i=0; i<L; i++)
            dp[i] = S[L]-S[i];

        for(int s=1; s<m; s++)
        {
            for(int i=0; i<L-s; i++)
            {
                dp[i]=Integer.MAX_VALUE;
                for(int j=i+1; j<=L-s; j++)
                {
                    int t = Math.max(dp[j], S[j]-S[i]);
                    if(t<=dp[i])
                        dp[i]=t;
                    else
                        break;
                }
            }
        }

        return dp[0];
    }
}
