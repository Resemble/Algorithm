package Second;

import java.util.Scanner;

/**
 * @author ranran
 * @version V1.0
 * @Title:
 * @Package Second
 * @Description:
 * @date 2017/8/12 11:46
 */
public class Field {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int min = -1;
//        int[][] filedValue = new int[n][m];
        int value;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                value = sc.nextInt();
                if(value > min) {
                    min = value;
                }
            }
        }
        System.out.println(min);
    }

}
