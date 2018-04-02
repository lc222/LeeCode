package Dynamic_Programming;


/**
 309. Best Time to Buy and Sell Stock with Cooldown

 Say you have an array for which the ith element is the price of a given stock on day i.

 Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and

 sell one share of the stock multiple times) with the following restrictions:

 You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)
 Example:

 prices = [1, 2, 3, 0, 2]
 maxProfit = 3
 transactions = [buy, sell, cooldown, buy, sell]

 */
public class maxProfit5 {
    public int maxProfit(int[] prices) {
        int profit1=0, profit2=0;
        for(int i=1; i<prices.length; i++){
            int copy=profit1;
            profit1=Math.max(profit1+prices[i]-prices[i-1], profit2);
            profit2=Math.max(copy, profit2);
        }
        return Math.max(profit1, profit2);
    }
}
