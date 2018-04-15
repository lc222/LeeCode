package Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 46. Permutations

 Given a collection of distinct integers, return all possible permutations.

 Example:

 Input: [1,2,3]
 Output:
 [
 [1,2,3],
 [1,3,2],
 [2,1,3],
 [2,3,1],
 [3,1,2],
 [3,2,1]
 ]
 */

public class permute {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        help(nums, res, 0);
        return res;
//        ArrayList<Integer> tmp = new ArrayList<>();
//        for(int n:nums)
//            tmp.add(n);
//        help1(res, 0, tmp);
//        return res;
    }

    public void help1(List<List<Integer>> res, int start, ArrayList<Integer> nums){
        if(start == nums.size())
            res.add(new ArrayList<>(nums));
        for(int i=start; i<nums.size(); i++){
            swap(nums, start, i);
            help1(res, start+1, nums);
            swap(nums, start, i);
        }
    }

    public static void help(int [] nums, List<List<Integer>> res, int start){
        if(start == nums.length-1){
            ArrayList<Integer> tmp = new ArrayList<>();
            for(int n : nums)
                tmp.add(n);
            res.add(tmp);
            return;
        }
        for(int i=start; i<nums.length; i++){
            if(start == i || nums[i] != nums[start]) {
                swap(nums, i, start);
                help(nums, res, start+1);
                swap(nums, i, start);
            }
        }
    }

    public static void swap(int [] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public void swap(ArrayList<Integer> nums, int i, int j){
        int tmp = nums.get(i);
        nums.set(i, nums.get(j));
        nums.set(j, tmp);
    }

    public static void main(String [] args){
        int [] nums = {1,2,3};
        List<List<Integer>> res = permute(nums);
        System.out.println(res.toString());
    }
}
