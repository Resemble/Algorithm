package package11;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package package11
 * @Description: 爬楼梯
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/23/dynamic-programming/54/
 * @date 2020-05-24 16:14
 */
public class ClimbStairsSolution {

    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        } else if (n <= 0) {
            return 0;
        }
        int[] result = new int[n];
        result[0] = 1;
        result[1] = 2;
        for (int i = 2; i < n; i++) {
            result[i] = result[i - 1] + result[i - 2];
        }
        return result[n - 1];
    }

}
