package Fivth;

/**
 * @author ranran
 * @version V1.0
 * @Title:
 * @Package Fivth
 * @Description: 最长公共前缀
 * @date 2017/9/13 14:35
 */
public class LongestCommonPrefixSolution {

    public static void main(String[] args) {
        String[] strs = new String[2];
        strs[0] = "A";
        strs[1] = "A";
        System.out.println(longestCommonPrefix(strs));
    }


    public static String longestCommonPrefix(String[] strs) {
        // write your code here
        Character ch;
        if (strs.length == 0) return "";
        if (strs.length == 1) return strs[0];
        int minLen = Integer.MAX_VALUE;
        int index = 0;
        for(int i = 0; i < strs.length; i++) {
            if (minLen > strs[i].length()) {
                minLen = strs[i].length();
                index = i;
            }

        }
        for(int j = 0; j < minLen; j++) {
            ch = strs[0].charAt(j);
            for(int i = 0; i < strs.length; i++) {
                if (ch != strs[i].charAt(j)) {
                    if (j >= 1) {
                        return strs[0].substring(0, j);
                    }else {
                        return "";
                    }
                }
            }
        }

        return minLen == 0 ? "":strs[index];
    }

}
