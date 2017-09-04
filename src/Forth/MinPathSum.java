package Forth;

/**
 * @author ranran
 * @version V1.0
 * @Title:
 * @Package Forth
 * @Description: 给定一个只含非负整数的m*n网格，找到一条从左上角到右下角的可以使数字和最小的路径。
 * @date 2017/9/4 17:50
 */
public class MinPathSum {

    public static void main(String[] args) {
        int[][] grid = new int[1][1];
        grid[0][0] = 0;
        System.out.println(minPathSum(grid));
    }

    public static int minPathSum(int[][] grid) {
        // write your code here
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }
        for (int i = 1; i < n; i++) {
            dp[0][i] = dp[0][i-1] + grid[0][i];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[m-1][n-1];
    }

}
