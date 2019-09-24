package tenth;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package tenth
 * @Description: 926. 将字符串翻转到单调递增
 * https://leetcode-cn.com/problems/flip-string-to-monotone-increasing/comments/
 * @date 2019-09-23 23:16
 */
public class MinFlipsMonoIncrSolution {

    public int minFlipsMonoIncr(String S) {
        int zero = 0;
        int one = 0;
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '1') {
                one = Math.min(zero, one);
                zero++;
            } else {
                one = Math.min(zero, one) + 1;
            }
        }
        return Math.min(zero, one);
    }


}
