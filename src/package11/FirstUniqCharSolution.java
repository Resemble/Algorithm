package package11;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package package11
 * @Description: 387. 字符串中的第一个唯一字符
 * https://leetcode-cn.com/problems/first-unique-character-in-a-string/
 * @date 2020-06-19 16:51
 */
public class FirstUniqCharSolution {

    public int firstUniqChar(String s) {
        char[] ch = new char[26];
        for (int i = 0; i < s.length(); i++) {
            ch[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (ch[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }

}
