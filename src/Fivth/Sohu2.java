package Fivth;

import java.util.Scanner;

/**
 * @author ranran
 * @version V1.0
 * @Title:
 * @Package Fivth
 * @Description:
 * @date 2017/9/17 19:59
 */
public class Sohu2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(getSum(arr, 0,n - 1));
    }

    public static int getSum(int[] arr, int i, int j) {
//        int[][] dp = new int[arr.length][arr.length];
//        dp[i][j] = Math.min(arr[i] *2 + dp[i+1][j], arr[j] * 2 + dp[i][j+1]);
        if (j < 0 || i > arr.length - 1) return 0;
        if(i == j) {
            return arr[i];
        }
        if (i < j) {
            if (arr[i] == arr[j]) {
                return arr[i] * 2 + getSum(arr, i+1, j-1);
            } else {
                return Math.min(arr[i]*2 + getSum(arr, i+1, j), arr[j]*2 + getSum(arr, i, j-1));
            }
        }
        return 0;
    }

}
