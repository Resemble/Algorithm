package Seventh;

import java.util.Scanner;

/**
 * @author ranran
 * @version V1.0
 * @Title:
 * @Package Seventh
 * @Description: 约数个数
 * @date 2018/4/1 10:10
 */
public class ApproximatelySolution {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = 0;
        for (int i = 0; i < n; i++) {
            int nextInt = sc.nextInt();
            int sqrtInt = (int) Math.sqrt(nextInt);
            for (int j = 1; j <= sqrtInt; j++) {
                if(nextInt % j == 0) {
                    count++;
                }
            }
            count = count * 2;
            if(nextInt == sqrtInt * sqrtInt) {
                count--;
            }
            System.out.println(count);
            count = 0;
        }
        sc.close();
    }

}
