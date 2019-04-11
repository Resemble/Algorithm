package eighth;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package eighth
 * @Description: https://www.lintcode.com/problem/longest-palindromic-subsequence/description 最长回文序列
 * @date 2019/4/11 10:18 PM
 */
public class LongestPalindromeSubseqSolution {

    /**
     * @param s: the maximum length of s is 1000
     * @return: the longest palindromic subsequence's length
     */
    public int longestPalindromeSubseq(String s) {
        // write your code here
        if ("".equals(s)) {
            return 0;
        }
        int len = s.length();
        int[][] fromTo = new int[len][len];

        return getSubseq(s, fromTo, 0, len - 1);
    }

    public int getSubseq(String s, int[][] fromTo, int i, int j) {
        if (fromTo[i][j] != 0) {
            return fromTo[i][j];
        }
        if (i > j) {
            return 0;
        }
        if (i == j) {
            fromTo[i][j] = 1;
            return fromTo[i][j];
        }
        int iAdd = i + 1;
        int jSub = j - 1;
        if (s.charAt(i) == s.charAt(j)) {
            int subResult = getSubseq(s, fromTo, iAdd, jSub);
            fromTo[i][j] = 2 + subResult;
            return fromTo[i][j];
        } else {
            int left = getSubseq(s, fromTo, iAdd, j);
            int right = getSubseq(s, fromTo, i, jSub);
            fromTo[i][j] = Math.max(left, right);
            return fromTo[i][j];
        }
    }


    public static void main(String[] args) {
        String s = "0123456";
        System.out.println(s.substring(1, s.length() - 1));
        System.out.println(s.substring(1, s.length()));
        System.out.println(s.substring(0, s.length() - 1));
        System.out.println(s.substring(0, s.length()));
        System.out.println(s.substring(0));
        System.out.println(s.substring(1, 1));
        if (s.substring(1, 1) == null) {
            System.out.println("null");
        } else if (s.substring(1, 1).equals("")) {
            System.out.println("空字符串");
        }

//        String s2 = "asdasdajjdkajwiejladjkahsdjhawiueauwhdjashdjancnkjsahduiawudhajsnhsjahjdhawuahdjshjnzanjcnhjdashuawhdjaksndjkahduwhwauhdai";
//        LongestPalindromeSubseqSolution subseqSolution = new LongestPalindromeSubseqSolution();
//        int result = subseqSolution.longestPalindromeSubseq(s2);
//        System.out.println(result);
        int i = 0;
        int j = 2;
//        System.out.println(i++);
        test(i++);
    }

    public static void test(int i) {
        System.out.println(i);
    }
}
