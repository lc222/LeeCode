package BinarySearch;

/**
 * Created by liuchong on 2017/7/18.
 */
public class searchInsert {

    public int searchInsert(int[] nums, int target) {
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

    public int searchInsert1(int[] nums, int target) {
        int low = 0, high = nums.length;
        while(low < high) {
            int mid = low + (high - low) / 2;
            if(nums[mid] < target)
                low = mid + 1;
            else
                high = mid;
        }
        return low;
    }
}
