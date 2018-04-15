package Backtracking;


import java.util.*;

/**
 47. Permutations II

 Given a collection of numbers that might contain duplicates, return all possible unique permutations.

 Example:

 Input: [1,1,2]
 Output:
 [
 [1,1,2],
 [1,2,1],
 [2,1,1]
 ]
 */
public class permuteUnique {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        help(nums, res, 0);
        return res;
    }

    public void help(int [] nums, List<List<Integer>> res, int start){
        if(start == nums.length-1){
            ArrayList<Integer> tmp = new ArrayList<>();
            for(int n : nums)
                tmp.add(n);
            res.add(tmp);
            return;
        }
        Set<Integer> appeared = new HashSet<>();
        for(int i=start; i<nums.length; i++){
            if(appeared.add(nums[i])) {
                swap(nums, i, start);
                help(nums, res, start+1);
                swap(nums, i, start);
            }
        }
    }

    public void swap(int [] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public List<List<Integer>> permuteUnique1(int[] num) {
        Arrays.sort(num);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> current = new ArrayList<Integer>();
        boolean[] visited = new boolean[num.length];
        permute(result, current, num, visited);
        return result;
    }

    private void permute(List<List<Integer>> result, List<Integer> current, int[] num, boolean[] visited) {
        if (current.size() == num.length) {
            result.add(new ArrayList<Integer>(current));
            return;
        }
        for (int i=0; i<visited.length; i++) {
            if (!visited[i]) {
                if (i > 0 && num[i] == num[i-1] && visited[i-1]) {
                    return;
                }
                visited[i] = true;
                current.add(num[i]);
                permute(result, current, num, visited);
                current.remove(current.size()-1);
                visited[i] = false;
            }
        }
    }
}
