package tenth;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package tenth
 * @Description:1239. 串联字符串的最大长度
 * @date 2020-05-04 11:43
 */
public class MaxLengthSolution {

    int maxLength = 0;
    // 枚举完所有情况，然后有一个是最大的
    public int maxLength(List<String> arr) {
        String cur = "";
        int index = 0;
        dfs(arr, cur, index);
        return maxLength;
    }

    void dfs(List<String> arr, String curr, int index) {
        for (int i = index; i < arr.size(); i++) {
            if (!isUniqueString(curr + arr.get(i))) {
                continue;
            }
            curr = curr + arr.get(i);
            maxLength = Math.max(maxLength, curr.length());
            dfs(arr, curr, i + 1);
            // 第一个数遍历完，去掉第一个数，进行第二个数开始的遍历
            // 选与不选，这就是回溯的魅力吗
            curr = curr.substring(0, curr.length() - arr.get(i).length());
        }
    }



    public boolean isUniqueString(String str) {
        Set<Character> characterSet = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            Character temp = str.charAt(i);
            if (characterSet.contains(temp)) {
                return false;
            } else {
                characterSet.add(temp);
            }
        }
        return true;
    }

}
