package tenth;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package tenth
 * @Description: 997. 找到小镇的法官
 * @date 2019-08-25 11:36
 */
public class FindJudgeSolution {

    public int findJudge(int N, int[][] trust) {

        if (N == 0 || trust == null) {
            return -1;
        }

        int[] trustCnt = new int[N + 1];
        int[] isTrustOther = new int[N + 1];

        for (int i = 0; i < trust.length; i++) {
            isTrustOther[trust[i][0]] = 1;
            trustCnt[trust[i][1]] += 1;
        }

        for (int i = 1; i < N + 1; i++) {
            if (trustCnt[i] == N - 1 && isTrustOther[i] == 0) {
                return i;
            }
        }
        return -1;

    }



    public static void main(String[] args) {
        int[] one = {1, 2};
        int[][] trust = new int[1][1];
        trust[0] = one;
        FindJudgeSolution solution = new FindJudgeSolution();
        int result = solution.findJudge(2, trust);
        System.out.println(result);
    }


}
