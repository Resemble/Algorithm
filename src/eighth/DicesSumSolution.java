package eighth;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package eighth
 * @Description:
 * @date 2019/3/17 10:08 PM
 */
public class DicesSumSolution {
    /**
     * @param n an integer
     * @return a list of Map.Entry<sum, probability>
     */
    public List<Map.Entry<Integer, Double>> dicesSum(int n) {
        // Write your code here
        // Ps. new AbstractMap.SimpleEntry<Integer, Double>(sum, pro)
        // to create the pair

        long[][] dp = new long[n][6 * n];
        dp[0][0] = 1;
        dp[0][1] = 1;
        dp[0][2] = 1;
        dp[0][3] = 1;
        dp[0][4] = 1;
        dp[0][5] = 1;

        for (int i = 1; i < n; i++) {
            for (int j = i; j < (i + 1) * 6; j++) {
                long x1 = 0, x2 = 0, x3 = 0, x4 = 0, x5 = 0, x6 = 0;
                if (j - 1 >= 0) {
                    x1 = dp[i - 1][j - 1];
                }
                if (j - 2 >= 0) {
                    x2 = dp[i - 1][j - 2];
                }
                if (j - 3 >= 0) {
                    x3 = dp[i - 1][j - 3];
                }
                if (j - 4 >= 0) {
                    x4 = dp[i - 1][j - 4];
                }
                if (j - 5 >= 0) {
                    x5 = dp[i - 1][j - 5];
                }
                if (j - 6 >= 0) {
                    x6 = dp[i - 1][j - 6];
                }
                dp[i][j] = x1 + x2 + x3 + x4 + x5 + x6;
            }
        }
        List<Map.Entry<Integer, Double>> result = new ArrayList<Map.Entry<Integer, Double>>();
        for (int i = n - 1; i < 6 * n; i++) {
            AbstractMap.SimpleEntry<Integer, Double> entry = new AbstractMap.SimpleEntry<Integer, Double>(i + 1, dp[n - 1][i] / Math.pow(6, n));
            result.add(entry);
        }
        return result;
    }
}
