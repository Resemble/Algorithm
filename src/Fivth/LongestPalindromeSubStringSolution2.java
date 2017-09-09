package Fivth;

/**
 * @author ranran
 * @version V1.0
 * @Title:
 * @Package Fivth
 * @Description: 最长回文子串，动规
 * @date 2017/9/9 21:23
 */
public class LongestPalindromeSubStringSolution2 {

    public static void main(String[] args) {
        String string = "bb";
        System.out.println(longestPalindrome(string));
    }

    public static String longestPalindrome(String s) {
        // write your code here
        boolean[][] p = new boolean[s.length()][s.length()];
        int minIndex = 0;
        int maxIndex = 0;
        int maxLen = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                if(s.charAt(i) == s.charAt(j) && (j - i < 2 || p[i + 1][j - 1])) {
                    p[i][j] = true;
                    if (j - i + 1 > maxLen) {
                        maxLen = j - i + 1;
                        minIndex = i;
                        maxIndex = j;
                    }
                }
            }

        }
        System.out.println("minIndex:" + minIndex + " maxIndex:" + maxIndex);
        return s.substring(minIndex, maxIndex + 1);
    }

}
