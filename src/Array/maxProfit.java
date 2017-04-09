package Array;

/**
 * Created by liuchong on 2017/4/9.
 */
public class maxProfit {
    public int maxProfit(int[] prices) {
        int left = 0, max = 0;
        for(int i=0; i<prices.length; i++){
            if(prices[i] > prices[left])
                max = Math.max(max, prices[i] - prices[left]);
            else
                left = i;
        }
        return max;
    }
}
