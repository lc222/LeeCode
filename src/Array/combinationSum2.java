package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by liuchong on 2017/4/28.
 */
public class combinationSum2 {
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, res, new ArrayList<>(), target, 0);
        return res;
    }

    public static void dfs(int[] candidates, List<List<Integer>> res, List<Integer> tmp, int target, int idx){
        if(target<0)
            return;
        else if(target == 0) {
            if(!res.contains(tmp))
                res.add(new ArrayList<>(tmp));
        }
        else{
            for(int i=idx; i<candidates.length; i++) {
                tmp.add(candidates[i]);
                dfs(candidates, res, tmp, target-candidates[i], i+1);
                tmp.remove(tmp.size()-1);
            }
        }
    }
    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] cand, int remain, int start) {

        if(remain < 0) return; /** no solution */
        else if(remain == 0) list.add(new ArrayList<>(tempList));
        else{
            for (int i = start; i < cand.length; i++) {
                if(i > start && cand[i] == cand[i-1]) continue; /** skip duplicates */
                tempList.add(cand[i]);
                backtrack(list, tempList, cand, remain - cand[i], i+1);
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    public void dfs2(int[] candidates, List<List<Integer>> res, int[] list, int cindex, int lindex, int target){
        if(target == 0){
            List<Integer> tmp = new ArrayList<>();
            for(int num:list)
                tmp.add(num);
            res.add(tmp);
            return;
        }
        int prev = 0;
        for(int i=cindex; i<candidates.length; i++){
            if(candidates[i] != prev && target - candidates[i] < 0)
                break;
            list[lindex] = candidates[i];
            dfs2(candidates, res, list, cindex+1, lindex+1, target-candidates[i]);
            prev = candidates[i];
        }
    }

    public static void main(String[] args){
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        combinationSum2(candidates, 8);
    }
}
