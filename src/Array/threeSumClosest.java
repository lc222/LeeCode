package Array;

import java.util.Arrays;

/**
 * Created by liuchong on 2017/5/23.
 */
public class threeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int diff = Integer.MAX_VALUE, closest = 0;
        for (int k=0; k<nums.length-2; ++k) {
            for (int i=k+1, j=nums.length-1; i<j; ) {
                int sum = nums[k] + nums[i] + nums[j];
                if (sum == target) { return target; }
                else if (sum > target) {
                    if (sum-target < diff) {
                        diff = sum-target;
                        closest = sum;
                    }
                    --j;
                } else {
                    if (target-sum < diff) {
                        diff = target-sum;
                        closest = sum;
                    }
                    ++i;
                }
            }
        }
        return closest;
    }
}
