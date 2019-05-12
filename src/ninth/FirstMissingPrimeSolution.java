package ninth;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package ninth
 * @Description:
 * @date 2019-05-12 23:41
 */
public class FirstMissingPrimeSolution {


    public boolean bPrime(int num) {
        for (int i = 2; ; i++) {
            if (i * i > num) {
                return true;
            }
            if (num % i == 0) {
                return false;
            }
        }
    }

    /**
     * @param nums: an array of integer
     * @return: the first missing prime number
     */
    public int firstMissingPrime(int[] nums) {
        // write your code here
        int pos = 0;
        for (int i = 2; ; i++) {
            if (bPrime((i))) {
                if (pos == nums.length) {
                    return i;
                }
                if (nums[pos] == i) {
                    pos++;
                } else {
                    return i;
                }
            }
        }

    }


}
