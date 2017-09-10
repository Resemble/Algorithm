package Fivth;

import java.util.Scanner;

/**
 * @author ranran
 * @version V1.0
 * @Title:
 * @Package Fivth
 * @Description:
 * @date 2017/9/10 19:54
 */
public class TouTiao2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }
        int q = sc.nextInt();
        int[][] num = new int[q][3];
        for (int i = 0; i < q; i++) {
            num[i][0] = sc.nextInt();
            num[i][1] = sc.nextInt();
            num[i][2] = sc.nextInt();
        }
        for (int i = 0; i < q; i++) {
            int count = 0;
            for (int j = num[i][0]; j <= num[i][1]; j++) {
                if (array[j - 1] == num[i][2]) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }

}
