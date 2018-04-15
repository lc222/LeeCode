package Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 77. Combinations

 Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

 For example,
 If n = 4 and k = 2, a solution is:

 [
 [2,4],
 [3,4],
 [2,3],
 [1,2],
 [1,3],
 [1,4],
 ]
 */

public class combine {
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if(k > n)
            return res;
        help(res, new ArrayList<Integer>(), n, k, 1);
        return res;
    }

    public static void help(List<List<Integer>> res, ArrayList<Integer> tmp, int n, int k, int i){
        if(i > n && k != 0)
            return;
        if(k == 0){
            res.add(new ArrayList<>(tmp));
        }else{
            for(int j=i; j<=n; j++) {
                tmp.add(j);
                help(res, tmp, n, k - 1, j + 1);
                tmp.remove(tmp.size()-1);
            }
        }
    }

    public List<List<Integer>> combine1(int n, int k) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (k > n || k < 0) {
            return result;
        }
        if (k == 0) {
            result.add(new ArrayList<>());
            return result;
        }
        result = combine1(n - 1, k - 1);
        for (List<Integer> list : result) {
            list.add(n);
        }
        result.addAll(combine1(n - 1, k));
        return result;
    }

    public static void main(String [] args){
        List<List<Integer>> res = combine(4,2);
        System.out.println(res.toString());
    }
}
