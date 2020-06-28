package package11;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package package11
 * @Description: 326. 3的幂
 * https://leetcode-cn.com/problems/power-of-three/
 * @date 2020-06-28 11:55
 */
public class IsPowerOfThreeSolution {

    public boolean isPowerOfThree2(int n) {
        if (n <= 0) {
            return false;
        }
        while (n != 1) {
            if (n % 3 != 0) {
                return false;
            }
            n = n / 3;
        }
        return true;
    }

    // 3的幂次的质因子只有3，而所给出的n如果也是3的幂次，故而题目中所给整数范围内最大的3的幂次的因子只能是3的幂次，1162261467是3的19次幂，是整数范围内最大的3的幂次
    public boolean isPowerOfThree(int n) {
        return n > 0 && 1162261467 % n == 0;
    }

}
