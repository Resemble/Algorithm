package Forth;

import java.util.Scanner;

/**
 * @author ranran
 * @version V1.0
 * @Title:
 * @Package Forth
 * @Description: 网格
 * @date 2017/9/7 11:26
 */
public class GridWays {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < m + 1 ; i++) {
            dp[i][0] = 1;
        }

        for (int i = 0; i < n + 1; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        System.out.println(dp[m][n]);
    }
}
