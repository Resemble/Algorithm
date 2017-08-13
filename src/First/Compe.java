package First;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author ranran
 * @version V1.0
 * @Title:
 * @Package First
 * @Description:
 * @date 2017/8/12 16:03
 */
public class Compe {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] xi = new int[n];
        int[] yi = new int[n];

        int[][] distance = new int[n][n];

        for (int i = 0; i < n; i++) {
            xi[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            yi[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                distance[i][j] = Math.abs(xi[i] - xi[j]) + Math.abs(yi[i] - yi[j]);
            }
        }
        int[][] maxDistance = new int[n][n];
        for (int i = 0; i < n; i++) {
            getMaxDistance(distance[i], n, maxDistance, i);
        }

        int small = 99999;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (small > maxDistance[j][i]) {
                    small = maxDistance[j][i];
                }
            }
            if (i == n -1) {
                System.out.print(small);
            } else {
                System.out.print(small + " ");
            }
            small = 99999;
        }


    }

    public static void getMaxDistance(int[] distance, int n, int[][] maxDistance, int num) {
        Arrays.sort(distance);
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += distance[i];
            maxDistance[num][i] = sum;
        }
    }


}
