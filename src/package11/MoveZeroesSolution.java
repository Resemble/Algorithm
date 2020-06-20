package package11;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package package11
 * @Description: 283. 移动零
 * https://leetcode-cn.com/problems/move-zeroes/
 * @date 2020-06-20 17:43
 */
public class MoveZeroesSolution {

    public void moveZeroes(int[] nums) {
        for (int p = 0, i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[p];
                nums[p] = temp;
                p++;
            }
        }
    }


    public void moveZeroes2(int[] nums) {
        int i = 0;
        int j = 0;
        while (i < nums.length && j < nums.length) {
            while (nums[j] == 0) {
                j++;
                if (j >= nums.length) {
                    return;
                }
            }
            while (nums[i] != 0) {
                i++;
                if (i >= nums.length) {
                    return;
                }
            }
            if (i < j) {
                swap(nums, i, j);
                j++;
                i++;
            } else {
                j++;
            }
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
