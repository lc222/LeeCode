package Array;

/**
 * Created by liuchong on 2017/4/20.
 */
public class search2 {
    public boolean search(int[] nums, int target) {
        int left=0, right=nums.length-1, mid;

        while(left <= right){
            mid = (left+right)/2;
            if(nums[mid] == target)
                return true;

            if(nums[mid] < nums[left] || nums[mid] < nums[right]){
                if(target > nums[mid] && target <= nums[right])
                    left = mid+1;
                else
                    right = mid -1;
            }else if(nums[mid] > nums[left] || nums[mid] > nums[right]){
                if(target < nums[mid] && target >= nums[left])
                    right = mid-1;
                else
                    left = mid + 1;
            }else
                right--;

        }
        return false;
    }
}
