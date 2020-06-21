package package11;

import java.util.*;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package package11
 * @Description: 49. 字母异位词分组
 * https://leetcode-cn.com/problems/group-anagrams/
 * @date 2020-06-21 16:51
 */
public class GroupAnagramsSolution {

    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> result = new HashMap<>();
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }
        for (int i = 0; i < strs.length; i++) {
            char[] ca = strs[i].toCharArray();
            Arrays.sort(ca);
            // char[] 到 string 的取巧
            String key = String.valueOf(ca);
            if (!result.containsKey(key)) {
                result.put(key, new ArrayList<>());
            }
            result.get(key).add(strs[i]);
        }

        // map 的 value 到 list 的取巧
        return new ArrayList<>(result.values());
    }



    public static void main(String[] args) {
        GroupAnagramsSolution solution = new GroupAnagramsSolution();

        //        String s2 = "1bsd";
        //        for (int i = 0; i < s2.length(); i++) {
        //            System.out.println(s2.charAt(i));
        //        }
    }

}
