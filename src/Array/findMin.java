package Array;

/**
 * Created by liuchong on 2017/5/21.
 */
public class findMin {
    public int findMin(int[] nums) {
        for(int i=0; i<nums.length-1; i++){
            if(nums[i] > nums[i+1])
                return nums[i+1];
        }
        return nums[0];
    }

    public  int findMin1(int[] nums){
        int left=0, right=nums.length-1, mid;
        while(left < right){
            mid = (left + right)/2;
            if(nums[mid] > nums[right]) {
                if(mid < nums.length-1 && nums[mid] > nums[mid+1])
                    return nums[mid+1];
                left = mid+1;
            }
            else{
                if(mid >0 && nums[mid] < nums[mid-1])
                    return nums[mid];
                right = mid-1;
            }
        }
        return nums[0];
    }

    public int findMin2(int[] nums) {
        int start = 0, end = nums.length - 1, mid;
        while (start  <  end) {
            mid = (start + end) / 2;
            if (nums[mid]  > nums[end])
                start = mid + 1;
            else
                end = mid;
        }
        return nums[start];
    }
}
