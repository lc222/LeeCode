package Array;

/**
 * Created by liuchong on 2017/3/29.
 */
public class searchInsert {
    public int searchInsert(int[] nums, int target) {
        if(target < nums[0]) return 0;
        for(int i=0; i<nums.length; i++){
            if(target <= nums[i])
                return i;
        }
        return nums.length;
    }

    public int searchInsert1(int [] nums, int target){
        int low=0, mid=0, high=nums.length-1;
        while(low<=high){
            mid = (low+high)/2;
            if(target == nums[mid])
                return mid;
            else if(target < nums[mid])
                high = mid-1;
            else
                low = mid+1;
        }
        return low;
    }
}
