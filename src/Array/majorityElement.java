package Array;

import java.util.Arrays;

/**
 * Created by liuchong on 2017/4/10.
 */
public class majorityElement {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        for(int i=0; i<nums.length; i++){
            if(nums[i] == nums[i+nums.length/2])
                return nums[i];
        }
        return 0;
    }

    public int majorityElement1(int[] num) {

        int major=num[0], count = 1;
        for(int i=1; i<num.length;i++){
            if(count==0){
                count++;
                major=num[i];
            }else if(major==num[i]){
                count++;
            }else count--;

        }
        return major;
    }
}
