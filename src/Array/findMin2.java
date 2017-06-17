package Array;

/**
 * Created by liuchong on 2017/6/15.
 */
public class findMin2 {
    public int findMin(int[] nums) {
        for(int i=0; i<nums.length-1; i++){
            if(nums[i] > nums[i+1])
                return nums[i+1];
        }
        return nums[0];
    }

    public int findMin1(int[] nums){
        int left=0, right=nums.length, mid;
        while(left < right){
            mid = (left + right)/2;
            if(nums[mid] >= nums[left]){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        return 1;
    }
}
