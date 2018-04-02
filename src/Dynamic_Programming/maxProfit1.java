package Dynamic_Programming;

/**

 121. Best Time to Buy and Sell Stock

 Say you have an array for which the ith element is the price of a given stock on day i.

 If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design

 an algorithm to find the maximum profit.

 Example 1:
 Input: [7, 1, 5, 3, 6, 4]
 Output: 5

 max. difference = 6-1 = 5 (not 7-1 = 6, as selling price needs to be larger than buying price)
 Example 2:
 Input: [7, 6, 4, 3, 1]
 Output: 0

 In this case, no transaction is done, i.e. max profit = 0.

 */

public class maxProfit1 {

    //DP算法
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length <= 0)
            return 0;
        int min = prices[0];
        int max = Integer.MIN_VALUE;
        for(int num : prices){
            if(min > num)
                min = num;
            max = Math.max(max, num - min);
        }
        return max;
    }

    public int maxProfit1(int[] prices) {
        int maxCur = 0, maxSoFar = 0;
        for(int i = 1; i < prices.length; i++) {
            maxCur = Math.max(0, maxCur += prices[i] - prices[i-1]);
            maxSoFar = Math.max(maxCur, maxSoFar);
        }
        return maxSoFar;
    }
}
