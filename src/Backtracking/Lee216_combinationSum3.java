package Backtracking;

import java.util.ArrayList;
import java.util.List;

/**

 216. Combination Sum III
 Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used

 and each combination should be a unique set of numbers.


 Example 1:

 Input: k = 3, n = 7

 Output:

 [[1,2,4]]

 Example 2:

 Input: k = 3, n = 9

 Output:

 [[1,2,6], [1,3,5], [2,3,4]]
 */

public class Lee216_combinationSum3 {
    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        help(k, n, res, new ArrayList<Integer>(), 1);
        return res;
    }

    public static void help(int k, int n, List<List<Integer>> res, ArrayList<Integer> path, int start){
        if(k == 0 && n == 0)
            res.add(new ArrayList<>(path));
        else if(k > 0 && n >0){
            for(int i=start; i<=9; i++){
                if(i > n)
                    break;
                path.add(i);
                help(k-1, n-i, res, path, i+1);
                path.remove(path.size()-1);
            }
        }
    }

    public static void main(String[] args){
        List<List<Integer>> res = combinationSum3(3,7);
        System.out.println("dd");
    }
}
