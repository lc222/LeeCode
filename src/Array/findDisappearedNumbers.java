package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by liuchong on 2017/4/13.
 */
public class findDisappearedNumbers {
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        Arrays.sort(nums);
        int dis = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] > i+1 && dis == 0)
                res.add(i+1);
            else if(nums[i]+dis < i+1) {
                dis++;
            }else if(nums[i]+dis > i+1)
                while(dis > 0)
                    res.add(nums[i] - dis--);
        }
        while(dis>0)
            res.add(nums.length - dis-- +1);
        return res;
    }

    public static List<Integer> findDisappearedNumbers1(int[] nums) {
        List<Integer> ret = new ArrayList<Integer>();

        for(int i = 0; i < nums.length; i++) {
            int val = Math.abs(nums[i]) - 1;
            if(nums[val] > 0) {
                nums[val] = -nums[val];
            }
        }

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > 0) {
                ret.add(i+1);
            }
        }
        return ret;
    }

    public List<Integer> findDisappearedNumbers2(int[] nums) {
        boolean[] bloom = new boolean[nums.length];
        for (int n : nums) {
            bloom[n-1] = true;
        }
        List<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < bloom.length; i++) {
            if (!bloom[i]) {
                result.add(i+1);
            }
        }
        return result;
    }

    public static void main(String [] args){
        int [] nums = {10,2,5,10,9,1,1,4,3,7};
        findDisappearedNumbers1(nums);
    }
}
