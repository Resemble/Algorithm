package Sixth;

import java.util.Scanner;

/**
 * @author ranran
 * @version V1.0
 * @Title:
 * @Package Sixth
 * @Description:
 * @date 2017/9/23 14:41
 */
public class WeiPinHui {

    public static void main(String[] args) {
        int[] arr = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int count = 0;
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int yy = sc.nextInt();
            int mm = sc.nextInt();
            int dd = sc.nextInt();

            for (int i = 0; i < mm - 1; i++) {
                count += arr[i];
            }
            count += dd;
            if(yy % 4 == 0 && mm > 2) {
                count += 1;
            }
            System.out.println(count);
            count = 0;
        }

    }

}
