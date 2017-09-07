package Forth;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author ranran
 * @version V1.0
 * @Title:
 * @Package Forth
 * @Description:
 * @date 2017/9/7 11:45
 */
public class AtLeastQuestion {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }
        if (n == 0) {
            System.out.println(3);
            return;
        } else if (n == 1) {
            System.out.println(2);
            return;
        } else if (n == 2) {
            int sub = Math.abs(array[1] - array[0]);
            int tempNum = sub / 10;
            int temp2 = (tempNum + n) % 3;
            if (temp2 == 0) {
                System.out.println(tempNum);
                return;
            } else {
                System.out.println(3- temp2 + tempNum);
                return;
            }
        }
        Arrays.sort(array);
        int atLeastAdd = n % 3;
        int count = 0;
        for (int i = 0; i < n - 2; i+=3) {
            int sub1 = array[i + 1] - array[i];
            int sub2 = array[i + 2] - array[i + 1];
        }

    }

}
