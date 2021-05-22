package package12;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package package12
 * @Description: 缺失数字
 * @date 5/22/21 7:27 PM
 */
public class MissingNumberSolution {

    public int missingNumber(int[] nums) {
        int len = nums.length;
        int sum = (1 + len) * len / 2;
        for (int i = 0; i < len; i++) {
            sum = sum - nums[i];
        }
        return sum;
    }

}
