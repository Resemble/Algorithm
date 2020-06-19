package package11;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package package11
 * @Description: 14. 最长公共前缀
 * https://leetcode-cn.com/problems/longest-common-prefix/
 * @date 2020-06-19 18:34
 */
public class LongestCommonPrefixSolution {

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < strs[0].length(); i++) {
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].length() - 1 < i) {
                    return builder.toString();
                }
                if (strs[j].charAt(i) != strs[0].charAt(i)) {
                    return builder.toString();
                }
            }
            builder.append(strs[0].charAt(i));
        }
        return builder.toString();
    }

}
