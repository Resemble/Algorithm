package Second;

/**
 * @author ranran
 * @version V1.0
 * @Title:
 * @Package Second
 * @Description:在某射击场有N个靶，每个靶上都有一个分数，存在score数组中。击中第i个靶的得分为score[left] * score[i] * score[right]，同时原left和right两个靶变为相邻的靶 当left不存在或者
 * 不能射击时，得分为 score[i] * score[right]，同理right也遵循此规则; 当left和right都不存在或者不能射击时，得分
 * 为score[i]。请计算出击中所有能射击的靶，最多能得多少分？
 * @date 2017/8/15 9:47
 */
public class MaxCoinsSolution {

    public static int maxCoins(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int[][] dp = new int[nums.length][nums.length]; // dp 给人的感觉就像是用了记忆话搜索
        for (int len = 1; len <= nums.length; len++) {  // 对应戳爆一个气球 两个气球。。。
            for (int start = 0; start <= nums.length - len; start++) {
                int end = start + len - 1;
                for (int i = start; i <= end; i++) {
                    int coins = nums[i] * getValue(nums, start - 1) * getValue(nums, end + 1);
                    coins += i != start ? dp[start][i - 1] : 0;  // 第一个
                    coins += i != end ? dp[i + 1][end] : 0; // 最后一个
                    dp[start][end] = Math.max(dp[start][end], coins);
                }
            }
        }
        return dp[0][nums.length - 1];
    }

    private static int getValue(int[] nums, int i) {
        if (i < 0 || i >= nums.length) {
            return 1;
        }
        return nums[i];
    }

    public static void main(String[] args) {
        int[] nums = {35,16,83,87,84,59,48,41,20,54}; // 1849648
//        int[] nums = {2, 4, 8, 4, 0, 7, 8, 9, 1, 2, 4, 7, 1, 7, 3};
        System.out.println(maxCoins(nums));
    }
}
