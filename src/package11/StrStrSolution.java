package package11;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package package11
 * @Description: 28. 实现 strStr()
 * https://leetcode-cn.com/problems/implement-strstr/
 * @date 2020-06-19 18:21
 */
public class StrStrSolution {

    public int strStr(String haystack, String needle) {
        if (haystack == null ||
        needle == null || "".equals(needle)) {
            return 0;
        }
        if (haystack.length() < needle.length()) {
            return -1;
        }
        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            if (haystack.substring(i, i + needle.length()).equals(needle)) {
                return i;
            }
        }
        return -1;
    }


}
