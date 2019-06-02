package ninth;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package ninth
 * @Description:
 * @date 2019-06-02 21:21
 */
public class CoinChangeSolution {

    /**
     * @param coins: a list of integer
     * @param amount: a total amount of money amount
     * @return: the fewest number of coins that you need to make up
     */

    int[] dp;

    public int coinChange(int[] coins, int amount) {
        // write your code here
        if (amount < 0) {
            return -1;
        } else if (amount == 0) {
            return 0;
        }

        dp = new int[amount + 1];
        for (int i = 0; i < amount + 1; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 0;
        getMinWay(coins, amount);
        return dp[amount];
    }

    public void getMinWay(int[] coins, int amount) {
        for (int i = 1; i <= amount; i++) {
            int subAmount;
            for (int j = 0; j < coins.length; j++) {
                subAmount = i - coins[j];
                if (subAmount >= 0 && dp[subAmount] != Integer.MAX_VALUE && dp[subAmount] != -1) {
                    dp[i] = Math.min(dp[i], 1 + dp[subAmount]);
                }
            }
            if (dp[i] == Integer.MAX_VALUE) {
                dp[i] = -1;
            }
        }

    }


    public static void main(String[] args) {
//        [1,2,5]
//        11
//        int[] coins = {1};
//        int amount = 19999;
//        int[] coins = {3};
//        int amount = 2;
        int[] coins = {1, 2, 5};
        int amount = 11;
        CoinChangeSolution solution = new CoinChangeSolution();
        System.out.println(solution.coinChange(coins, amount));
    }

}
