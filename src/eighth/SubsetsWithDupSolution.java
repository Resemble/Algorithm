package eighth;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package eighth
 * @Description:
 * 子集 II
 * 给定一个可能具有重复数字的列表，返回其所有可能的子集。
 * 输入：[1,2,2]
 * 输出：
 * [
 * [2],
 * [1],
 * [1,2,2],
 * [2,2],
 * [1,2],
 * []
 * ]
 * @date 2019/3/25 10:36 PM
 */
public class SubsetsWithDupSolution {

    /**
     * @param nums: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // write your code here
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null) return result;
        if (nums.length == 0) {
            result.add(new ArrayList<Integer>());
            return result;
        }
        Arrays.sort(nums);
        List<Integer> subset = new ArrayList<Integer>();
        helper(nums, 0, subset, result);

        return result;
    }

    public void helper(int[] nums, int startIndex, List<Integer> subset, List<List<Integer>> result) {
        result.add(new ArrayList<Integer>(subset));
        for (int i = startIndex; i < nums.length; i++) {
            if (i != startIndex && nums[i] == nums[i - 1]) { // 从第i个开始的循环不允许有两次相同的操作
                continue;
            }
            subset.add(nums[i]);
            helper(nums, i + 1, subset, result);
            subset.remove(subset.size() - 1);
        }
    }



    public static void main(String[] args) {
        //        int[] nums = {2, 1, 5, 2, 3, 22, 5, 6};
        int[] nums = {2, 1, 2};

//        subsetsWithDup(nums);
    }

}
