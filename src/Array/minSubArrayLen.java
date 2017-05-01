package Array;

/**
 * Created by liuchong on 2017/4/29.
 */
public class minSubArrayLen {
    public int minSubArrayLen(int s, int[] nums) {

        int left=0, sum=0, min = Integer.MAX_VALUE;

        for(int i=0; i<nums.length; i++){
            sum += nums[i];
            while(sum >= s) {
                min = Math.min(min, i - left + 1);
                sum -= nums[left++];
            }
        }
        if(min == Integer.MAX_VALUE)
            return 0;
        return min ;
    }


}
