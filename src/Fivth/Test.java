package Fivth;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author ranran
 * @version V1.0
 * @Title:
 * @Package Fivth
 * @Description:
 * @date 2017/9/13 19:27
 */
public class Test {
    public static void main(String[] args) {
        String string = "1.1.1.1";
        String[] strings = string.split("\\.");
        for (int i = 0; i < strings.length; i++) {
            System.out.println(strings[i]);
        }
        StringBuilder sb = new StringBuilder();
        String string2 = "012345";
        sb.append(string2);
        System.out.println(sb.substring(0, sb.length()));
        System.out.println(string2.substring(0, sb.length()));
        System.out.println(string2.substring(0, string2.length()));

        Deque<Integer> deque = new ArrayDeque<>();
        deque.push(1);
        deque.push(2);
        deque.add(3);
        while (!deque.isEmpty()) {
            System.out.println(deque.pop());
        }

        String string21 = "000";
        changeString(string21);
        System.out.println(string21);
    }


    public static void changeString(String string) {
        string = "123";
    }
}
