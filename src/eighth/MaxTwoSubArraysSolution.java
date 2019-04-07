package eighth;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package eighth
 * @Description:
 * @date 2019/4/6 8:54 PM
 */
public class MaxTwoSubArraysSolution {

    /*
     * @param nums: A list of integers
     * @return: An integer denotes the sum of max two non-overlapping subarrays
     */
    public int maxTwoSubArrays(List<Integer> nums) {
        // write your code here
        int size = nums.size();
        int[] left = new int[size];
        int[] right = new int[size];
        int sum = 0;
        int minSum = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < size; i++) {
            sum = sum + nums.get(i);
            max = Math.max(max, sum - minSum);
            minSum = Math.min(sum, minSum);
            left[i] = max;
        }
        sum = 0;
        minSum = 0;
        max = Integer.MIN_VALUE;
        for (int i = size - 1; i >= 0; i--) {
            sum = sum + nums.get(i);
            max = Math.max(max, sum - minSum);
            minSum = Math.min(sum, minSum);
            right[i] = max;
        }
        max = Integer.MIN_VALUE;
        for (int i = 0; i < size - 1; i++) {
            max = Math.max(max, left[i] + right[i + 1]);
        }
        return max;
    }

    public static void main(String[] args) {
        MaxTwoSubArraysSolution subArraysSolution = new MaxTwoSubArraysSolution();

//        List<Integer> list = new ArrayList<>(Arrays.asList(1, 3, -1, 2, -1, 2));
        List<Integer> list = new ArrayList<>(Arrays.asList(0, -1));

        int sum = subArraysSolution.maxTwoSubArrays(list);
        System.out.println(sum);
    }

}
