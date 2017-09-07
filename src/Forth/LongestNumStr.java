package Forth;

import java.util.Scanner;

/**
 * @author ranran
 * @version V1.0
 * @Title:
 * @Package Forth
 * @Description: ]字符串中找出连续最长的数字串
 * @date 2017/9/7 10:56
 */
public class LongestNumStr {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(sc.nextLine());
//        stringBuilder.append("abcd12345ed125ss123456789");
        int max = Integer.MIN_VALUE;
        int minIndex = 0;
        int maxIndex = 0;
        int tempMinIndex = 0;
        int tempMaxIndex = 0;
        int tempLong = 0;
        for (int i = 0; i < stringBuilder.length(); i++) {
            if (Character.isDigit(stringBuilder.codePointAt(i))) {
                if (tempLong == 0) {
                    tempMinIndex = i;
                }
                tempMaxIndex = i;
                tempLong++;
                if (tempLong > max) {
                    minIndex = tempMinIndex;
                    maxIndex = tempMaxIndex;
                    max = tempLong;
                }
            } else {
                tempLong = 0;
            }
        }
        System.out.println(stringBuilder.substring(minIndex, maxIndex+1));
    }

}
