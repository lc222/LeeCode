package Array;

/**
 * Created by liuchong on 2017/5/21.
 */
public class findPeakElement {
    public int findPeakElement(int[] nums) {
        if(nums.length <=1 || nums[0] > nums[1])
            return 0;
        for(int i=1; i<nums.length-1; i++){
            if(nums[i] > nums[i+1])
                return i;
        }
        return nums.length-1;
    }

    public int findPeakElement1(int[] nums) {
        int n = nums.length;
        int lo = 0, hi = n - 1;
        while(lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if(nums[mid] < nums[mid+1]) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }
}
