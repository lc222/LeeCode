package Array;

/**
 * Created by liuchong on 2017/4/9.
 */
public class maxProfit2 {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        int profit = 0;
        for(int i = 1; i < len ; i++){
            if(prices[i]-prices[i-1] <= 0){
                continue;
            }
            profit += prices[i]-prices[i-1];
        }
        return profit;
    }
}
