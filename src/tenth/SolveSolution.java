package tenth;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package tenth
 * @Description: 反向思维考察
 * @date 2019-08-11 10:19
 */
public class SolveSolution {

    public static void solve(char[][] board) {
        if (board == null || board.length <= 2 || board[0].length <= 2) {
            return;
        }
        for (int i = 0; i < board[0].length; i++) {
            search(0, i, board);
            search(board.length - 1, i, board);
        }

        for (int i = 0; i < board.length; i++) {
            search(i, 0, board);
            search(i, board[0].length - 1, board);
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == '-') {
                    board[i][j] = 'O';
                }
            }
        }

    }

    public static void search(int i, int j, char[][] board) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) {
            return;
        }
        if (board[i][j] == 'O') {
            /* 搜索 */
            board[i][j] = '-';
            search(i - 1, j, board);
            search(i + 1, j, board);
            search(i, j - 1, board);
            search(i, j + 1, board);
        }
    }


    public static void main(String[] args) {
//        X X X X
//        X O O X
//        X X O X
//        X O X X
        char[][] board = new char[4][4];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = 'X';
            }
        }
        board[1][1] = 'O';
        board[1][2] = 'O';
        board[2][2] = 'O';
        board[3][1] = 'O';
        solve(board);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }


    }

}
