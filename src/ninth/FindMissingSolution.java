package ninth;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package ninth
 * @Description:
 * @date 2019-05-12 21:38
 */
public class FindMissingSolution {


    /**
     * @param nums: An array of integers
     * @return: An integer
     */
    public static int findMissing(int[] nums) {
        // write your code here
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result = result ^ i ^ nums[i];
        }
        result = result ^ nums.length;
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 3};
        System.out.println(findMissing(nums));
    }
}
