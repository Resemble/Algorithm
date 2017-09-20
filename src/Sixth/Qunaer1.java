package Sixth;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author ranran
 * @version V1.0
 * @Title:
 * @Package Sixth
 * @Description:
 * @date 2017/9/20 9:05
 */
public class Qunaer1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String string = sc.nextLine().replace(" ", "");
        int n = sc.nextInt();
        char[] chars = string.toCharArray();
        Arrays.sort(chars);
        for (int i = 0; i < n - 1; i++) {
            System.out.print(chars[i] + " ");
        }
        System.out.println(chars[n - 1]);

        for (int i = 0; i < n - 1; i++) {
            System.out.print(chars[chars.length - i - 1] + " ");
        }
        System.out.println(chars[chars.length - n]);
    }


}
