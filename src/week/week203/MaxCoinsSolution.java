package week.week203;

import java.util.Arrays;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package week.week203
 * @Description:
 * @date 2020-08-23 10:51
 */
public class MaxCoinsSolution {

    public int maxCoins(int[] piles) {
        int max = 0;
        Arrays.sort(piles);
        int n = piles.length / 3;
        for (int i = 0; i < n; i++) {
            max = max + piles[piles.length - i * 2 - 2];
        }
        return max;
    }

}
