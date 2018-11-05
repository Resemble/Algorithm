package Seventh;

import java.util.Scanner;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package Seventh
 * @Description:
 * @date 2018/11/4 10:51 AM
 */
public class NumberSolution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(scanner.next());
            int cnt = scanner.nextInt();
            int count = 0;
            while (count < cnt) {
                int len = stringBuilder.length() - 1;
                int s = 0;
                while (s < len && stringBuilder.codePointAt(s) >= stringBuilder.codePointAt(s + 1)) {
                    s++;
                }
                stringBuilder.deleteCharAt(s);
                count++;
            }
            System.out.println(stringBuilder);
        }
    }

}
