package package11;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package package11
 * @Description: 5. 最长回文子串
 * https://leetcode-cn.com/problems/longest-palindromic-substring/
 * @date 2020-06-21 18:48
 */
public class LongestPalindromeSolution {

    public String longestPalindrome2(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }
        int maxLen = 1;
        int begin = 0;
        // dp[i][j] 表示 s[i, j] 是否是回文串
        boolean[][] dp = new boolean[len][len];
        char[] charArray = s.toCharArray();
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        for (int j = 1; j < len; j++) {
            for (int i = 0; i < j; i++) {
                if (charArray[i] != charArray[j]) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                    if (dp[i][j] && j - i + 1 > maxLen) {
                        maxLen = j - i + 1;
                        begin = i;
                    }
                }
            }

        }
        return s.substring(begin, begin + maxLen);
    }


    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }
        int maxLen = 1;
        int begin = 0;
        // dp[i][j] 表示 s[i, j] 是否是回文串
        boolean[][] dp = new boolean[len][len];
        char[] charArray = s.toCharArray();

        // dp[i][j] 1, 2, 3
        for (int tempLen = 0; tempLen < len; tempLen++) {
            for (int i = 0; i + tempLen < len; i++) {
                if (tempLen == 0) {
                    dp[i][i + tempLen] = true;
                } else if (charArray[i] == charArray[i + tempLen]) {
                    if (tempLen == 1) {
                        dp[i][i + tempLen] = true;
                    } else {
                        dp[i][i + tempLen] = dp[i + 1][i + tempLen - 1];
                    }
                } else {
                    dp[i][i + tempLen] = false;
                }
                if (dp[i][i + tempLen] && (tempLen + 1) > maxLen) {
                    maxLen = tempLen + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }

}
