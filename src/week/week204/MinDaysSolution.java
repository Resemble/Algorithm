package week.week204;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package week.week204
 * @Description:
 * @date 2020-08-30 11:28
 */
public class MinDaysSolution {

    int[] d = new int[]{0, -1, 0, 1, 0};

    public int minDays(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        if (calIslandCnt(grid, m, n) != 1) {
            return 0;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    grid[i][j] = 0;
                    if (calIslandCnt(grid, m, n) != 1) {
                        return 1;
                    }
                    grid[i][j] = 1;
                }
            }
        }
        return 2;
    }

    private int calIslandCnt(int[][] grid, int m, int n) {
        boolean[][] visit = new boolean[m][n];
        int cntIsland = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !visit[i][j]) {
                    cntIsland++;
                    dfs(grid, visit, m, n, i, j);
                }
            }
        }
        return cntIsland;
    }

    private void dfs(int[][] grid, boolean[][] visit, int m, int n, int x, int y) {
        visit[x][y] = true;
        // {0, -1, 0, 1, 0}
        for (int i = 0; i < 4; i++) {
            int nx = x + d[i];
            int ny = y + d[i + 1];
            if (nx >= 0 && nx < m  && ny >= 0 && ny < n && grid[nx][ny] == 1 && !visit[nx][ny]) {
                dfs(grid, visit, m, n, nx, ny);
            }
        }
    }

}
