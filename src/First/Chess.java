package First;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author ranran
 * @version V1.0
 * @Title:
 * @Package First
 * @Description:
 *
 * 小易将n个棋子摆放在一张无限大的棋盘上。第i个棋子放在第x[i]行y[i]列。同一个格子允许放置多个棋子。每一次操作小易可以把一个棋子
 * 拿起并将其移动到原格子的上、下、左、右的任意一个格子中。小易想知道要让棋盘上出现有一个格子中至少有i(1 ≤ i ≤ n)个棋子所需要的最少操作次数.
 * 堆棋子
 * 分析
 * 对于一个k,我们找一个坐标(x, y)让k个棋子距离这个坐标的曼哈顿距离之和最小。注意到x和y其实是独立的,考虑枚举棋盘上所有可能得坐标(x[i], y[j]),计算这个坐标到所有棋子的距离分别是多少,然后维护k个棋子对于这个坐标最小曼哈顿距离和即可。
 * @date 2017/8/12 19:23
 */
public class Chess {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] xi = new int[n];
        int[] yi = new int[n];


        for (int i = 0; i < n; i++) {
            xi[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            yi[i] = sc.nextInt();
        }
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    int[] res2 = new int[n];
                    for (int l = 0; l < n; l++) {

                        res2[l] = Math.abs(xi[l] - xi[j]) + Math.abs(yi[l] - yi[k]);
                    }
                    Arrays.sort(res2);
                    int res3 = 0;
                    for (int l = 0; l < i + 1; l++) {
                        res3 += res2[l];
                    }
                    res[i] = Math.min(res[i], res3);
                }
            }

        }

        for (int i = 0; i < n; i++) {
            if (i == 0) {
                System.out.print(res[i]);
            } else {
                System.out.print(" " + res[i]);
            }
        }
    }
}
