package Dynamic_Programming;


import java.util.Arrays;

/**
 *
 123. Best Time to Buy and Sell Stock III

 Say you have an array for which the ith element is the price of a given stock on day i.

 Design an algorithm to find the maximum profit. You may complete at most two transactions.

 Note:
 You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 */


public class maxProfit3 {

    //方法1，使用两次循环，第一次找到每个时刻单次买卖的最大利润并保存在maxProfit数组中
    //第二次则从后向前遍历，因为如果两次交易，那么肯定是一次在前一次在后，所以这样反向遍历出
    //单次交易的最大利润，然后将该点的最大利润和maxProfit该点处的利润相加，取最大值即可
    //28%
    public static int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0)
            return 0;
        int [] maxProfit = new int [prices.length];
        int left = 0, max = 0, right = prices.length-1, res = 0, max2=0;
        maxProfit[0] = 0;
        for(int i=1; i<prices.length; i++){
            if(prices[i] < prices[left])
                left = i;
            max = Math.max(max, prices[i] - prices[left]);
            maxProfit[i] = max;
        }

        for(int i=prices.length-2; i>=0; i--){
            if(prices[i] > prices[right])
                right = i;
            max2 = Math.max(max2, prices[right] - prices[i]);
            res = Math.max(res, max2+maxProfit[i]);
        }
        return res;
    }

    //在上面方法的基础上，将两次循环减少为一次循环
    //78%
    public static int maxProfit1(int[] prices) {
        //这四个变量分别表示第一次买入、卖出，第二次买入、卖出时的利润，买即亏损，卖即赚钱
        int firstBuy=Integer.MIN_VALUE, firstSell=0, secondBuy=Integer.MIN_VALUE, secondSell=0;
        for(int price:prices){
            if(firstBuy < -price) firstBuy=-price;
            if(firstSell < price+firstBuy) firstSell=price+firstBuy;
            if(secondBuy < firstSell-price) secondBuy=firstSell-price;
            if(secondSell < price+secondBuy) secondSell=secondBuy+price;
        }
        return secondSell;
    }

    public static void main(String[]args){
        int[]nums={1,2,3,4,2,3,4,8};
        maxProfit1(nums);
    }
}
