package Third;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author ranran
 * @version V1.0
 * @Title:
 * @Package Third
 * @Description:
 * @date 2017/8/26 16:02
 */
public class GetTheNthNumber2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> arrayList = new ArrayList<>();
//        while(scanner.hasNext()) {
//            arrayList.add(scanner.nextInt());
//        }
        arrayList.add(45);
        arrayList.add(55);
        arrayList.add(67);
        arrayList.add(33);
        arrayList.add(57);
        arrayList.add(4);

        int Nth = arrayList.get(arrayList.size() - 1);
        Stack<Integer> stack = new Stack<>();
//        stack.push(34);
//        stack.push(35);
//        System.out.println(stack.firstElement());
//        System.out.println(stack.get(0));
//        System.out.println(stack.get(1));


        int[] array = new int[arrayList.size() - 1];
        for (int i = 0; i < array.length; i++) {
            array[i] = arrayList.get(i);
            if (i < Nth) {
                adjustStack2(stack, arrayList.get(i));
            } else {
                adjustStack(stack, arrayList.get(i), Nth);
            }
        }

        System.out.println(stack.peek());

    }

    public static void adjustStack(Stack<Integer> stack, int value, int Nth) {
        Stack<Integer> tempStack = new Stack<>();
        int i = 0;
        while (!stack.isEmpty()) {
            if (stack.peek() < value) {
                if (i == 0) {
                    stack.pop();
                    i++;
                } else {
                    tempStack.push(stack.pop());
                }
            } else {
                break;
            }
        }
        if (stack.size() < Nth) {
            stack.push(value);
        }

        while (!tempStack.isEmpty()) {
            stack.push(tempStack.pop());
        }
    }

    public static void adjustStack2(Stack<Integer> stack, int value) {
        Stack<Integer> tempStack = new Stack<>();
        while (!stack.isEmpty()) {
            if (stack.peek() < value) {
                tempStack.push(stack.pop());
            } else {
                break;
            }
        }
        stack.push(value);
        while (!tempStack.isEmpty()) {
            stack.push(tempStack.pop());
        }
    }

}
