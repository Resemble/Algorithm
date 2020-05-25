package package11;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package package11
 * @Description: 300. 最长上升子序列
 * https://leetcode-cn.com/problems/longest-increasing-subsequence/
 * @date 2020-05-25 22:06
 */
public class LengthOfLISSolution {

    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int maxCnt = 0;
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxCnt = Math.max(maxCnt, dp[i]);
        }
        return maxCnt;
    }

}
