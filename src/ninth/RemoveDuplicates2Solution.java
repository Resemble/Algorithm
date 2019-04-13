package ninth;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package ninth
 * @Description:
 * @date 2019/4/13 10:18 AM
 */
public class RemoveDuplicates2Solution {

    /**
     * @param A: a array of integers
     * @return : return an integer
     */
    public int removeDuplicates(int[] nums) {
        // write your code here
        // write your code here
        if (nums.length <= 2) {
            return nums.length;
        }
        int slowIndex = 0;
        int midIndex = 1;
        for (int i = 2; i < nums.length; i++) {
            if (nums[slowIndex] == nums[midIndex] && nums[midIndex] == nums[i]) {
            } else {
                slowIndex++;
                midIndex++;
                nums[midIndex] = nums[i];
            }
        }
        return midIndex + 1;
    }

}
