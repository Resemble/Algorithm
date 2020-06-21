package package11;

import java.util.HashSet;
import java.util.Set;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package package11
 * @Description: 3. 无重复字符的最长子串
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 * @date 2020-06-21 17:31
 */
public class LengthOfLongestSubstringSolution {


    public int lengthOfLongestSubstring2(String s) {
        if (s == null || "".equals(s)) {
            return 0;
        }
        Set<Character> occ = new HashSet<>();
        // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
        int rk = -1;
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i != 0) {
                // 左指针向右移动一格，移除一个字符
                occ.remove(s.charAt(i - 1));
            }
            while (rk + 1 < s.length() && !occ.contains(s.charAt(rk + 1))) {
                // 不断地移动右指针
                occ.add(s.charAt(rk + 1));
                rk++;
            }
            // 第 i 到 rk 个字符是一个极长的无重复子串
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;
    }

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        // 记录字符上一次出现的位置
        int[] last = new int[128];
        for (int i = 0; i < last.length; i++) {
            last[i] = -1;
        }
        int res = 0;
        // 窗口开始位置
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i);
            start = Math.max(start, last[index] + 1);
            res = Math.max(res, i - start + 1);
            last[index] = i;
        }
        return res;
    }


}
