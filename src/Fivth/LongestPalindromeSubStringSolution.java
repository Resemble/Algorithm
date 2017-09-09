package Fivth;

/**
 * @author ranran
 * @version V1.0
 * @Title:
 * @Package Fivth
 * @Description:
 * 给出一个字符串（假设长度最长为1000），求出它的最长回文子串，你可以假定只有一个满足条件的最长回文串。
 * 样例
 * 给出字符串 "abcdzdcab"，它的最长回文子串为 "cdzdc"。
 *
 * @date 2017/9/9 21:05
 */
public class LongestPalindromeSubStringSolution {

    public String longestPalindrome(String s) {
        // write your code here
        for (int i = s.length() - 1; i >= 0; i--) {
            int left = 0;
            int right = left + i;
            while (right < s.length()) {
                if (isPalindrome(s, left, right)) {
                    return s.substring(left, right + 1);
                }
                left++;
                right++;
            }
        }
        return "";
    }

    public boolean isPalindrome(String string, int left, int right) {
        if (left == right) return true;
        while (left < right) {
            if (string.charAt(left) != string.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

}
