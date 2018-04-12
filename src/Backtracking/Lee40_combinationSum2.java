package Backtracking;

import java.util.*;

/**
 40. Combination Sum II

 Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

 Each number in C may only be used once in the combination.

 Note:
 All numbers (including target) will be positive integers.
 The solution set must not contain duplicate combinations.
 For example, given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8,
 A solution set is:
 [
 [1, 7],
 [1, 2, 5],
 [2, 6],
 [1, 1, 6]
 ]
 */

public class Lee40_combinationSum2 {
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        Set<List<Integer>> res = new HashSet<>();
        help(candidates, target, res, new ArrayList<Integer>(), 0);
        List<List<Integer>> list = new ArrayList<>();
        for(List<Integer> li : res)
            list.add(li);
        return list;
    }

    public static void help(int [] candidates, int target, Set<List<Integer>> res, ArrayList<Integer> path, int start){
        if(target > 0){
            for(int i=start; i<candidates.length; i++){
                path.add(candidates[i]);
                help(candidates, target-candidates[i], res, path, i+1);
                path.remove(path.size()-1);
            }
        }else if(target == 0)
            res.add(new ArrayList<>(path));
    }

    public List<List<Integer>> combinationSum2_1(int[] cand, int target) {
        Arrays.sort(cand);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> path = new ArrayList<Integer>();
        dfs_com(cand, 0, target, path, res);
        return res;
    }
    void dfs_com(int[] cand, int cur, int target, List<Integer> path, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList(path));
            return ;
        }
        if (target < 0) return;
        for (int i = cur; i < cand.length; i++){
            if(cand[i] > target)
                break;
            //去除重复元素，逐一这句判断在递归调用之前执行，而且要求i>cur，
            // 这就保证了想1,1,6这样的答案仍然会被计算。同时不会出现两个1,7的情况
            if (i > cur && cand[i] == cand[i-1]) continue;
            path.add(path.size(), cand[i]);
            dfs_com(cand, i+1, target - cand[i], path, res);
            path.remove(path.size()-1);
        }
    }

    public static void main(String[] args){
        int [] a = {10, 1,2,7,6,1,5};
        combinationSum2(a, 8);
    }
}
