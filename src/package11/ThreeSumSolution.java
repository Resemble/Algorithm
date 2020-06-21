package package11;

import java.util.*;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package package11
 * @Description: 15. 三数之和
 * https://leetcode-cn.com/problems/3sum/
 * @date 2020-06-21 15:46
 */
public class ThreeSumSolution {

    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> threeSum(int[] nums) {
        // 排序
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i >= 1 && nums[i] == nums[i-1]) {
                continue;
            }
            // 转化为 2sum
            twoSum(nums, -nums[i], i + 1, nums.length - 1);
        }
        return result;
    }


    // 关键是数据有序，利用双指针，开始和结束指针进行遍历
    public void twoSum(int[] nums, int target, int start, int end) {
        while (start < end) {
            if (nums[start] + nums[end] == target) {
                List<Integer> res = new ArrayList<>();
                res.add(-target);
                res.add(nums[start]);
                res.add(nums[end]);
                result.add(res);
                while (start < end && nums[start + 1] == nums[start]) {
                    start++;
                }
                while (start < end && nums[end - 1] == nums[end]) {
                    end--;
                }
                start++;
                end--;
            } else if (nums[start] + nums[end] < target) {
                start++;
            } else {
                end--;
            }
        }
    }

}
