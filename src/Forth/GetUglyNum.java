package Forth;

/**
 * @author ranran
 * @version V1.0
 * @Title:
 * @Package Forth
 * @Description:
 * 把只包含因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，因为它包含因子7。
 * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 * @date 2017/9/3 22:15
 */
public class GetUglyNum {

    public static void main(String[] args) {
//        System.out.println(getUglyNumberSolution(1));
//        System.out.println(getUglyNumberSolution(2));
//        System.out.println(getUglyNumberSolution(3));
//        System.out.println(getUglyNumberSolution(4));
        System.out.println(getUglyNumberSolution(11));
    }

    public static int getUglyNumberSolution(int index) {
        if(index <= 0) return 0;
        if(index == 1) return 1;
        int num2 = 0;
        int num3 = 0;
        int num5 = 0;
        int[] result = new int[index];
        result[0] = 1;
        // 该思路： 我们只用比较3个数：用于乘2的最小的数、用于乘3的最小的数，用于乘5的最小的
        for (int i = 1; i < index; i++) {
            result[i] = Math.min(result[num2] * 2, Math.min(result[num3] * 3, result[num5] * 5));
            if (result[i] == result[num2] * 2) num2++;
            if (result[i] == result[num3] * 3) num3++;
            if (result[i] == result[num5] * 5) num5++;
        }
        return result[index - 1];
    }


}
