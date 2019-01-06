package Seventh;

import java.util.Scanner;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package Seventh
 * @Description:
 * @date 2019/1/5 5:59 PM
 */
public class ReverseSolution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        sb.append(sc.nextLine());
        sb.reverse();
        String[] strings = sb.toString().split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < strings.length; i++) {
            sb = new StringBuilder();
            stringBuilder.append(sb.append(strings[i]).reverse());
            stringBuilder.append(" ");
        }

        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        System.out.println(stringBuilder);

    }

}
