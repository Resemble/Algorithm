package Fivth;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ranran
 * @version V1.0
 * @Title:
 * @Package Fivth
 * @Description:
 * @date 2017/9/9 16:52
 */
public class FindPalindromeSolution {

    List<List<String>> resultList;
    ArrayList<String> currentList;

    public List<List<String>> partition(String s) {
        // write your code here
        resultList = new ArrayList<List<String>>();
        currentList = new ArrayList<>();
        findPalindrome(s, 0);

        Object o = new LinkedList<String>();

        return resultList;
    }

    private void findPalindrome(String str, int left) {
        // 回溯返回条件，left指针已到
        if (currentList.size() > 0 && left >= str.length()) {
            List<String> tempList = (ArrayList<String>)currentList.clone();
            resultList.add(tempList);
        }
        for (int right = left; right < str.length(); right++) {
            // 不是回文的话，直接right++
            if (isPalidrome(str, left, right)) {
                // 添加回文
                if (left == right) {
                    currentList.add(Character.toString(str.charAt(left)));
                } else {
                    currentList.add(str.substring(left, right + 1));
                }

                // 进行回溯
                findPalindrome(str, right + 1);
                // 移除刚刚添加的元素，也就是回到之前的状态
                currentList.remove(currentList.size() - 1);
            }
        }

    }


    public boolean isPalidrome(String str, int left, int right) {
        if (left == right) {
            return true;
        }
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
