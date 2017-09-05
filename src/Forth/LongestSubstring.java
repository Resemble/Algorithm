package Forth;

/**
 * @author ranran
 * @version V1.0
 * @Title:
 * @Package Forth
 * @Description: 最长公共子串
 *  0 1 2 3 4 5 j
   i0
   1
   2
   3
   4
   i=j=0时，dp[i][j]=0
   A[i]=B[j]时(从1计数)，dp[i][j]=dp[i-1][j-1]+1
 * @date 2017/9/5 20:21
 */
public class LongestSubstring {
    public int findLongest(String A, int n, String B, int m) {
        // write code here

        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i < m + 1; i++) {
            dp[0][i] = 0;
        }
        int max = 0;
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }

        return max;
    }
}
