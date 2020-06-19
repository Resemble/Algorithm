package package11;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package package11
 * @Description: 242. 有效的字母异位词
 * https://leetcode-cn.com/problems/valid-anagram/
 * @date 2020-06-19 16:59
 */
public class IsAnagramSolution {

    public boolean isAnagram(String s, String t) {
        char[] ch = new char[26];
        for (int i = 0; i < s.length(); i++) {
            ch[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            ch[t.charAt(i) - 'a']--;
        }
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "a";
        String t = "b";
        IsAnagramSolution solution = new IsAnagramSolution();
        if (solution.isAnagram(s, t)) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }

}
