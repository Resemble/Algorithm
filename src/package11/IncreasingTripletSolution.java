package package11;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package package11
 * @Description: 334. 递增的三元子序列
 * https://leetcode-cn.com/problems/increasing-triplet-subsequence/
 * @date 2020-06-27 20:17
 */
public class IncreasingTripletSolution {

    public boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length <= 2) {
            return false;
        }
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= first) {
                first = nums[i];
            } else if (nums[i] <= second) {
                second = nums[i];
            } else {
                return true;
            }
        }
        return false;
    }

    // [1,2,-10,-8,-7]

    public static void main(String[] args) {
        int[] nums = {1,0,-1,0,100};
        IncreasingTripletSolution solution = new IncreasingTripletSolution();
        if (solution.increasingTriplet(nums))  {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }

}
