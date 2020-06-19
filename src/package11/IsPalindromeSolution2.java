package package11;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package package11
 * @Description: 125. 验证回文串
 * https://leetcode-cn.com/problems/valid-palindrome/comments/
 * @date 2020-06-19 17:09
 */
public class IsPalindromeSolution2 {

    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i)) || Character.isAlphabetic(s.charAt(i))) {
                builder.append(s.charAt(i));
            }
        }
        String tempStr = builder.toString();
        builder.reverse();
        return builder.toString().equals(tempStr);
    }

}
