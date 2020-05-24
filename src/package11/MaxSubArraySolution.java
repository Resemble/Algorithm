package package11;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package package11
 * @Description: 最大子序和
 * https://leetcode-cn.com/problems/maximum-subarray/submissions/
 * @date 2020-05-24 16:35
 */
public class MaxSubArraySolution {

    public int maxSubArray2(int[] nums) {
        int max = Integer.MIN_VALUE;
        int accSum = 0;
        int max2 = Integer.MIN_VALUE;
        boolean allSmallerThanZero = true;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0) {
                allSmallerThanZero = false;
            }
            max2 = Math.max(max2, nums[i]);
            accSum = Math.max(0, accSum + nums[i]);
            max = Math.max(max, accSum);
        }

        if (allSmallerThanZero) {
            return max2;
        }
        return max;
    }

    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int accSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (accSum > 0) {
                accSum += nums[i];
            } else {
                // 小于0时等于当前的值
                accSum = nums[i];
            }
            max = Math.max(max, accSum);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        MaxSubArraySolution solution = new MaxSubArraySolution();
        System.out.println(solution.maxSubArray(nums));
    }
}
