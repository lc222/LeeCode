package Array;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by liuchong on 2017/4/20.
 */
public class removeDuplicates1 {
    public int removeDuplicates(int[] nums) {
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            if(!map.containsKey(nums[i])) {
                nums[count] = nums[i];
                map.put(nums[i], 1);
                count++;
            }else if(map.get(nums[i]) == 1) {
                nums[count] = nums[i];
                map.put(nums[i], map.get(nums[i]) + 1);
                count++;
            }
        }
        return count;
    }

    public static int removeDuplicates1(int[] nums){
        if(nums.length<=1)
            return nums.length;
        int count = 1;
        boolean flag = false;
        for(int i=1; i<nums.length; i++){
            if(nums[i] == nums[i-1] && !flag){
                nums[count] = nums[i];
                count++;
                flag = true;
            }else if(nums[i] != nums[i-1]){
                nums[count] = nums[i];
                count++;
                flag = false;
            }
        }
        return count;
    }

    public int removeDuplicates2(int[] nums) {
        int i = 0;
        for (int n : nums)
            if (i < 2 || n > nums[i-2])
                nums[i++] = n;
        return i;
    }

    public static void main(String[] args){
        int[] nums = {1,1,1,2,2,3};
        removeDuplicates1(nums);
    }
}
