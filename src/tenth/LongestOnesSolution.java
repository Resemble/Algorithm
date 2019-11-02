package tenth;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package tenth
 * @Description: 1004. 最大连续1的个数 III
 * 思路：
 * 使用双指针 left 和 right 指代窗口的左右边界，移动 right 指针遍历整个数组，
 * 同时维护一个变量 max，每次 right 移动计算一次当前的最大值。
 *
 * 分析：
 *
 * 分为以下几种情况：
 *
 * 当 A[right] = 1 时，left 不变，right 继续移动
 * 当 A[right] = 0 时，
 * 0 的数量在 K 的范围内，left 不变，right 继续移动
 * 0 的数量 > K，
 * 当 A[left] == 0 时，即 left 指向了一个零，只需要 left 右移一格，就可以减少一个零
 * 当 A[left] == 1 时，即此时窗口内包了 K 个零，需要先移动至下个零，再右移一格才能减少一个零
 * @date 2019-11-02 10:32
 */
public class LongestOnesSolution {

    public int longestOnes(int[] A, int K) {
        int max = 0;
        for (int left = 0 , right = 0; right < A.length; right++) {
            if (A[right] == 0) {
                if (K == 0) {
                    while (A[left] == 1) {
                        left++;
                    }
                    left++;
                } else {
                    K--;
                }
            }
            max = Math.max(right - left + 1, max);
        }
        return max;
    }



    public static void main(String[] args) {
        int[] A = {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
//        System.out.println("A[10]" + A[10]);
        System.out.println("A.length:" + A.length);
        int K = 3;
        LongestOnesSolution solution = new LongestOnesSolution();
        System.out.println(solution.longestOnes(A, K));

    }

}
