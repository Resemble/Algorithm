package Seventh;

import java.util.Scanner;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package Seventh
 * @Description:
 * @date 2018/11/4 11:09 AM
 */
public class ZeroCntSolution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int cnt = 0;
        while (n > 1) {
            cnt += n / 5;
            n = n / 5;
        }
        System.out.println(cnt);
    }

}
