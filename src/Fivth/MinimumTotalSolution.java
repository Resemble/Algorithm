package Fivth;

import java.util.Scanner;

/**
 * @author ranran
 * @version V1.0
 * @Title:
 * @Package Fivth
 * @Description: 数字三角形
 * @date 2017/9/13 8:59
 */
public class MinimumTotalSolution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[][] arr = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j <= i; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }

            System.out.println(findMax(arr));
        }
    }

    public static int findMax(int[][] arr) {
        int[][] dp = new int[arr.length][arr.length];
        dp[0][0] = arr[0][0];
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j <= i; j++) {
                int low = j - 1;
                int high = j;
                if (j - 1 < 0) low = j;
                if (j == i) high = j - 1;
                dp[i][j] = Math.max(dp[i - 1][low], dp[i - 1][high]) + arr[i][j];
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(dp[arr.length - 1][i], max);
        }
        return max;
    }


}
