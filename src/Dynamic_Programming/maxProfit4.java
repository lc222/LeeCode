package Dynamic_Programming;

import java.util.Arrays;

/**
 *
 * 188. Best Time to Buy and Sell Stock IV

 Say you have an array for which the ith element is the price of a given stock on day i.

 Design an algorithm to find the maximum profit. You may complete at most k transactions.

 Note:
 You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 */

public class maxProfit4 {

    //时间复杂度和空间复杂度都是：O(NK) 55%
    public int maxProfit(int k, int[] prices) {
        if(prices == null || prices.length == 0)
            return 0;
        if(prices.length/2 < k){
            int res=0;
            for(int i=1; i<prices.length; i++){
                if(prices[i] > prices[i-1])
                    res += prices[i]-prices[i-1];
            }
            return res;
        }

        int [][] dp = new int[k+1][prices.length];
        for(int i=1; i<=k; i++){
            int localMax = dp[i-1][0] - prices[0];
            for(int j=1; j<prices.length; j++){
                dp[i][j] = Math.max(dp[i][j-1], localMax+prices[j]);
                localMax = Math.max(localMax, dp[i-1][j]-prices[j]);
            }
        }
        return dp[k][prices.length-1];
    }
    //时间复杂度是O(NK),空间复杂度是：O(N) 95.78%
    public int maxProfit1(int k, int[] prices){
        if(prices == null || prices.length == 0)
            return 0;
        if(k>=prices.length/2){
            int maxProfit = 0;
            for(int i=1; i<prices.length; i++){
                if(prices[i]>prices[i-1]) maxProfit += prices[i]-prices[i-1];
            }
            return maxProfit;
        }

        int [] maxProfit = new int[prices.length];
        int pMin = 0;
        for(int i=0; i<k; i++){
            int [] dp = new int[prices.length];
            int min = Integer.MAX_VALUE;
            for(int j=0; j<prices.length; j++){
                if(j > 0)
                    dp[j] = Math.max(dp[j-1], prices[j] - min);
                min = Math.min(min, prices[j] - maxProfit[j]);
            }
            maxProfit = dp;
            pMin = min;
        }
        return maxProfit[prices.length-1];
    }

    //时间复杂度为O(NK)，空间复杂度为O(K)
    public int maxProfit2(int k, int[] prices){
        if(prices == null || prices.length == 0)
            return 0;
        if(k>=prices.length/2){
            int maxProfit = 0;
            for(int i=1; i<prices.length; i++){
                if(prices[i]>prices[i-1]) maxProfit += prices[i]-prices[i-1];
            }
            return maxProfit;
        }

        // Method I: T:O(KN)  S:O(K)
        int[] dp = new int[k + 1];
        int[] min = new int[k + 1];
        Arrays.fill(min, Integer.MAX_VALUE);
        for(int i = 0; i < prices.length; i++) {
            for(int j = k; j >= 1; j--) {
                dp[j] = Math.max(dp[j], prices[i] - min[j]);
                min[j] = Math.min(min[j], prices[i] - dp[j - 1]);
            }
        }
        return dp[k];
    }
}
