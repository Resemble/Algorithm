package Fivth;

import java.util.List;

/**
 * @author ranran
 * @version V1.0
 * @Title:
 * @Package Fivth
 * @Description: 给定一个整型数组，找到主元素，它在数组中的出现次数严格大于数组元素个数的三分之一。
 * @date 2017/9/13 11:32
 */
public class MajorityNumberSolution {

    public int majorityNumber(List<Integer> nums) {
        // write your code here
        int a = Integer.MIN_VALUE;
        int countA = 0;
        int b = Integer.MIN_VALUE;
        int countB = 0;
        int value;
        for(int i = 0; i < nums.size(); i++) {
            value = nums.get(i);
            if (value == a) {
                countA++;
            } else if (value == b) {
                countB++;
            } else if (countA == 0) {
                a = value;
                countA++;
            } else if (countB == 0) {
                b = value;
                countB++;
            } else {
                countA--;
                countB--;
            }
        }
        countA = 0;
        countB = 0;
        for(int i = 0; i < nums.size(); i++) {
            value = nums.get(i);
            if (value == a) {
                countA++;
            } else if (value == b) {
                countB++;
            }
        }
        return countA > countB ? a : b;
    }

}
