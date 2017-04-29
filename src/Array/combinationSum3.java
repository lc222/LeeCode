package Array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liuchong on 2017/4/29.
 */
public class combinationSum3 {
    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        int[] nums = {1,2,3,4,5,6,7,8,9};
        dfs(nums, res, new ArrayList<>(), n, k, 0);
        return res;
    }

    public static void dfs(int[] nums, List<List<Integer>> res, List<Integer> tmp, int target, int k, int index){
        if(k < 0 || target < 0)
            return;
        else if(k == 0 && target == 0){
            res.add(new ArrayList<>(tmp));
            return;
        }else{
            for(int i=index; i<nums.length; i++) {
                tmp.add(nums[i]);
                dfs(nums, res, tmp, target - nums[i], k - 1, i + 1);
                tmp.remove(tmp.size()-1);
            }
        }
    }

    public static List<List<Integer>> combinationSum(int k, int n) {
        return helper2(k, n, 9);
    }

    private static List<List<Integer>> helper2(int k, int n, int end) {
        List<List<Integer>> collection = new ArrayList<List<Integer>>();
        int[] sum = new int[k];
        while (true) {
            while (k > 0 && n > 0 && end > 0) {
                end = end < n ? end : n;
                sum[(k--) - 1] = end;
                n -= end--;
            }
            if (k == 0 && n == 0) {
                List<Integer> list = new ArrayList<Integer>();
                for (int i : sum)
                    list.add(i);
                collection.add(list);
            }
            if (++k > sum.length)
                break;
            end = sum[k - 1];
            n += end--;
        }
        return collection;
    }
    public static void main(String[] args){
        List<List<Integer>> res = combinationSum(3, 9);
        System.out.println("dddd");
    }
}
