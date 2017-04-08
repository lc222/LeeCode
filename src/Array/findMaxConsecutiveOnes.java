package Array;

/**
 * Created by liuchong on 2017/4/8.
 */
public class findMaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int left = 0, max = 0, i=0;
        for(i=0; i<nums.length; i++){
            if(nums[i] == 0) {
                max = Math.max(i - left, max);
                left = i+1;
            }
        }
        return Math.max(max, i-left);
    }

    public int findMaxConsecutiveOnes1(int[] nums) {
        int maxSum = 0, sum = 0;
        for (int n : nums) {
            sum *= n;
            sum += n;
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }
}
