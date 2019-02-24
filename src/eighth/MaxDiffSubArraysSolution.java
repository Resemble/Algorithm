package eighth;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package eighth
 * @Description: LintCode--最大子数组差
 * @date 2019/2/24 3:44 PM
 */
public class MaxDiffSubArraysSolution {

    /**
     * @param nums: A list of integers
     * @return: An integer indicate the value of maximum difference between two substrings
     */
    public static int maxDiffSubArrays(int[] nums) {
        // write your code here
       int n = nums.length;
       if (n <= 1) return 0;
       int dp[][] = new int[2][n + 10];
       int res = 0;
       int sum1 = 0, sum2 = 0, minSub = 0, maxSub = 0;
       int minn = nums[n - 1], maxx = nums[n - 1];
        for (int i = n - 1; i >= 0; i--) {
            sum1 += nums[i];
            sum2 += nums[i];
            if (sum1 > 0) sum1 = 0;
            if (sum1 < minSub) minSub = sum1;
            if (minn > nums[i]) minn = nums[i];
            if (sum2 < 0) sum2 = 0;
            if (sum2 > maxSub) maxSub = sum2;
            if (maxx < nums[i]) maxx = nums[i];
            /** dp[0] for the minmum subarray sum, dp[1] for the maximum subarray sum **/
            if (minn >= 0) {
                dp[0][i] = minn;
            } else {
                dp[0][i] = minSub;
            }
            if (maxx <= 0) {
                dp[1][i] = maxx;
            } else {
                dp[1][i] = maxSub;
            }
        }

        sum1 = 0;
        sum2 = 0;
        minSub = 0;
        maxSub = 0;
        minn = nums[0];
        maxx = nums[0];

        for (int i = 0; i < n - 1; i++) {
            sum1 += nums[i];
            sum2 += nums[i];
            if (sum1 > 0) sum1 = 0;
            if (sum1 < minSub) minSub = sum1;
            if (minn > nums[i]) minn = nums[i];
            if (sum2 < 0) sum2 = 0;
            if (sum2 > maxSub) maxSub = sum2;
            if (maxx < nums[i]) maxx = nums[i];
            if (minn >= 0) { /* 最小值比0还大，说明全是正数 */
                res = Math.max(res, Math.abs(minn - dp[1][i + 1]));
            } else {
                res = Math.max(res, Math.abs(minSub - dp[1][i + 1]));
            }
            if (maxx <= 0) { /* 最大值比0还小，说明全是负数 */
                res = Math.max(res, Math.abs(maxx -dp[0][i + 1]));
            } else {
                res = Math.max(res, Math.abs(maxSub - dp[0][i + 1]));
            }
        }
        return res;
    }


    public static void main(String[] args) {
        int[] nums = {-2,0,0,1,-1,-1};
        System.out.println(maxDiffSubArrays(nums));
    }

}
