package tenth;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package tenth
 * @Description: 14. 最长公共前缀
 * @date 2019-08-24 16:19
 */
public class LongestCommonPrefixSolution {

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        } else if (strs.length == 1) {
            return strs[0];
        }
        StringBuilder commonPrefix = new StringBuilder();
        for (int i = 0; i < strs[0].length(); i++) {
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].length() >= i + 1) {
                    if (strs[j].charAt(i) != strs[0].charAt(i)) {
                        return commonPrefix.toString();
                    }
                } else {
                    return commonPrefix.toString();
                }

            }
            commonPrefix.append(strs[0].charAt(i));
        }
        return commonPrefix.toString();
    }

}
