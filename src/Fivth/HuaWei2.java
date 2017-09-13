package Fivth;

import java.util.Scanner;

/**
 * @author ranran
 * @version V1.0
 * @Title:
 * @Package Fivth
 * @Description:
 * @date 2017/9/13 19:12
 */
public class HuaWei2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String string1 = sc.nextLine();
        String string2 = sc.nextLine();
        String string3 = sc.nextLine();
        String string4 = sc.nextLine();
        if(string1.equals(string3) && string2.equals(string4)) {
            System.out.println("Overlap IP");
            return;
        }
        String[] str1 = string1.split("\\.");
        String[] str2 = string2.split("\\.");
        String[] str3 = string3.split("\\.");
        String[] str4 = string4.split("\\.");
        for (int i = 0; i < 3; i++) {
            if(judge(Integer.parseInt(str1[i]), Integer.parseInt(str2[i]), Integer.parseInt(str3[i]), Integer.parseInt(str4[i]))) {
                System.out.println("Overlap IP");
                return;
            }
        }
        if(judge2(Integer.parseInt(str1[3]), Integer.parseInt(str2[3]), Integer.parseInt(str3[3]), Integer.parseInt(str4[3]))) {
            System.out.println("Overlap IP");
            return;
        }
        System.out.println("No Overlap IP");
    }

    public static boolean judge2(int star1, int end1, int star2, int end2) {
        if ((star1 >= star2 && star1 <= end2) || (star2 >= star1 && star2 <= end1)) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean judge(int star1, int end1, int star2, int end2) {
        if ((star1 > star2 && star1 < end2) || (star2 > star1 && star2 < end1)) {
            return true;
        } else {
            return false;
        }
    }

}
