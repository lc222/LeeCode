package Array;

import com.sun.deploy.util.ArrayUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liuchong on 2017/4/26.
 */
public class searchRange {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = findFirst(nums, target);
        result[1] = findLast(nums, target);
        return result;
    }

    private int findFirst(int[] nums, int target){
        int idx = -1;
        int start = 0;
        int end = nums.length - 1;
        while(start <= end){
            int mid = (start + end) / 2;
            if(nums[mid] >= target){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
            if(nums[mid] == target) idx = mid;
        }
        return idx;
    }

    private int findLast(int[] nums, int target){
        int idx = -1;
        int start = 0;
        int end = nums.length - 1;
        while(start <= end){
            int mid = (start + end) / 2;
            if(nums[mid] <= target){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
            if(nums[mid] == target) idx = mid;
        }
        return idx;
    }

    public int[] searchRange1(int[] nums, int target) {
        int [] res = {-1, -1};
        int left=0, right=nums.length-1, mid, flag=0;
        while(left <= right){
            mid = (left + right) / 2;
            if(nums[mid] > target)
                right = mid-1;
            else if(nums[mid] < target)
                left = mid+1;
            else{
                flag = 1;
                left = mid;
                while(left >=0 && nums[left] == target)
                    left--;
                right = mid;
                while(right <= nums.length-1 && nums[right] == target)
                    right++;
                break;
            }
        }
        if(flag == 1 && nums[left+1] == target){
            res[0] = left+1;
            res[1] = right-1;
        }
        return res;
    }
}
