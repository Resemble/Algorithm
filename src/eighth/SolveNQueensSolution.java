package eighth;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package eighth
 * @Description: n皇后问题
 * 传进去的参数一个是cols, 这个是已经判定好的确保互相不攻击的queens的摆放位置， column是下一个queen要放在哪里的位置， 本题中的所有皇后存放的位置，都是以Column来表示的。这个是前提。
 * 那么换句话说，isValid函数就是用来判断已经放好的这些皇后和下一个要进来的皇后是否会互相攻击.
 *
 * 攻击的判定条件有四个，分别是，同行，同列，两条斜线。
 * 但是在这道题里面，添加皇后进来的先后次序就是行数，所以行数不需要比较，因而函数中只有三个条件需要比较，列和两条斜线的比较。
 *
 * 同列：cols里面的值和column本身比较。
 * 斜线1：cols里面的值 + 其对应的行数 == column + column对应的行数。
 * 斜线2： cols里面的值 - 其对应的行数 == column - column对应的行数。
 *
 * 比如说现在cols已经放了三个皇后了，而且他们之间互相不攻击， 那么cols.size() = 3， 而3正好是column所对应的行数。然后把该值存到变量row里面。
 * 我们应该依次把已有的三个皇后分别和column进行比较。所以有了for (rowIndex = 0; rowIndex < cols.size(); rowIndex++)
 * 其实就是比较三次。 然后每次比较中，第一个比较是比较列数， 列数就是cols中的值，和column本身的值，所以直接比较，如果不同列return false.
 *
 * 接下来是比较第一个斜线，注意cols里面当下的值对应的行数，依次应该是0，1,2,3，。。 刚好对应了rowIndex. 即cols里面的第一个值，其实就是第一行要放的皇后， 第二个值就是第二行要放的皇后所在的位置（列数表示），，，依次类推。而rowIndex从0 开始， 刚好是从第一行的皇后开始比较，然后比较第二行的皇后，然后依次类推。 所以才有了 if (cols.get(rowIndex) + rowIndex == column + row) {return false;}
 *
 * 第二个斜线同上，只是判断的时候，把行列做差比较就可以了。这个就是本题中我个人所理解的判定皇后之间是否攻击的方法。
 * @date 2019/3/10 5:19 PM
 */
public class SolveNQueensSolution {

    /*
     * @param n: The number of queens
     * @return: All distinct solutions
     */
    public List<List<String>> solveNQueens(int n) {
        // write your code here
        List<List<String>> results = new ArrayList<>();
        if (n <= 0) {
            return results;
        }
        search(results, new ArrayList<Integer>(), n);
        return results;
    }

    private void search(List<List<String>> results, List<Integer> cols, int n) {
        if (cols.size() == n) {
            results.add(drawChessboard(cols));
            return;
        }
        for (int colIndex = 0; colIndex < n; colIndex++) {
            if (!isValid(cols, colIndex)) {
                continue;
            }
            cols.add(colIndex);
            search(results, cols, n);
            cols.remove(cols.size() - 1);
        }
    }
    private List<String> drawChessboard(List<Integer> cols) {
        List<String> chessboard = new ArrayList<>();
        for (int i = 0; i < cols.size(); i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < cols.size(); j++) {
                sb.append(j == cols.get(i) ? 'Q' : '.');
            }
            chessboard.add(sb.toString());
        }
        return chessboard;
    }

    private boolean isValid(List<Integer> cols, int column) {
        int row = cols.size();
        for (int rowIndex = 0; rowIndex < cols.size(); rowIndex++) {
            if (cols.get(rowIndex) == column) {
                return false;
            }
            if (rowIndex + cols.get(rowIndex) == row + column) {
                return false;
            }
            if (rowIndex - cols.get(rowIndex) == row - column) {
                return false;
            }
        }
        return true;
    }

}
