package package11;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package package11
 * @Description:198. 打家劫舍
 * https://leetcode-cn.com/problems/house-robber/
 * @date 2020-05-24 17:25
 */
public class RobSolution {

    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        } else if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[1], nums[0]);
        for (int i = 2; i < nums.length; i++) {
            // 状态转移方程
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[nums.length - 1];
    }

    public int rob2(int[] nums) {
        if (nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        } else if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        sum[1] = nums[1];
        sum[2] = nums[2] + nums[0];
        for (int i = 3; i < nums.length; i++) {
            sum[i] = nums[i] + Math.max(sum[i - 2], sum[i - 3]);
        }
        return Math.max(sum[nums.length - 1], sum[nums.length - 2]);
    }

}
