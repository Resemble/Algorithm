package tenth;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package tenth
 * @Description:
 * @date 2019-06-29 17:01
 */
public class FindMaxConsecutiveOnesSolution {


    public int findMaxConsecutiveOnes(int[] nums) {
        int maxCount = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                count++;
                maxCount = Math.max(maxCount, count);
            } else if (nums[i] == 0 ){
                count = 0;
            }
        }
        return maxCount;
    }


}
