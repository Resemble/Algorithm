package ninth;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package ninth
 * @Description:
 * @date 2019-06-07 16:06
 */
public class SlidingWindowUniqueElementsSumSolution {

    /**
     * @param nums: the given array
     * @param k: the window size
     * @return: the sum of the count of unique elements in each window
     */
    public int slidingWindowUniqueElementsSum(int[] nums, int k) {
        // write your code here
        if (k <= 0) {
            return 0;
        } else if (k == 1) {
            return 1;
        } else if (k > nums.length) {
            k = nums.length;
        }

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
        }
        int[] numCount = new int[max + 1];
        int firstSingleCount = getFirstSingleNum(nums, k, numCount);
//        System.out.println(firstSingleCount);
        int sum = firstSingleCount;
        int beginIndex;
        int endIndex;
        int onceCount = firstSingleCount;
        for (int i = 1; i < nums.length; i++) {
            if (i + k - 1 < nums.length) {
                /* i + k 可以取到. */
                beginIndex = nums[i - 1];
                endIndex = nums[i + k - 1];
                if (numCount[beginIndex] == 1) {
                    onceCount = onceCount - 1;
                } else if (numCount[beginIndex] == 2) {
                    onceCount = onceCount + 1;
                }
                numCount[beginIndex] =  numCount[beginIndex] - 1;

                if (numCount[endIndex] == 0) {
                    onceCount = onceCount + 1;
                } else if (numCount[endIndex] == 1) {
                    onceCount = onceCount - 1;
                }
                numCount[endIndex] =  numCount[endIndex] + 1;
//                System.out.println(onceCount);
                sum = sum + onceCount;
            }
        }
        return sum;
    }


    public int getFirstSingleNum(int[] nums, int k, int[] numCount) {
        for (int i = 0; i < k; i++) {
            numCount[nums[i]] = numCount[nums[i]] + 1;
        }
        int firstSingleCount = 0;
        for (int i = 0; i < numCount.length; i++) {
            if (numCount[i] == 1) {
                firstSingleCount++;
            }
        }
        return firstSingleCount;
    }

    public static void main(String[] args) {
        int[] num = new int[] {1,1,1,1,1};
        SlidingWindowUniqueElementsSumSolution solution = new SlidingWindowUniqueElementsSumSolution();
        int result = solution.slidingWindowUniqueElementsSum(num, 2);
        System.out.println(result);
    }

}
