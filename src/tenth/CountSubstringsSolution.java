package tenth;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package tenth
 * @Description: 647. 回文子串
 * @date 2019-08-19 22:53
 */
public class CountSubstringsSolution {

    int num = 0;
    public int countSubstrings(String s) {
        for (int i = 0; i < s.length(); i++) {
            count(s, i, i); // 回文串长度为奇数
            count(s, i, i + 1); // 回文串为偶数
        }
        return num;
    }

    public void count(String s, int start, int end) {
        while(start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            num ++;
            start--;
            end++;
        }
    }

}
