package Forth;

import java.util.Scanner;

/**
 * @author ranran
 * @version V1.0
 * @Title:
 * @Package Forth
 * @Description:
 * @date 2017/9/5 21:37
 */
public class ReserveMaxNum {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            StringBuilder sb = new StringBuilder();
            sb.append(sc.next());
            int cnt = sc.nextInt();
            int count = 0;
            while (count < cnt) {
                int len = sb.length() - 1;
                int s = 0;
                while (s < len && sb.codePointAt(s) >= sb.codePointAt(s + 1))
                    s++;
                sb.deleteCharAt(s);
                count++;
            }
            System.out.println(sb);
        }


    }

}
