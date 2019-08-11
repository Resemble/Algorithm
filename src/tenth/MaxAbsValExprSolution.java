package tenth;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package tenth
 * @Description:
 * 给你两个长度相等的整数数组，返回下面表达式的最大值：
 *
 * |arr1[i] - arr1[j]| + |arr2[i] - arr2[j]| + |i - j|
 *
 * 其中下标 i，j 满足 0 <= i, j < arr1.length。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-of-absolute-value-expression
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 通过90%，超时，有数学解
 * @date 2019-08-11 16:36
 */
public class MaxAbsValExprSolution {

    public int maxAbsValExpr(int[] arr1, int[] arr2) {
        if (arr1 == null || arr2 == null || arr1.length == 1) {
            return 0;
        }
        int maxExpr = 0;
        int temp;
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1.length; j++) {
                temp = Math.abs(arr1[i] - arr1[j]) + Math.abs(arr2[i] - arr2[j]) + Math.abs(i - j);
                maxExpr = Math.max(maxExpr, temp);
            }
        }
        return maxExpr;
    }


}
