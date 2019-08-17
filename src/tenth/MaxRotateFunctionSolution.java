package tenth;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package tenth
 * @Description:
 * @date 2019-08-17 11:33
 */
public class MaxRotateFunctionSolution {

    public int maxRotateFunction(int[] A) {
        int n = A.length;
        long sum = 0;
        long res = 0;
        long max = Long.MIN_VALUE;
        for (int i = 0; i < A.length; i++) {
            res = res + A[i] * i;
            sum = sum + A[i];
        }
        for (int i = 0; i < A.length; i++) {
            res = res + n * A[i] - sum;
            max = Math.max(max,  res);
        }
        return (int) max;
    }

}
