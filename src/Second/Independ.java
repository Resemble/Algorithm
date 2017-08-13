package Second;

import java.util.Scanner;

/**
 * @author ranran
 * @version V1.0
 * @Title:
 * @Package Second
 * @Description:
 * @date 2017/8/12 15:33
 */
public class Independ {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String string = sc.nextLine();
        String[] stringsList = string.split(" ");
        int x = Integer.parseInt(stringsList[0]);
        int f = Integer.parseInt(stringsList[1]);
        int d = Integer.parseInt(stringsList[2]);
        int p = Integer.parseInt(stringsList[3]);
        int m = 0; // 天数

        if (d < x) {
            System.out.println(0);
            return;
        }
        while (m <= f) {
            if (x * m >= d) {
                System.out.println(m);
                return;
            }
            m++;
        }
        while ((x * m + (m - f) * p) <= d) {
            m++;
        }
        m--;
        System.out.println(m);


    }

}
