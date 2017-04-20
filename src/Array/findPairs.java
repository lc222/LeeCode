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

    public int findPairs2(int[] nums, int k) {
        if (k < 0)   return 0;
        HashMap<Integer,Integer> freqmap = new HashMap<>();
        int count = 0;
        for(int num:nums)
            freqmap.put(num, freqmap.getOrDefault(num, 0)+1);
        for (Integer key : freqmap.keySet()) {
            int a = (int)key;
            int b = a + k;
            if(!freqmap.containsKey(b)) continue;
            int bfreq = freqmap.get(b);
            int minfreq = a==b ? 2:1;
            if(bfreq>=minfreq ){
                count++;
                freqmap.put(a,1);
            }
        }
        return count;
    }

    public static void main(String [] args){
        int[] nums = {1,1,1,2,1};
        findPairs(nums, 1);
    }
}
