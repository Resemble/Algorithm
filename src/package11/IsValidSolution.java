package package11;


import java.util.Stack;
import java.util.function.BiFunction;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package package11
 * @Description: 有效的括号
 * @date 2020-07-04 17:37
 */
public class IsValidSolution {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                stack.push(s.charAt(i));
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                Character tempCharacter = stack.pop();
                if (tempCharacter == '(' && s.charAt(i) != ')') {
                    return false;
                } else if (tempCharacter == '{' && s.charAt(i) != '}') {
                    return false;
                } else if (tempCharacter == '[' && s.charAt(i) != ']') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }


    public int compute(int a, int b, BiFunction<Integer, Integer, Integer> biFunction) {
        return biFunction.apply(a, b);
    }

    public static void main(String[] args) {
        IsValidSolution solution = new IsValidSolution();
        System.out.println(solution.compute(3, 4, new sumSolution()));

    }
}


class sumSolution implements BiFunction<Integer, Integer, Integer> {

    @Override public Integer apply(Integer a, Integer b) {
        return a + b;
    }
}
