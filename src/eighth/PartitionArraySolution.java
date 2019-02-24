package eighth;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package eighth
 * @Description:
 * @date 2019/2/24 3:40 PM
 */
public class PartitionArraySolution {

    /**
     * @param nums: The integer array you should partition
     * @param k: An integer
     * @return: The index after partition
     */
    public int partitionArray(int[] nums, int k) {
        // write your code here
        if (nums.length == 0) return 0;
        int leftSize = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < k) {
                leftSize++;
            }
        }
        return leftSize;
    }


}
