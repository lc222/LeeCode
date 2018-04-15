package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 78. Subsets

 Given a set of distinct integers, nums, return all possible subsets (the power set).

 Note: The solution set must not contain duplicate subsets.

 For example,
 If nums = [1,2,3], a solution is:

 [
 [3],
 [1],
 [2],
 [1,2,3],
 [1,3],
 [2,3],
 [1,2],
 []
 ]
 */

public class subsets {

    //97.5%
    public List<List<Integer>> subsets(int[] nums) {
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
            tmp.add(nums[i]);
            res.add(new ArrayList<>(tmp));
            help(nums, res, tmp, i+1);
            tmp.remove(tmp.size()-1);
        }
    }
}
