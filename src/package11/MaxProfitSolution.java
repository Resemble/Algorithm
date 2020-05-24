package package11;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package package11
 * @Description: 买卖股票的最佳时机
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/23/dynamic-programming/55/
 * @date 2020-05-24 16:25
 */
public class MaxProfitSolution {

    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int maxProfitValue = 0;
        for (int i = 0; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            maxProfitValue = Math.max(maxProfitValue, prices[i] - min);
        }
        return maxProfitValue;
    }

}
