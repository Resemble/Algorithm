package Seventh;

import java.util.Scanner;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package Seventh
 * @Description:
 * @date 2018/11/4 12:16 PM
 */
public class SubSequenceSolution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        String subString = scanner.nextLine();
        int j = 0;
        for (int i = 0; i < subString.length(); i++) {
            for (; j < string.length(); ) {
                if (subString.codePointAt(i) == string.codePointAt(j)) {
                    j++;
                    if(j == string.length()) {
                        System.out.println("Yes");
                        return;
                    }
                    break;
                }
                j++;
            }
            if (j == string.length()) {
                System.out.println("No");
                return;
            }
        }
        System.out.println("Yes");
    }

}
