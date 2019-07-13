package tenth;

import java.util.Stack;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package tenth
 * @Description:
 * @date 2019-07-13 16:53
 */
public class DailyTemperaturesSolution {

    public int[] dailyTemperatures(int[] T) {
        int[] upDistanceArray = new int[T.length];
        upDistanceArray[T.length - 1] = 0;
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> stackIndex = new Stack<>();
        int index;
        for (int i = 0; i < T.length; i++) {
            while (!stack.isEmpty() && stack.peek() < T[i]) {
                stack.pop();
                index = stackIndex.pop();
                upDistanceArray[index] = i - index;
            }
            stack.push(T[i]);
            stackIndex.push(i);
        }
        return upDistanceArray;
    }

    public static void main(String[] args) {
        DailyTemperaturesSolution solution = new DailyTemperaturesSolution();
        int[] T = {55,38,53,81,61,93,97,32,43,78};
        int[] upDistanceArray = solution.dailyTemperatures(T);
        for (int i = 0; i < upDistanceArray.length; i++) {
            System.out.print(upDistanceArray[i] + " ");
        }
    }

}
