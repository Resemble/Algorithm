package Third;

import java.util.Scanner;

/**
 * @author ranran
 * @version V1.0
 * @Title:
 * @Package Third
 * @Description:
 * @date 2017/8/31 20:11
 */
public class MeiTuan1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] array = new int[n];
        int[] sum = new int[n+1];
        sum[0] = 0;

        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
            sum[i+1] = sum[i] + array[i];
        }
        int k = sc.nextInt();
        if (n==0) {
            System.out.println(0);
            return;
        }
        int maxLength = 0;
        for (int i = 0; i < n + 1; i++) {
            if ((n-i) < maxLength) break;
            for (int j = n; j > i; j--) {
                if ((sum[j] - sum[i]) % k == 0) {
                    maxLength = Math.max(maxLength, j - i);
                    break;
                }
            }
        }
        System.out.println(maxLength);
    }


}
