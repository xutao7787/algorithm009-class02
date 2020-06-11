package Week_04;

/**
 * 122. 买卖股票的最佳时机 II
 * Created by xutao on 2020/6/10.
 */
public class MaxProfit_122 {

    public int maxProfit(int[] prices) {
        int len = prices.length;
        int count = 0;
        for (int i = 0; i < len - 1; i++) {
            if(prices[i + 1] > prices[i]) {
                count += prices[i + 1] - prices[i];
            }
        }
        return count;
    }

}
