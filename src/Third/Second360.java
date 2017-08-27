package Third;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author ranran
 * @version V1.0
 * @Title:
 * @Package Third
 * @Description:
 * @date 2017/8/26 20:06
 */
public class Second360 {

    public static int[] result;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] array = new int[n];
        result = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < i; j++) {
//                if (array[i] < array[j]) {
//                    result[i] += 1;
//                }
//            }
//        }
        Stack<Integer> stack = new Stack<>();
        stack.push(array[0]);
        for (int i = 1; i < n; i++) {
            Stack<Integer> tempStack = new Stack<>();
            while(!stack.isEmpty()) {
                if (stack.peek() < array[i]) {
                    tempStack.push(stack.pop());
                } else {
                    result[i] = stack.size() + 1;
                    stack.push(array[i]);
                    break;
                }
            }
            while (!tempStack.isEmpty()) {
                stack.push(tempStack.pop());
            }
        }

        for (int i = 0; i < n - 1; i++) {
            System.out.print(result[i] + " ");
        }
        System.out.print(result[n - 1]);
    }




}
