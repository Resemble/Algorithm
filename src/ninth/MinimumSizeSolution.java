package ninth;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package ninth
 * @Description:
 * @date 2019-06-08 10:21
 */
public class MinimumSizeSolution {

    /**
     * @param nums: an array of integers
     * @param s: An integer
     * @return: an integer representing the minimum size of subarray
     */
    public int minimumSize(int[] nums, int s) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int end = 0;
        int start = 0;
        int sum = 0;
        int res = Integer.MAX_VALUE;
        while (end < nums.length) {
            sum = sum + nums[end];
            if (sum >= s) {
//                res = Math.min(res, end - start + 1);
                while (sum >= s && start <= end) {
                    res = Math.min(res, end - start + 1);
                    sum = sum - nums[start];
                    start++;
                }
            }
            end++;
        }
        if (res == Integer.MAX_VALUE) {
            return -1;
        }
        return res;
    }

    public static void main(String[] args) {
        MinimumSizeSolution solution = new MinimumSizeSolution();
        int[] num = new int[] {2,3,1,2,4,3};
        System.out.println(solution.minimumSize(num, 7));
    }

}
