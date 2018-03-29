package Seventh;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package Seventh
 * @Description:
 * @date 2018/3/26 上午10:24
 */
public class SingleNumber2Solution {

    public int singleNumber(int[] A) {
        int ones = 0; // 记录只出现过1次的bits
        int twos = 0; // 记录只出现过2次的的bits
        int threes;
        for (int i = 0; i < A.length; i++) {
            int t = A[i];
            twos |= ones & t; // 要在更新ones前面更新twos
            ones ^= t;
            threes = ones & twos; // ones 和 twos 中都为1即出现3次
            ones &= ~threes;  // 抹去出现三次的bits
            twos &= ~threes;
        }
        return ones;
    }

}
