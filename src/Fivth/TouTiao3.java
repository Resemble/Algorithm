package Fivth;

import java.util.Scanner;

/**
 * @author ranran
 * @version V1.0
 * @Title:
 * @Package Fivth
 * @Description:
 * @date 2017/9/10 20:47
 */
public class TouTiao3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String string = sc.nextLine();
        char[] chars = string.toCharArray();
        int n = sc.nextInt();
        int[][] dp = new int[n][n];

        System.out.println(getNum(chars) + 1);
    }

    public static int  getNum(char[] chars) {
        int max = 0;
        int count = 0;
        char temp = chars[0];
        for (int i = 1; i < chars.length; i++) {
            if (temp == chars[i]){
                count++;
                max = Math.max(max, count);
            } else {
                count = 0;
                temp = chars[i];
            }
        }
        return max;
    }

}
