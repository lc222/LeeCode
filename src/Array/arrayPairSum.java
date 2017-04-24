package Array;

import java.util.Arrays;

/**
 * Created by liuchong on 2017/4/24.
 */
public class arrayPairSum {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for(int i=0; i<nums.length; i+=2){
            sum += nums[i];
        }
        return sum;
    }
}
