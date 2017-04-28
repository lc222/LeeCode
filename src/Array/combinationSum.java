package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by liuchong on 2017/4/27.
 */
public class combinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, res, new ArrayList<>(), target, 0);
        return res;
    }

    public void dfs(int[] candidates, List<List<Integer>> res, List<Integer> tmp, int target, int idx){
        if(target == 0)
            res.add(new ArrayList<>(tmp));
        else if(target < 0)
            return;
        else{
            for(int i=idx; i<candidates.length; i++){
                tmp.add(candidates[i]);
                dfs(candidates, res, tmp, target-candidates[i], i);
                tmp.remove(tmp.size()-1);
            }
        }
    }

    public static List<List<Integer>> combinationSum1(int[] candidates, int target) {
        return combinationSum(candidates, target, 0);
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target, int start) {

        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(candidates);
        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] <target) {
                for (List<Integer> ar : combinationSum(candidates, target - candidates[i], i)) {
                    ar.add(0, candidates[i]);
                    res.add(ar);
                }
            } else if (candidates[i] == target) {
                List<Integer> lst = new ArrayList<>();
                lst.add(candidates[i]);
                res.add(lst);
            } else
                break;
        }
        return res;
    }

    public static void main(String[] args){
        int[] nums = {2,3,4,7};
        combinationSum1(nums, 7);
    }
}
