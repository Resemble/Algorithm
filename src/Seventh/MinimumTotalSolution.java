package Seventh;

import java.util.ArrayList;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package Seventh
 * @Description:
 * @date 2018/7/21 下午4:03
 */
public class MinimumTotalSolution {

    // 思路：从后往上
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }
        int[] dp = new int[triangle.size()];
        ArrayList<Integer> last = triangle.get(triangle.size() - 1);
        for (int i = 0; i < last.size(); i++) {
            dp[i] = last.get(i);
        }
        for (int i = triangle.size() - 2; i >= 0; i--) {
            ArrayList<Integer> currentList = triangle.get(i);
            for (int j = 0; j < currentList.size(); j++) {
                dp[j] = currentList.get(j) + Math.min(dp[j], dp[j + 1]);
            }
        }
        return dp[0];
    }


    public int minimumTotal2(ArrayList<ArrayList<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }
        ArrayList<Integer> last = triangle.get(triangle.size() - 1);
        int[][] dp = new int[triangle.size()][last.size()];
        for (int i = 0; i < last.size(); i++) {
            dp[triangle.size() - 1][i] = last.get(i);
        }
        for (int i = triangle.size() - 2; i >= 0; i--) {
            ArrayList<Integer> currentList = triangle.get(i);
            for (int j = 0; j < currentList.size(); j++) {
                dp[i][j] = Math.min(currentList.get(j) + dp[i + 1][j], currentList.get(j) + dp[i + 1][j + 1]);
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {

    }

}
