package package11;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package package11
 * @Description: 17. 电话号码的字母组合
 * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 * @date 2020-07-19 16:18
 */
public class LetterCombinationsSolution {

    List<String> res = new ArrayList<>();
    StringBuilder builder = new StringBuilder();
    int index = 0;

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return res;
        }
        backtrack(digits, 0);
        return res;
    }

    private void backtrack(String digits, int index) {
        if (builder.length() == digits.length()) {
            res.add(builder.toString());
            return;
        }

        char c = digits.charAt(index);
        String s = convert(c);
        for (int i = 0; i < s.length(); i++) {
            builder.append(s.charAt(i));
            backtrack(digits, index + 1);
            // 删除最后一个字符，然后回溯
            builder.deleteCharAt(builder.length() - 1);
        }
    }

    private String convert(char c) {
        if (c == '2') {
            return "abc";
        }
        if (c == '3') {
            return "def";
        }
        if (c == '4') {
            return "ghi";
        }
        if (c == '5') {
            return "jkl";
        }
        if (c == '6') {
            return "mno";
        }
        if (c == '7') {
            return "pqrs";
        }
        if (c == '8') {
            return "tuv";
        }
        if (c == '9') {
            return "wxyz";
        }
        return "";
    }

    public static void main(String[] args) {
        String digits = "234";
        LetterCombinationsSolution solution = new LetterCombinationsSolution();
        List<String> result = solution.letterCombinations(digits);
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }

}
