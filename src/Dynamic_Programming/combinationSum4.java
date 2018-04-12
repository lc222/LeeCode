package Dynamic_Programming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 377. Combination Sum IV

 Given an integer array with all positive numbers and no duplicates, find the number of possible combinations that

 add up to a positive integer target.

 Example:

 nums = [1, 2, 3]
 target = 4

 The possible combination ways are:
 (1, 1, 1, 1)
 (1, 1, 2)
 (1, 2, 1)
 (1, 3)
 (2, 1, 1)
 (2, 2)
 (3, 1)

 Note that different sequences are counted as different combinations.

 Therefore the output is 7.
 Follow up:
 What if negative numbers are allowed in the given array?
 How does it change the problem?
 What limitation we need to add to the question to allow negative numbers?
 */


public class combinationSum4 {
    static int res = 0;
    public static int combinationSum4(int[] candidates, int target) {
        Arrays.sort(candidates);
        help(candidates, target,0);
        return res;
    }

    public static void help(int [] candidates, int target, int start){
        if(target > 0){
            for(int i=start; i<candidates.length; i++)
                help(candidates, target-candidates[i],start);
        }else if(target == 0)
            res ++;
    }

    public static void main(String [] args){
        int [] nums = {1,2,3};
        int aa = combinationSum4(nums, 4);
        System.out.println(aa);
    }
}
