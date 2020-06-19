package package11;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package package11
 * @Description: 删除排序数组中的重复项
 * @date 2020-06-19 19:44
 */
public class RemoveDuplicatesSolution {

    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int idx = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                idx++;
                nums[idx] = nums[i];
            }
        }
        return idx + 1;
    }

}
