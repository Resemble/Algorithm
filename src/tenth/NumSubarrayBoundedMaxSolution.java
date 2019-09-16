package tenth;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package tenth
 * @Description: 795. 区间子数组个数
 * @date 2019-09-16 23:17
 */
public class NumSubarrayBoundedMaxSolution {

    /** 最大元素满足大于等于L小于等于R的子数组个数 = 最大元素小于等于R的子数组个数 - 最大元素小于L的子数组个数 */
    public int numSubarrayBoundedMax(int[] A, int L, int R) {
        return numSubarrayBoundedMax(A, R) - numSubarrayBoundedMax(A, L - 1);
    }

    /** 子数组个数 数学解 1 + 2 + 3 + 4... */
    public int numSubarrayBoundedMax(int[] A, int max) {
        int res = 0;
        int subArray = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] <= max) {
                subArray++;
                res = res + subArray;
            } else {
                subArray = 0;
            }
        }
        return res;
    }

}
