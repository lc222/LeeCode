package Array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by liuchong on 2017/6/17.
 */
public class longestConsecutive {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0 || nums == null)
            return 0;
        if(nums.length == 1)
            return 1;
        Arrays.sort(nums);
        int max = 0, tmp = 1;
        for(int i=0; i<nums.length-1; i++){
            if (nums[i] == nums[i+1] - 1 || nums[i] == nums[i+1]){
                if (nums[i] == nums[i+1] - 1)
                    tmp ++;
            }else{
                max = Math.max(max, tmp);
                tmp = 1;
            }
        }
        return Math.max(max, tmp);
    }

    public int longestConsecutive1(int[] nums) {

        Set<Integer> set = new HashSet<>();

        for(int n: nums) set.add(n);

        int max = 0;

        for(int n: nums){
            int count = 0;
            if(set.isEmpty()) break;

            int val = n;
            while(set.remove(val--))
                count ++;

            val = n;
            while(set.remove(++val))
                count ++;

            max = Math.max(count,max);
        }

        return max;

    }
}
