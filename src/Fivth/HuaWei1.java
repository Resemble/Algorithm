package Fivth;

import java.util.Scanner;

/**
 * @author ranran
 * @version V1.0
 * @Title:
 * @Package Fivth
 * @Description:
 * @date 2017/9/13 19:01
 */
public class HuaWei1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String string = sc.nextLine();
        StringBuilder sb = new StringBuilder();
        sb.append(string);
        if(sb.codePointAt(0) == '-') {
            System.out.println(sb.length() - 1);
            StringBuilder sb2 = new StringBuilder();
            sb2.append(sb.substring(1));
            System.out.print("-");
            for (int i = 0; i < sb2.length() - 1; i++) {
                System.out.print(sb2.charAt(i) + " ");
            }
            System.out.print(sb2.charAt(sb2.length() - 1));
            System.out.println();
            System.out.print("-");
            System.out.print(sb2.reverse());
        } else {
            System.out.println(sb.length());
            StringBuilder sb2 = new StringBuilder();
            sb2.append(sb.substring(0));
            for (int i = 0; i < sb2.length() - 1; i++) {
                System.out.print(sb2.charAt(i) + " ");
            }
            System.out.print(sb2.charAt(sb2.length() - 1));
            System.out.println();
            System.out.print(sb2.reverse());
        }
    }

}
