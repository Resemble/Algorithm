package Fivth;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 * @author ranran
 * @version V1.0
 * @Title:
 * @Package Fivth
 * @Description:
 * @date 2017/9/17 19:22
 */
public class Sohu1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String string = sc.nextLine();
        if (string == null)
            return;
        String[] paths = string.split("/");
        Deque<String> deque = new ArrayDeque<>();
        for (int i = 0; i < paths.length; i++) {
            if (paths[i].equals("..")) {
                if (!deque.isEmpty()) {
                    deque.pop();
                }
            }else if (paths[i].equals(".") || paths[i].isEmpty()) {
                continue;
            }else {
                deque.push(paths[i]);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty()) {
            sb.insert(0, deque.pop());
            sb.insert(0, "/");
            System.out.println("Sb.toString:" + sb.toString());
        }
        if (sb.length() == 0) {
            System.out.println("/");
        } else {
            System.out.println(sb.toString());
        }
    }

}
