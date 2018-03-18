package Seventh;

import java.util.HashSet;
import java.util.Set;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package Seventh
 * @Description:
 *
  Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

  For example, given
  s ="leetcode",
  dict =["leet", "code"].

  Return true because"leetcode"can be segmented as"leet code".
 *
 * @date 2018/3/18 上午11:35
 */
public class WordBreakSolution {

    /**
            * 方法二：
            * 状态转移方程：
            * f(i) 表示s[0,i]是否可以分词
            * f(i) = f(j) && f(j+1,i); 0 <= j < i;
            *
            */

    public boolean wordBreak(String s, Set<String> dict) {
        int len = s.length();
        boolean[] arr = new boolean[len + 1];
        arr[0] = true;
        for (int i = 1; i <= len; i++) {
            for (int j = 0; j < i; j++) {
                if(arr[j] && dict.contains(s.substring(j, i))) {
                    arr[i] = true;
                    break;
                }
            }
        }
        return arr[len];
    }

    public static void main(String[] args) {
        WordBreakSolution wordBreakSolution = new WordBreakSolution();
        Set<String> stringSet = new HashSet<>();
        stringSet.add("aaaa");
        stringSet.add("aaa");
        if(wordBreakSolution.wordBreak("aaaaaaa", stringSet)) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}
