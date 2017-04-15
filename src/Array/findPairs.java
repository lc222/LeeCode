package Array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by liuchong on 2017/4/15.
 */
public class findPairs {
    public static int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        int res = 0;
        for(int i=0; i<nums.length-1; i++){
            for(int j=i+1; j<nums.length; j++)
                if(nums[j] - nums[i] == k) {
                    res++;
                    break;
                }
            while(i<nums.length-1 && nums[i] == nums[i+1])
                i++;
        }
        return res;
    }

    public  int findPairs1(int[] nums, int k) {
        if(k<0 || nums.length<=1){
            return 0;
        }

        Arrays.sort(nums);
        int count = 0;
        int left = 0;
        int right = 1;

        while(right<nums.length){
            int firNum = nums[left];
            int secNum = nums[right];
            // If less than k, increase the right index
            if(secNum-firNum<k){
                right++;
            }
            // If larger than k, increase the left index
            else if(secNum - firNum>k){
                left++;
            }
            // If equal, move left and right to next different number
            else{
                count++;
                while(left<nums.length && nums[left]==firNum){
                    left++;
                }
                while(right<nums.length && nums[right]==secNum){
                    right++;
                }

            }
            //left and right should not be the same number
            if(right==left){
                right++;
            }
        }
        return count;
    }

    public int findPairs2(int[] nums, int k){
        Map<Integer, Boolean> map = new HashMap<>();
        int res = 0;
        for(int i=0; i<nums.length; i++){
            if(map.containsKey(nums[i]-k) && map.get(nums[i]-k) == false){
                res++;
                map.put(nums[i]-k, true);
            }
            if(map.containsKey(nums[i]) && map.containsKey(nums[i] + k)){
                res++;
                map.put(nums[i], true);
            }
            if(!map.containsKey(nums[i])) map.put(nums[i], false);
        }
        return res;
    }

    public static void main(String [] args){
        int[] nums = {3,1,4,1,5};
        findPairs(nums, 2);
    }
}
