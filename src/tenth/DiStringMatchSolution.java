package tenth;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package tenth
 * @Description: 942. 增减字符串匹配
 * @date 2019-09-25 22:49
 */
public class DiStringMatchSolution {

    public int[] diStringMatch(String S) {
        int N = S.length();
        int[] res = new int[N + 1];
        int max = N;
        int min = 0;
        for (int i = 0; i < N; i++) {
            if (S.charAt(i) == 'I') {
                res[i] = min;
                min++;
                res[N] = min;
            } else {
                res[i] = max;
                max--;
                res[N] = max;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        DiStringMatchSolution solution = new DiStringMatchSolution();
        int[] res = solution.diStringMatch("IDID");
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }

}
