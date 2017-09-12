package Fivth;

import java.util.Scanner;

/**
 * @author ranran
 * @version V1.0
 * @Title:
 * @Package Fivth
 * @Description:
 * 小Q和牛博士合唱一首歌曲,这首歌曲由n个音调组成,每个音调由一个正整数表示。
 * 对于每个音调要么由小Q演唱要么由牛博士演唱,对于一系列音调演唱的难度等于所有相邻音调变化幅度之和, 例如一个音调序列是8, 8, 13, 12, 那么它的难度等于|8 - 8| + |13 - 8| + |12 - 13| = 6(其中||表示绝对值)。
 * 现在要对把这n个音调分配给小Q或牛博士,让他们演唱的难度之和最小,请你算算最小的难度和是多少。
 * 如样例所示: 小Q选择演唱{5, 6}难度为1, 牛博士选择演唱{1, 2, 1}难度为2,难度之和为3,这一个是最小难度和的方案了。
 * 输入描述:
 * 输入包括两行,第一行一个正整数n(1 ≤ n ≤ 2000) 第二行n个整数v[i](1 ≤ v[i] ≤ 10^6), 表示每个音调。
 * 输出描述:
 * 输出一个整数,表示小Q和牛博士演唱最小的难度和是多少。
 * 示例1
 * 输入
 * 5
 * 1 5 6 2 1
 * 输出
 * 3
 *
 * 动态规划题
 * dp[i][j]（永远有i > j）表示某一个人最近唱的音为第i个，另一个人最近唱的是第j个时最小的难度
 * 由于只由一个人唱完肯定不是最优解。因此先在一个for循环内确定以下两种情况的初值
 * dp[i][0]：第二个人唱第一个音，第一个人唱后面所有音
 * dp[i][i-1]：第一个人唱最近的一个音，第二个人唱前面所有音
 * dp[i][j]转移方程
 * 每当交换唱歌次序，两人最近一次唱的音符一定是相邻的，所以底下分相邻和不相邻讨论：
 * (1). 当j == i - 1，即交换唱歌次序，dp[i][i-1]时，表明第一个人原本可能在第k个音（0 <= k < i-1）,由唱了最近的第i个，第二个人仍然留在第i-1个音。
 * dp[i][i-1] = 对所有k求min(dp[i-1][k] + abs(arr[i] - arr[k]) ) 其中（0 <= k < i-1）
 * (2). 当j < i - 1，即不交换唱歌次序时，只可能由唱到i-1音符的人续唱
 * dp[i][j] = dp[i-1][j] + abs(arr[i] - arr[i-1])
 * 最后求出所有dp[len-1][]里的最小值即为全局最优解
 * @date 2017/9/11 16:04
 */
public class MinDifficultySum {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        if (n < 3) {
            System.out.println(0);
        } else {
            int[][] dp = new int[n][n];
            int[] acc = new int[n];
            dp[0][0] = 0 - Math.abs(arr[1] - arr[0]);
            for (int i = 1; i < n; i++) {
                acc[i] = acc[i - 1] + Math.abs(arr[i] - arr[i - 1]);
                dp[i][i - 1] = acc[i - 1];
                for (int j = 0; j < i - 1; j++) {
                    dp[i][j] = dp[i - 1][j] + acc[i] - acc[i - 1];
                    dp[i][i - 1] = Math.min(dp[i][i - 1], dp[i - 1][j] + Math.abs(arr[i] - arr[j]));

                }
            }
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < n - 1; i++) {
                min = Math.min(min, dp[n - 1][i]);
            }
            System.out.println(min);
        }
    }

}
