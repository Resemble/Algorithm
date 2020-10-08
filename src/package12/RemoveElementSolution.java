package package12;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package package12
 * @Description:
 * @date 2020-10-08 16:38
 */
public class RemoveElementSolution {

    public int removeElement(int[] nums, int val) {
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                cnt++;
            } else {
                nums[i - cnt] = nums[i];
            }
        }
        return nums.length - cnt;
    }

}
