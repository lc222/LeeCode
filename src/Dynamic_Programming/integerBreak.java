package Dynamic_Programming;

/**

 343. Integer Break

 Given a positive integer n, break it into the sum of at least two positive integers and maximize the product of those

 integers. Return the maximum product you can get.

 For example, given n = 2, return 1 (2 = 1 + 1); given n = 10, return 36 (10 = 3 + 3 + 4).

 Note: You may assume that n is not less than 2 and not larger than 58.

 */

public class integerBreak {

    public int integerBreak(int n) {
        if(n == 2 || n== 3) return n-1;
        if(n == 4) return 4;
        int [] dp = new int [n+1];
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 2;
        dp[4] = 4;
        for(int i=5; i<=n; i++){
            for(int j=1; j<=i/2; j++)
                dp[i] = Math.max(dp[i], (Math.max(j,dp[j])) * (Math.max(i - j, dp[i - j])));
        }
        return dp[n];
    }
}
