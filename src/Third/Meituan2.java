package Third;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author ranran
 * @version V1.0
 * @Title:
 * @Package Third
 * @Description:
 * @date 2017/8/31 20:47
 */
public class Meituan2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }
        Arrays.sort(array);
        int sum = 0;
        for (int i = 0; i < n - 1; i++) {
            sum += array[i];
        }
        if (array[n-1] > sum) {
            System.out.println("No");
            return;
        }


//        System.out.println("No");
        System.out.println("Yes");
    }
}
