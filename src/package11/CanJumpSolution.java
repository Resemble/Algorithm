package package11;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package package11
 * @Description: 55. 跳跃游戏
 * https://leetcode-cn.com/problems/jump-game/
 * @date 2020-05-25 22:31
 */
public class CanJumpSolution {

    public boolean canJump(int[] nums) {
        int n = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] >= n) {
                n = 1;
            } else {
                n++;
            }

        }
        return n > 1 ? false : true;
    }

}
