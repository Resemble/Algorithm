package ninth;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package ninth
 * @Description:
 * @date 2019-05-13 22:29
 */
public class MaxProfitSolution {

    /**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int[] prices) {
        // write your code here
        if (prices.length <= 1) {
            return 0;
        }
        int minPrices = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            maxProfit = Math.max(prices[i] - minPrices, maxProfit);
            minPrices = Math.min(minPrices, prices[i]);
        }
        return maxProfit;
    }


}
