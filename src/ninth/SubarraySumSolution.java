package ninth;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package ninth
 * @Description:
 * @date 2019-05-18 17:35
 */
public class SubarraySumSolution {

    /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number and the index of the last number
     */
    public List<Integer> subarraySum(int[] nums) {
        // write your code here
        List<Integer> result = new ArrayList<>();

        if (nums == null) {
            return result;
        }
        int tempSum = 0;
        int i = 0;
        int j = 0;
        for (i = 0; i < nums.length; i++) {
            tempSum = nums[i];
            if (tempSum == 0) {
                result.add(i);
                result.add(i);
                return result;
            }
            for (j = i + 1; j < nums.length; j++) {
                tempSum = tempSum + nums[j];
                if (tempSum == 0) {
                    break;
                }
            }
            if (tempSum == 0) {
                break;
            }
        }
        result.add(i);
        result.add(j);
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {-3,1,2,-3,4};
        SubarraySumSolution solution = new SubarraySumSolution();
        List<Integer> result = solution.subarraySum(nums);
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }
}
