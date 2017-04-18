package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by liuchong on 2017/4/18.
 */
public class subsets {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        res.add(new ArrayList<Integer>());

        for(int num :nums){
            List<List<Integer>> tmp = new ArrayList<>();
            for(List<Integer> list : res){
                List<Integer> aa = new ArrayList<>(list);
                aa.add(num);
                tmp.add(aa);
            }
            res.addAll(tmp);
        }

        return res;
    }

    public static List<List<Integer>> subsets1(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(res, new ArrayList<>(), nums, 0);
        return res;
    }

    public static void backtrack(List<List<Integer>> res, List<Integer> tmp, int[] nums, int start){
        res.add(new ArrayList<>(tmp));
        for(int i=start; i<nums.length; i++){
            tmp.add(nums[i]);
            backtrack(res, tmp, nums, i+1);
            tmp.remove(tmp.size()-1);
        }
    }


    public static void main(String[] args){
        int[] nums = {1,2,3};
        subsets1(nums);
    }
}
