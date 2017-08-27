package Third;

import java.util.Scanner;

/**
 * @author ranran
 * @version V1.0
 * @Title:
 * @Package Third
 * @Description:
 * @date 2017/8/26 20:39
 */
public class Third360 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] array1 = new int[n];
        int[] array2 = new int[m];
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i < n; i++) {
            array1[i] = sc.nextInt();
            sum1 += array1[i];
        }
        for (int i = 0; i < m; i++) {
            array2[i] = sc.nextInt();
            sum2 += array2[i];
        }
        int sub = sum1 - sum2;

        int[][] temp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                temp[i][j] = array1[i] - array2[j];
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                min = Math.min(min, Math.abs(sub - 2* temp[i][j]));
                if (min == 0) {
                    System.out.println(0);
                    return;
                }
            }
        }
        // 对二维数组排序，找到相加最接近 sub 的
        int[] sortArray = new int[m * n];
        int count = 0;
        // 2个for循环确定一个点，找2个点
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < n; k++) {
                    for (int l = 0; l < m; l++) {
                        if (k != i && l != j) {
                            min = Math.min(min, Math.abs(sub - 2*(temp[i][j] + temp[k][l])));
                        }
                     }
                }
            }
        }

        System.out.println(min);
    }



}
