package First;

/**
 * @author ranran
 * @version V1.0
 * @Title:
 * @Package First
 * @Description: 给定一个整数数组，找到一个具有最大和的子数组，返回其最大和。
 * @date 2017/8/1 8:31
 */
public class MaxSubArrayTest1 {

    public static int maxSubArraySum(int[] array) {
        int length = array.length;
        //
        int maxSum = array[0];
        int allMaxSum = array[0];
        for (int i = 1; i < length; i++) {
            // 6 -9 4 3
            // maxSum 记录临时值 6 4 7
            maxSum = Math.max(array[i] + maxSum, array[i]);
            // allMaxSum 记录最大值 6 7
            allMaxSum = Math.max(maxSum, allMaxSum);
        }
        return allMaxSum;
    }

    public static void main(String[] args) {
        int[] array = {1, -2, 54, -34, 4, 43, 2, -34, 54};
        System.out.println(maxSubArraySum(array));
    }

}
