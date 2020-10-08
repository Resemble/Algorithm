package package12;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package package12
 * @Description:
 * @date 2020-10-08 16:56
 */
public class TwoSumSolution {

    public int[] twoSum(int[] numbers, int target) {
        int low = 0;
        int high = numbers.length - 1;
        while (low < high) {
            int tempSum = numbers[low] + numbers[high];
            if (tempSum == target) {
                return new int[] {low + 1, high + 1};
            } else if (tempSum < target) {
                low++;
            } else {
                high--;
            }
        }
        return new int[] {-1, -1};
    }

}
