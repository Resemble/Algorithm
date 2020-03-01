package tenth;

import java.util.Stack;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package tenth
 * @Description: 1249. 移除无效的括号
 * @date 2020-03-01 17:41
 */
public class MinRemoveToMakeValidSolution {

    public static String minRemoveToMakeValid(String s) {
        StringBuilder builder = new StringBuilder(s);
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push('(');
            } else if (s.charAt(i) == ')'){
                if (stack.size() > 0) {
                    stack.pop();
                } else {
                    builder.replace(i, i + 1, "#");
                }
            }
        }

        s = builder.toString().replaceAll("#", "");
        if (stack.size() == 0) {
            return s;
        }
        builder = new StringBuilder(s);
        stack = new Stack<>();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ')') {
                stack.push(')');
            } else if (s.charAt(i) == '('){
                if (stack.size() > 0) {
                    stack.pop();
                } else {
                    builder.replace(i, i + 1, "#");
                }
            }
        }
        return builder.toString().replaceAll("#", "");
    }

    /***
     * @title minRemoveToMakeValid2
     * @description 更好的版本
     * @param: s
     * @updateTime 2020-03-01 18:28
     * @return java.lang.String
     */
    public static String minRemoveToMakeValid2(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        int n = s.length();
        Stack<Integer> stack = new Stack<>();
        int[] removeArr = new int[n];
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else if (c == ')') {
                if (!stack.empty()) {
                    stack.pop();
                } else {
                    removeArr[i] = 1;
                }
            }
        }
        while (!stack.empty()) {
            removeArr[stack.pop()] = 1;
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (removeArr[i] == 0) {
                builder.append(s.charAt(i));
            }
        }
        return builder.toString();
    }


    public static void main(String[] args) {
        String s = "lee(t(c)o)de)";
        System.out.println(minRemoveToMakeValid(s));
    }

}
