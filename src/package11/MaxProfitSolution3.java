package package11;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package package11
 * @Description: 122. 买卖股票的最佳时机 II
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
 * @date 2020-06-19 19:53
 */
public class MaxProfitSolution3 {


    public int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                profit += (prices[i] - prices[i - 1]);
            }
        }
        return profit;
    }


    public int maxProfit2(int[] prices) {
        int buy = Integer.MIN_VALUE;
        int sell = 0;
        int profit = 0;
        for (int i = 0; i < prices.length; i++) {
            buy = Math.max(buy, -prices[i]);
            sell = Math.max(sell, prices[i] + buy);
            if (sell > 0) {
                profit += sell;
                buy = -prices[i];
                sell = 0;
            }
        }
        return profit;
    }



}
