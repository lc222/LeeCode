package Array;

/**
 * Created by liuchong on 2017/4/9.
 */
public class removeDuplicates {
    public static int removeDuplicates(int[] nums) {
        int len = nums.length > 0 ? 1 : 0;
        for(int n:nums){
            if(n > nums[len-1])
                nums[len++] = n;
        }
        return len;
    }

    public static void main(String [] args){
        int [] nums = {1,2};
        removeDuplicates(nums);
    }

}
