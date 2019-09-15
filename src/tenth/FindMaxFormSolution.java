package tenth;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package tenth
 * @Description: 474. 一和零
 * @date 2019-09-15 22:05
 */
public class FindMaxFormSolution {

    /**
     * 设dp[i][j]表示i个0和j个1可以最多构造多少个字符串，
     * 则对于数组中每个字符串（含zeros个0,ones个1），当我们选择构造它时，剩下的0,1还能构造多少个字符串？
     * dp[i][j] = max(dp[i][j], 1 + dp[i-zeros][j-ones])
     */
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (String str : strs) {
            int one = 0;
            int zero = 0;
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == '0') {
                    zero++;
                } else {
                    one++;
                }
            }

            for (int i = m; i >= zero; i--) {
                for (int j = n; j >= one; j--) {
                    dp[i][j] = Math.max(dp[i][j], 1 + dp[i - zero][j - one]);
                }
            }
        }
        return dp[m][n];
    }


    public static void main(String[] args) {

        FindMaxFormSolution solution = new FindMaxFormSolution();
        String[] strs = {"10", "0", "1"};
        int m = 1, n = 1;
        System.out.println(solution.findMaxForm(strs, m, n));

    }



}
