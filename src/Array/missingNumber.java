package Array;

import java.util.Arrays;

/**
 * Created by liuchong on 2017/4/8.
 */
public class missingNumber {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        for(int i=0; i<nums.length; i++)
        {
            if(nums[i] != i)
                return i;
        }
        return nums.length;
    }

    public int missingNumber0(int[] nums) { //binary search
        Arrays.sort(nums);
        int left = 0, right = nums.length, mid= (left + right)/2;
        while(left<right){
            mid = (left + right)/2;
            if(nums[mid]>mid) right = mid;
            else left = mid+1;
        }
        return left;
    }

    public int missingNumber1(int[] nums){
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        return nums.length*(nums.length+1)/2 - sum;
    }

    public int missingNumber2(int[] nums) {
        //a^b^b=a。所以本例中可以使用异或操作
        int xor = 0, i = 0;
        for (i = 0; i < nums.length; i++) {
            xor = xor ^ i ^ nums[i];
        }

        return xor ^ i;
    }
}
