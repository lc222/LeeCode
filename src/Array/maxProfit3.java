package Array;

/**
 * Created by liuchong on 2017/6/14.
 */
public class maxProfit3 {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len < 2)
            return 0;
        int [] maxBefore = new int[len];
        int min = prices[0];
        for(int i=1; i<len; i++){
            maxBefore[i] = Math.max(maxBefore[i-1], prices[i] - min);
            min = Math.min(min, prices[i]);
        }
        int max = prices[len - 1];
        int ret = 0;
        for(int i=len-2; i>=0; i--){
            //找到后面最大的价格
            max = Math.max(prices[i], max);
            //利润 = 最大价格 - 当前价格 + 此时交易时第一次的利润
            //取最大值
            ret = Math.max(ret, max - prices[i] + maxBefore[i]);
        }
        return ret;
    }

    public int maxProfit1(int[] prices) {
        int len = prices.length;
        if(len <= 1) return 0;
        int a, b, c, d;
        d = Math.max(prices[len-1], prices[len-2]);
        c = Math.max(prices[len-1] - prices[len-2], 0);
        b = d;
        a = c;
        for(int i=len-3; i>=0; i--) {
            a = Math.max(b - prices[i], a);
            b = Math.max(prices[i] + c, b);
            c = Math.max(d - prices[i], c);
            d = Math.max(prices[i], d);
        }
        return a;
    }

    public int maxProfit2(int[] prices) {
        // these four variables represent your profit after executing corresponding transaction
        // in the beginning, your profit is 0.
        // when you buy a stock ,the profit will be deducted of the price of stock.
        int firstBuy = Integer.MIN_VALUE, firstSell = 0;
        int secondBuy = Integer.MIN_VALUE, secondSell = 0;

        for (int curPrice : prices) {
            if (firstBuy < -curPrice) firstBuy = -curPrice; // the max profit after you buy first stock
            if (firstSell < firstBuy + curPrice) firstSell = firstBuy + curPrice; // the max profit after you sell it
            if (secondBuy < firstSell - curPrice) secondBuy = firstSell - curPrice; // the max profit after you buy the second stock
            if (secondSell < secondBuy + curPrice) secondSell = secondBuy + curPrice; // the max profit after you sell the second stock
        }

        return secondSell; // secondSell will be the max profit after passing the prices
    }
}
