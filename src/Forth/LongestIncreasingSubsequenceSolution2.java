package Forth;

import java.util.Scanner;

/**
 * @author ranran
 * @version V1.0
 * @Title:
 * @Package Forth
 * @Description: 最长上升子序列，O(N*logN)解法
 * @date 2017/9/4 22:28
 */
public class LongestIncreasingSubsequenceSolution2 {


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
        dp[0] = 1;
        int[] order = new int[nums.length];
        order[0] = nums[0];
        int right = 1;
        for (int i = 1; i < nums.length; i++) {
            // 二分查找第一个比自己大的数，替换之，没找到，写在后面
            // 替换真的是精妙所在
            int start = 0;
            int end = right - 1;
            int resultPos = right;
            while(start <= end) {
                int mid = (start + end) / 2;
                if (order[mid] >= nums[i]) {
                    resultPos = mid;
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
            order[resultPos] = nums[i];
            if (resultPos == right) right++;
            dp[i] = resultPos + 1;
            max = Math.max(max, dp[i]);
        }
        return max;
    }



}
