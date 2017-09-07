package First;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @author ranran
 * @version V1.0
 * @Title:
 * @Package ChapterTwo.Two_1
 * @Description:
 * @date 2017/5/7 21:50
 */
public class Test {
    public static void main(String args[]) {
        System.out.println("***********************************");
        Singleton singletonA = Singleton.getInstance();
        Singleton singletonB = Singleton.getInstance();
        System.out.println(singletonA.equals(singletonB));

        Singleton2 singleton2A = Singleton2.INSTANCE;
        Singleton2 singleton2B = Singleton2.INSTANCE;
        System.out.println(singleton2A.equals(singleton2B));


        System.out.println("***********************************Stack");
        Stack<Integer> integerStack = new Stack<>();
        integerStack.add(2);
        integerStack.add(3);
        integerStack.add(4);
        integerStack.push(5);
        System.out.println("integerStack.peek():" + integerStack.peek());
        while (!integerStack.isEmpty()) {
            System.out.println(integerStack.pop());
        }

        System.out.println("***********************************ConcurrentLinkedQueue");
        Queue<Integer> integerQueue = new ConcurrentLinkedQueue<>();
        integerQueue.add(2);
        integerQueue.add(3);
        integerQueue.add(4);
        System.out.println(integerQueue.peek());
        while (!integerQueue.isEmpty()) {
            System.out.println(integerQueue.poll());
        }

        System.out.println("*********************************** ArrayDeque");
        Queue<Integer> arrayDeque = new ArrayDeque<>();
        arrayDeque.add(2);
        arrayDeque.add(3);
        arrayDeque.add(4);
        for (int value:arrayDeque) {
            System.out.println(value);
        }

        System.out.println("*********************************** string");
        String string = "sdf";
        System.out.println(string.subSequence(2,3));
        System.out.println(string.substring(0,1));
        System.out.println(string.substring(1,2));
        System.out.println(string.substring(2,3));

        System.out.println("*********************************** Bytes");
        byte[] b1 = "0134ewr".getBytes();
        System.out.println("string.getBytes():" + b1);
        System.out.println("string.getBytes().length:" + b1.length);
        System.out.println("b1[0]:" + b1[0]);
        System.out.println(b1[0]);
        System.out.println("b1[1]:" + b1[1]);
        System.out.println("b1[2]:" + b1[2]);
        System.out.println("b1[3]:" + b1[3]);
        System.out.println("b1[4]:" + b1[4]);
        System.out.println("b1[5]:" + b1[5]);
//        System.out.println("b1[6]:" + b1[6]);

        System.out.println("*********************************** array 地址拷贝");
        int array[] = {3,2,1,4,5};
        int temp[] = array;
        temp[1] = -1;
        System.out.println(Arrays.toString(temp));
        System.out.println(Arrays.toString(array));

        System.out.println("*********************************** generateArray printArray");
        array = generateArray(29);
        printArray(array);
        array = generatePositiveArray(29);
        printArray(array);

        String string2 = "22:234:34:234";
        String[] temp1 = string2.split(":");
        String[] temp2 = string2.split(".");
        if (temp1.length == 4) {
            System.out.println(4);
        } else if (temp2.length == 6) {
            System.out.println(6);
        }



    }

    public static int[] generateArray(int size) {
        int[] result = new int[size];
        for (int i = 0; i != size; i++) {
            result[i] = (int) (Math.random() * 11) - 5;
        }
        return result;
    }

    public static int[] generatePositiveArray(int size) {
        int[] result = new int[size];
        for (int i = 0; i != size; i++) {
            result[i] = (int) (Math.random() * 10) + 1;
        }
        return result;
    }
    public static void printArray(int[] arr) {
        for (int i = 0; i != arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }



}
