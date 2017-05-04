package Array;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
import java.util.List;

/**
 * Created by liuchong on 2017/5/4.
 */
public class findDuplicates {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0; i<nums.length-1; i++){
            if(nums[i] == nums[i+1]) {
                res.add(nums[i]);
                i++;
            }
        }
        return res;
    }

    public List<Integer> findDuplicates1(int[] nums) {
        List<Integer> res = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            if(map.containsKey(num))
                res.add(num);
            else
                map.put(num, 1);
        }
        return res;
    }

    public List<Integer> findDuplicates2(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int index;
        for(int i=0; i<nums.length; i++){
            index = Math.abs(nums[i]) - 1;
            if(nums[index] < 0)
                res.add(Math.abs(index+1));
            nums[index] = -nums[index];
        }
        return res;
    }
}
