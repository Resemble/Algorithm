package Fivth;

import java.util.Scanner;

/**
 * @author ranran
 * @version V1.0
 * @Title:
 * @Package Fivth
 * @Description:
 * @date 2017/9/19 19:57
 */
public class XunLei2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();

        int[][] cache = new int[n + 1][m + 1];
        System.out.println(solve(n, m, cache));
    }

    private static int solve(int target, int idx, int[][] cache) {

        if (target == 0) {
            return 1;
        }

        if (idx == 0 || target < 0) {
            return 0;
        }

        if (cache[target][idx] != 0) {
            return cache[target][idx];
        }

        int res = 0;
        res += solve(target, idx - 1, cache);
        res += solve(target - idx, idx - 1, cache);
        cache[target][idx] = res;

        return res;
    }


}
