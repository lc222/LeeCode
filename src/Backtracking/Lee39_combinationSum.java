package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 39. Combination Sum

 Given a set of candidate numbers (C) (without duplicates) and a target number (T), find all unique combinations in C

 where the candidate numbers sums to T.

 The same repeated number may be chosen from C unlimited number of times.

 Note:
 All numbers (including target) will be positive integers.
 The solution set must not contain duplicate combinations.
 For example, given candidate set [2, 3, 6, 7] and target 7,
 A solution set is:
 [
 [7],
 [2, 2, 3]
 ]
 */

public class Lee39_combinationSum {
    //46%
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if(candidates == null || candidates.length == 0)
            return res;
        Arrays.sort(candidates);
        help(candidates, target, res, new ArrayList<Integer>(), 0);
        return res;
    }

    public void help(int [] candidates, int target, List<List<Integer>> res, ArrayList<Integer> path, int start){
        if(target > 0){
            for(int i=start; i<candidates.length; i++){
                if(candidates[i] > target)
                    break;
                path.add(candidates[i]);
                help(candidates, target-candidates[i], res, path, i);
                path.remove(path.size()-1);
            }
        }else if(target == 0)
            res.add(new ArrayList<Integer>(path));
    }

    public List<List<Integer>> combinationSum2(int[] cands, int t) {
        Arrays.sort(cands); // sort candidates to try them in asc order
        List<List<List<Integer>>> dp = new ArrayList<>();//动态规划所需要使用的数组，因为要保存所有结果，而且每个结果的长度不能确定，所以使用列表来保存
        for (int i = 1; i <= t; i++) { // run through all targets from 1 to t
            List<List<Integer>> newList = new ArrayList(); // combs for curr i对于和为i的都要保存一个newList
            // run through all candidates <= i
            for (int j = 0; j < cands.length && cands[j] <= i; j++) {//前j和数和为i的方案
                // special case when curr target is equal to curr candidate
                if (i == cands[j]) newList.add(Arrays.asList(cands[j]));
                    // if current candidate is less than the target use prev results
                else for (List<Integer> l : dp.get(i-cands[j]-1)) {
                    if (cands[j] <= l.get(0)) {
                        List cl = new ArrayList<>();
                        cl.add(cands[j]); cl.addAll(l);
                        newList.add(cl);
                    }
                }
            }
            dp.add(newList);
        }
        return dp.get(t-1);
    }
}
