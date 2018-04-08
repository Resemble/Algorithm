package Seventh;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package Seventh
 * @Description:
 * @date 2018/4/8 上午9:38
 */
public class WordExist {

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, word, visited, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, boolean[][] visited, int i, int j, int index) {
        if (index == word.length()) {
            return true;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word
            .charAt(index) || visited[i][j])
            return false;
        visited[i][j] = true;
        boolean res = dfs(board, word, visited, i - 1, j, index + 1) ||
            dfs(board, word, visited, i + 1, j, index + 1) ||
            dfs(board, word, visited, i, j - 1, index + 1) ||
            dfs(board, word, visited, i, j + 1, index + 1);
        visited[i][j] = false;
        return res;
    }
}
