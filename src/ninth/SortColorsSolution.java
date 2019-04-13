package ninth;



/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package ninth
 * @Description: https://www.lintcode.com/problem/sort-colors/description
 * @date 2019/4/13 11:41 AM
 */
public class SortColorsSolution {

    /**
     * @param nums: A list of integer which is 0, 1 or 2
     * @return: nothing
     */
    public void sortColors(int[] nums) {
        // write your code here
        int redIndex = 0;
        int blueIndex = nums.length - 1;
        for (int i = 0; i <= blueIndex; i++) {
            if (nums[i] == 0) {
                swap(nums, redIndex, i);
                redIndex++;
            } else if (nums[i] == 2) {
                swap(nums, blueIndex, i);
                i--;
                blueIndex--;
            }
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        SortColorsSolution sortColorsSulution = new SortColorsSolution();
        int[] nums = {2,0,0,1,0,2,2};
        sortColorsSulution.sortColors(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

}
