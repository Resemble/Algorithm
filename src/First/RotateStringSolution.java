package First;

import java.util.TreeSet;

/**
 * @author ranran
 * @version V1.0
 * @Title:
 * @Package First
 * @Description: 给定一个字符串和一个偏移量，根据偏移量旋转字符串(从左向右旋转)
 * @date 2017/8/1 10:16
 */
public class RotateStringSolution {

    public static void rotateString(char[] str, int offset) {
        // write your code here
        int length = str.length;
        int tempIndex = 0;
        if (offset < 0 || length == 0) {
            return;
        }
        offset = offset % length;
        char[] temp = new char[offset];

        for (int i = length - 1 - offset + 1; i < length; i++) {
            temp[tempIndex] = str[i];
            tempIndex++;
        }
//        for (int i = 0; i < temp.length; i++) {
//            System.out.print("temp[" + i + "]:" + temp[i]);
//            System.out.println();
//        }

        for (int i = length - 1; i >= offset; i--) {
            str[i] = str[i - offset ];
        }
        for (int i = 0; i < temp.length; i++) {
            str[i] = temp[i];
        }
    }

    public static void main(String[] args) {
        char[] str = {'a', 'b', 'c', 'd', 'e', 'f', 'g'};
        int offset = 3;
        rotateString(str, offset);
        System.out.println(str);
    }

}
