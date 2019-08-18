package tenth;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package tenth
 * @Description: 547. 朋友圈
 * @date 2019-08-18 23:17
 */
public class FindCircleNumSolution {

    public int findCircleNum(int[][] M) {
        boolean[] visit = new boolean[M.length];
        int res = 0;
        for (int i = 0; i < M.length; i++) {
            if (!visit[i]) {
                bfs(M, visit, i);
                res++;
            }
        }
        return res;
    }

    public void bfs(int[][] M, boolean[] visit, int i) {
        for (int j = 0; j < M.length; j++) {
            if (M[i][j] == 1 && !visit[j]) {
                visit[j] = true;
                bfs(M, visit, j);
            }
        }
    }

}
