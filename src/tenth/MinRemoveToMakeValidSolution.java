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
                    builder.replace(i, i + 1, " ");
                }
            }
        }

        s = builder.toString().replaceAll(" ", "");
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
                    builder.replace(i, i + 1, " ");
                }
            }
        }
        return builder.toString().replaceAll(" ", "");
    }

    public static void main(String[] args) {
        String s = "lee(t(c)o)de)";
        System.out.println(minRemoveToMakeValid(s));
    }

}
