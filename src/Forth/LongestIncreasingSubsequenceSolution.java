package Forth;

import java.util.Scanner;

/**
 * @author ranran
 * @version V1.0
 * @Title:
 * @Package Forth
 * @Description: 最长上升子序列，O(n^2)解法
 * @date 2017/9/4 21:28
 */
public class LongestIncreasingSubsequenceSolution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = sc.nextInt();
            }
            System.out.println(longestIncreasingSubsequence(nums));
        }
    }

    public static int longestIncreasingSubsequence(int[] nums) {
        // write your code here
        if (nums.length == 0) return 0;
        if (nums.length == 1) return 1;
        int max = 1;
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
        }
        for (int i = 1; i < nums.length; i++) {
            for (int j = i; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;

    }


}
