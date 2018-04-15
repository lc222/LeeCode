package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 90. Subsets II

 Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).

 Note: The solution set must not contain duplicate subsets.

 For example,
 If nums = [1,2,2], a solution is:

 [
 [2],
 [1],
 [1,2,2],
 [2,2],
 [1,2],
 []
 ]
 */

public class subsetsWithDup {

    //99.2%
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        ArrayList<Integer> tmp = new ArrayList<>();
        Arrays.sort(nums);
        res.add(tmp);
        help(nums, res, tmp, 0);
        return res;
    }

    public void help(int [] nums, List<List<Integer>> res, ArrayList<Integer> tmp, int start){
        if(start == nums.length)
            return;
        for(int i=start; i<nums.length; i++){
            if(i > start && nums[i] == nums[i-1])
                continue;
            tmp.add(nums[i]);
            res.add(new ArrayList<>(tmp));
            help(nums, res, tmp, i+1);
            tmp.remove(tmp.size()-1);
        }
    }

    //100%
    public List<List<Integer>> subsetsWithDup2(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        int begin = 0;
        for(int i = 0; i < nums.length; i++){
            if(i == 0 || nums[i] != nums[i - 1]) begin = 0;
            int size = result.size();
            for(int j = begin; j < size; j++){
                List<Integer> cur = new ArrayList<>(result.get(j));
                cur.add(nums[i]);
                result.add(cur);
            }
            begin = size;
        }
        return result;
    }
}
