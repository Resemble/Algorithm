package package11;

import java.util.HashSet;
import java.util.Set;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package package11
 * @Description: 322. 零钱兑换
 * https://leetcode-cn.com/problems/coin-change/
 * @date 2020-05-24 22:59
 */
public class CoinChangeSolution {

    public int coinChange2(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        Set<Integer> coinsSet = new HashSet<>();
        for (int i = 0; i < coins.length; i++) {
            coinsSet.add(coins[i]);
        }
        int[] coinCnt = new int[amount + 1];
        if (coinsSet.contains(1)) {
            coinCnt[1] = 1;
        }
        for (int i = 1; i < amount + 1; i++) {
            if (coinsSet.contains(i)) {
                coinCnt[i] = 1;
            } else {
                for (int j = 0; j < coins.length; j++) {
                    int sub = i - coins[j];
                    if (sub >= 1 && coinCnt[sub] != 0) {
                        coinCnt[i] = coinCnt[i] == 0 ?
                            coinCnt[sub] + 1 :
                            Math.min(coinCnt[i], coinCnt[sub] + 1);
                    }
                }

            }

        }
        return coinCnt[amount] == 0 ? -1 : coinCnt[amount];
    }

    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        int[] coinCnt = new int[amount + 1];
        for (int i = 1; i < amount + 1; i++) {
            coinCnt[i] = amount + 1;
            for (int j = 0; j < coins.length; j++) {
                int sub = i - coins[j];
                if (sub >= 0) {
                    coinCnt[i] = Math.min(coinCnt[i], coinCnt[sub] + 1);
                }
            }
        }
        return coinCnt[amount] == amount + 1 ? -1 : coinCnt[amount];
    }


//    public int coinChange(int[] coins, int amount) {
//        if (coins.length == 0) {
//            return -1;
//        }
//        if (amount == 0) {
//            return 0;
//        }
//        int[] coinCnt = new int[amount + 1];
//        for (int i = 0; i < coins.length; i++) {
//            for (int j = coins[i]; j <= amount; j++) {
//                if (coinCnt[j - coins[i]] != 0) {
//                    coinCnt[j] = coinCnt[j] == 0 ?
//                        coinCnt[j - coins[i]] + 1 :
//                        Math.min(coinCnt[j], coinCnt[j - coins[i]] + 1);
//                }
//            }
//        }
//        return coinCnt[amount] == 0 ? -1 : coinCnt[amount];
//    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;
        CoinChangeSolution solution = new CoinChangeSolution();
        System.out.println(solution.coinChange(coins, amount));
    }
}
