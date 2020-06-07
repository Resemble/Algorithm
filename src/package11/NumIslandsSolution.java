package package11;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package package11
 * @Description: 200. 岛屿数量
 * https://leetcode-cn.com/problems/number-of-islands/
 * @date 2020-06-07 10:55
 */
public class NumIslandsSolution {

    public int numIslands(char[][] grid) {
        int cnt = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    // 搜索
                    search(grid, i, j);
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public void search(char[][] grid, int i, int j) {
        if (grid[i][j] == '1') {
            grid[i][j] = '2';
        } else {
            return;
        }
        if (i > 0) {
            search(grid, i - 1, j);
        }
        if (j > 0) {
            search(grid, i, j - 1);
        }
        if (i < grid.length - 1) {
            search(grid, i + 1, j);
        }
        if (j < grid[i].length - 1) {
            search(grid, i, j + 1);
        }
    }

    public void testModify(char[][] grid) {
        grid[0][0] = 'e';
    }

    public static void main(String[] args) {
        NumIslandsSolution solution = new NumIslandsSolution();
        char[][] grid = new char[1][5];
        grid[0][0] = '1';
        grid[0][1] = '1';
        grid[0][2] = '1';
        grid[0][3] = '1';
        grid[0][4] = '0';
        solution.numIslands(grid);
//        solution.search(grid, 0, 0);
//        System.out.println(grid[0][0]);
//        solution.testModify(grid);
//        System.out.println(grid[0][0]);

    }

}
