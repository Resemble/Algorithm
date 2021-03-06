package Fivth;

/**
 * @author ranran
 * @version V1.0
 * @Title:
 * @Package Fivth
 * @Description: 背包问题 VI
 * 给出一个都是正整数的数组 nums，其中没有重复的数。从中找出所有的和为 target 的组合个数。
 * 注意事项
 * 一个数可以在组合中出现多次。
 * 数的顺序不同则会被认为是不同的组合。
 * 您在真实的面试中是否遇到过这个题？ Yes
 * 样例
 * 给出 nums = [1, 2, 4], target = 4
 * 可能的所有组合有：
 * [1, 1, 1, 1]
 * [1, 1, 2]
 * [1, 2, 1]
 * [2, 1, 1]
 * [2, 2]
 * [4]
 * 返回 6
 * @date 2017/9/11 17:12
 */
public class BackPackVISolution {

    public static void main(String[] args) {
        int[] nums = {1, 2, 4};
        int target = 4;
        System.out.println(backPackVI(nums, target));
        System.out.println(backPack2(nums, target));
    }

    // 一维数组从右到左更新
    public static int backPackVI(int[] nums, int target) {
        // write your code here

        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] <= i) {
                    dp[i] += dp[i - nums[j]];
                }
            }
        }
        return dp[target];
    }

    public static int backPack2(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1; // 一定会实现
        for (int i = 1; i <= target; i++) {  // 从上往下
            for (int j = nums.length - 1; j >= 0; j--) {  // 从右往左
                if (nums[j] <= i) {
                    dp[i] += dp[i - nums[j]];
                }
            }
        }
        return dp[target];
    }

}
