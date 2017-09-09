package Fivth;

/**
 * @author ranran
 * @version V1.0
 * @Title:
 * @Package Fivth
 * @Description:
 * 分割回文串 II
 * 给定一个字符串s，将s分割成一些子串，使每个子串都是回文。
 * 返回s符合要求的的最少分割次数。
 * 样例
 * 比如，给出字符串s = "aab"，
 * 返回 1， 因为进行一次分割可以将字符串s分割成["aa","b"]这样两个回文子串
 * @date 2017/9/9 20:43
 */
public class MinCutSolution {

    /**
     * 回文的最小分割数
     * 1.dp[i]表示当前i到len-1这段的最小分割数
     * 2.dp[i]=min{dp[j+1]+1}（i=<j<len）其中str[i..j]必须是回文、
     * 3.p[i][j]=true表示str[i..j]是回文
     * 4.p[i][j]=s.charAt(i)==s.charAt(j) && (j-i<2||p[i+1][j-1])
     */
    public int minCut(String s) {
        // write your code here
        int[] dp = new int[s.length() + 1];
        dp[s.length()] = -1;
        boolean[][] p = new boolean[s.length()][s.length()];
        for (int i = s.length() - 1; i >= 0; i--) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j) && (j - i < 2 || p[i + 1][j - 1])) {
                    p[i][j] = true;
                    dp[i] = Math.min(dp[i], dp[j + 1] + 1);
                }
            }
        }
        return dp[0];
    }

}
