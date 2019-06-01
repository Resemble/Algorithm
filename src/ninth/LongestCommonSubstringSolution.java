package ninth;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package ninth
 * @Description:
 * @date 2019-06-01 11:37
 */
public class LongestCommonSubstringSolution {

    /**
     * @param A: A string
     * @param B: A string
     * @return: the length of the longest common substring.
     */
    public int longestCommonSubstring(String A, String B) {
        // write your code here
        if (A == null || B == null || "".equals(A) || "".equals(B)) {
            return 0;
        }
        int aLen = A.length();
        int bLen = B.length();

        int[][] dp = new int[aLen][bLen];

        for (int i = 0; i < aLen; i++) {
            if (A.charAt(i) == B.charAt(0)) {
                dp[i][0] = 1;
            }
        }


        for (int i = 0; i < bLen; i++) {
            if (A.charAt(0) == B.charAt(i)) {
                dp[0][i] = 1;
            }
        }

        for (int i = 1; i < aLen; i++) {
            for (int j = 1; j < bLen; j++) {
                if (A.charAt(i) == B.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < aLen; i++) {
            for (int j = 0; j < bLen; j++) {
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }

}
