package Dynamic_Programming;

/**

 70. Climbing Stairs

 You are climbing a stair case. It takes n steps to reach to the top.

 Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

 Note: Given n will be a positive integer.


 Example 1:

 Input: 2
 Output:  2
 Explanation:  There are two ways to climb to the top.

 1. 1 step + 1 step
 2. 2 steps
 Example 2:

 Input: 3
 Output:  3
 Explanation:  There are three ways to climb to the top.

 1. 1 step + 1 step + 1 step
 2. 1 step + 2 steps
 3. 2 steps + 1 step

 */

public class climbStairs {
    //bottom-top
    public int climbStairs(int n) {
        int [] res = new int[n];
        for(int i=0; i<n; i++){
            if(i<3) res[i] = i+1;
            else
                res[i] = res[i-1] + res[i-2];
        }
        return res[n-1];
    }

    //top-bottom memory the intermediate
    public int climbStairs1(int n) {
        int[] N = new int[n];
        for (int i = 0; i < n; i++){
            N[i] = -1;
        }

        return topdownclimbStairs(n, N);
    }

    private int topdownclimbStairs(int n, int[] N){
        if (n == 0 || n == 1){
            return 1;
        }

        if (N[n - 1] >= 0){
            return N[n - 1];
        }

        else {
            N[n - 1] = topdownclimbStairs(n-1, N) + topdownclimbStairs(n - 2, N);
            return N[n - 1];
        }
    }
}
