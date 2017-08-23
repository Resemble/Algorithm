package Third;

/**
 * @author ranran
 * @version V1.0
 * @Title:
 * @Package Third
 * @Description:在一个二维01矩阵中找到全为1的最大正方形
 * @date 2017/8/23 17:27
 */
public class MaxSquareSolution {

    public int maxSquare(int[][] matrix) {
        // write your code here

        int m = matrix.length;
        int n = matrix[0].length;
        int ans = 0;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 1) {
                dp[i][0] = 1;
                ans = 1;
            }
        }

        for (int i = 0; i < n; i++) {
            if(matrix[0][i] == 1) {
                dp[0][i] = 1;
                ans = 1;
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix[j][i] == 1) {
                    dp[j][i] = Math.min(dp[j-1][i-1], Math.min(dp[j-1][i], dp[j][i-1])) + 1;
                    ans = Math.max(dp[j][i], ans);
                }else {
                    dp[j][i] = 0;
                }
            }
        }
        return ans * ans;
    }

}
