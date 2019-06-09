package tenth;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package tenth
 * @Description: 分割一个整数数组，使得奇数在前偶数在后。
 * @date 2019-06-09 11:50
 */
public class PartitionArraySolution {

    /*
     * @param nums: an array of integers
     * @return: nothing
     */
    public void partitionArray(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0 || nums.length == 1) {
            return;
        }
        int i = 0;
        int j = nums.length - 1;

        int temp;
        while (i < j) {
            while (nums[i] % 2 == 1) {
                i++;
            }
            while (nums[j] % 2 == 0) {
                j--;
            }
            if (i < j) {
                temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
    }

}
