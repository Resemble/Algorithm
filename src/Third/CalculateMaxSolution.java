package Third;

/**
 * @author ranran
 * @version V1.0
 * @Title:
 * @Package Third
 * @Description:风口之下，猪都能飞。当今中国股市牛市，真可谓“错过等七年”。 给你一个回顾历史的机会，已知一支股票连续n天的价格走势，
 * 以长度为n的整数数组表示，数组中第i个元素（prices[i]）代表该股票第i天的股价。 假设你一开始没有股票，但有至多两次买入1股而后卖出1股
 * 的机会，并且买入前一定要先保证手上没有股票。若两次交易机会都放弃，收益为0。 设计算法，计算你能获得的最大收益。 输入数值范围：
 * 2<=n<=100,0<=prices[i]<=100
    输入： 3，8，5，1，7，8 输出：12
 * @date 2017/8/31 9:17
 */
public class CalculateMaxSolution {

    /**
     * 计算你能获得的最大收益
     *
     * @param prices Prices[i]即第i天的股价
     * @return 整型
     */
    public int calculateMax(int[] prices) {

        int firstBuy = Integer.MIN_VALUE;
        int firstSell = Integer.MIN_VALUE;
        int secondBuy = Integer.MIN_VALUE;
        int secondSell = Integer.MIN_VALUE;
        for (int curPrice:prices) {
            firstBuy = Math.max(firstBuy, -curPrice);  // 第一次买入收益
            firstSell = Math.max(firstSell, curPrice + firstBuy); // 第一次卖出收益
            secondBuy = Math.max(secondBuy, firstSell - curPrice);
            secondSell = Math.max(secondSell, secondBuy + curPrice);
        }
        return secondSell;

    }



}
