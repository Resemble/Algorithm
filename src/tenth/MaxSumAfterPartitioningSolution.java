package tenth;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package tenth
 * @Description: 1043. 分隔数组以得到最大和
 * @date 2019-10-05 11:29
 */
public class MaxSumAfterPartitioningSolution {

    public int maxSumAfterPartitioning(int[] A, int K) {
        int[] maxSum = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            int tempMax = A[i];
            for (int j = i; i - j <= K - 1 && j >= 0; j--) {
                tempMax = Math.max(tempMax, A[j]);
                if (j == 0) {
                    maxSum[i] =  Math.max(tempMax * (i - j + 1), maxSum[i]);
                } else {
                    maxSum[i] =  Math.max(tempMax * (i - j + 1) + maxSum[j - 1], maxSum[i]);
                }
            }
        }
        return maxSum[A.length - 1];
    }

    public static void main(String[] args) {
        MaxSumAfterPartitioningSolution solution = new MaxSumAfterPartitioningSolution();
        int[] A = {1,15,7,9,2,5,10};
        int K = 3;
        System.out.println(solution.maxSumAfterPartitioning(A, K));
    }
}
