package Sixth;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package Sixth
 * @Description:
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
 * 所有的偶数位于位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 * @date 2018/3/2 上午9:38
 */
public class ReOrderArraySolution {
    public void reOrderArray(int[] array) {
        int[] oddArray = new int[array.length];
        int[] evenArray = new int[array.length];
        int m = 0;
        int n = 0;
        for (int i = 0; i < array.length; i++) {
            if(array[i] % 2 == 1) {
                oddArray[m] = array[i];
                m++;
            } else {
                evenArray[n] = array[i];
                n++;
            }
        }
        for (int i = 0; i < m; i++) {
            array[i] = oddArray[i];
        }
        for (int i = 0; i < n; i++) {
            array[m + i] = evenArray[i];
        }
    }
}
