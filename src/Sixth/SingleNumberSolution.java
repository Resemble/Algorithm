package Sixth;

/**
 * @author ranran
 * @version V1.0
 * @Title:
 * @Package Sixth
 * @Description:
 * @date 2018/2/28 22:16
 */
public class SingleNumberSolution {
    public int singleNumber(int[] A) {
        int val = 0;
        for (int i = 0; i < A.length; i++) {
            val ^= A[i];
        }
        return val;
    }
}
