package ninth;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package ninth
 * @Description:
 * @date 2019-05-13 22:38
 */
public class MaxProfit2Solution {

    /**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit2(int[] prices) {
        // write your code here
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int buyPrice = prices[0];
        int sumProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > buyPrice) {
                sumProfit = sumProfit + (prices[i] - buyPrice);

            }
            buyPrice = prices[i];
        }
        return sumProfit;
    }

    public int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            int diff = prices[i + 1] - prices[i];
            if (diff > 0) {
                profit += diff;
            }
        }
        return profit;
    }

}
