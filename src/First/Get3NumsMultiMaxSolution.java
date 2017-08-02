package First;

import java.util.Scanner;

/**
 * @author ranran
 * @version V1.0
 * @Title:
 * @Package First
 * @Description: 数组中取三个数相乘最大
 * @date 2017/8/1 20:44
 */
public class Get3NumsMultiMaxSolution {

    public static long getMax(long[] array) {
        long max1 = Long.MIN_VALUE;
        long max2 = Long.MIN_VALUE;
        long max3 = Long.MIN_VALUE;
        long min1 = Long.MAX_VALUE;
        long min2 = Long.MAX_VALUE;

        for (int i = 0; i < array.length; i++) {
            if (max1 < array[i]) {
                max3 = max2;
                max2 = max1;
                max1 = array[i];
            } else if (max2 < array[i]) {
                max3 = max2;
                max2 = array[i];
            } else if (max3 < array[i]) {
                max3 = array[i];
            }
            if (min1 > array[i]) {
                min2 = min1;
                min1 = array[i];
            } else if (min2 > array[i]) {
                min2 = array[i];
            }
        }

        return Math.max(max1 * max2 * max3, max1 * min1 * min2);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        long[] array = new long[length];
        for (int i = 0; i < length; i++) {
            array[i] = sc.nextInt();
        }
        long result = getMax(array);
        System.out.print(result);

    }


}





