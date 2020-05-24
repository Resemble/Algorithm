package package11;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package package11
 * @Description: 不同路径
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/51/dynamic-programming/105/
 * @date 2020-05-24 22:49
 */
public class UniquePathsSolution {

    public int uniquePaths(int m, int n) {
        int[][] pathCnt = new int[m][n];
        for (int i = 0; i < m; i++) {
            pathCnt[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            pathCnt[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                pathCnt[i][j] = pathCnt[i][j - 1] + pathCnt[i - 1][j];
            }
        }
        return pathCnt[m - 1][n - 1];
    }

}
