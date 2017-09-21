package Sixth;

/**
 * @author ranran
 * @version V1.0
 * @Title:
 * @Package Sixth
 * @Description:
 * @date 2017/9/20 16:15
 */
public class AllSort {

    public static void main(String[] args) {
        String string = "abc";
        char[] chars = string.toCharArray();
        allSort(chars, 0, chars.length - 1);
    }

    public static void allSort(char[] chars, int begin, int end) {
        if(begin == end) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < chars.length; i++) {
                sb.append(chars[i]);
            }
            System.out.println(sb.toString());
        }
        char ch;
        for (int i = begin; i <= end; i++) {  // 全排列 swap 2次
            ch = chars[begin];
            chars[begin] = chars[i];
            chars[i] = ch;

            allSort(chars, begin+1, end);

            ch = chars[begin];
            chars[begin] = chars[i];
            chars[i] = ch;
        }
    }

}
