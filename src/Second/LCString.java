package Second;

/**
 * @author ranran
 * @version V1.0
 * @Title:
 * @Package Second
 * b　　a　　b
 * <p>
 * c　　0　　0　　0
 * <p>
 * a　　0　　1　　0
 * <p>
 * b　　1　　0　　2
 * <p>
 * a　　0　　2　　0
 * @Description: 最长公共子串 二维矩阵
 * @date 2017/7/10 17:49
 */
public class LCString {


    public static void getLCString(char[] str1, char[] str2) {

        int len1, len2;
        len1 = str1.length;
        len2 = str2.length;
        int maxLen = len1 > len2 ? len1 : len2;
        int[] max = new int[maxLen];
        int[] maxIndex = new int[maxLen];
        int[] c = new int[maxLen];  // 记录对角线上相等值的个数
//            for (int j = 0; j < len1; j++) {

        for (int i = 0; i < len2; i++) {
            for (int j = len1 - 1; j >= 0; j--) {
                if (str2[i] == str1[j]) {
                    if ((i == 0) || (j == 0)) {
                        c[j] = 1;
                    } else {
                        c[j] = c[j - 1] + 1;
                    }
                } else {
                    c[j] = 0;
                }

                if (c[j] > max[0]) { // 如果是大于那暂时只有一个是最长的,而且要把后面的清0;
                    max[0] = c[j];  // 记录对角线元素的最大值，之后在遍历时用作提取子串的长度
                    maxIndex[0] = j;

                    for (int k = 1; k < maxLen; k++) {
                        max[k] = 0;
                        maxIndex[k] = 0;
                    }
                } else if (c[j] == max[0]) { // 有多个相同长度的子串
                    for (int k = 1; k < maxLen; k++) {
                        if (max[k] == 0) {
                            max[k] = c[j];
                            maxIndex[k] = j;
                            break; // 在后面加一个就退出循环
                        }
                    }
                }

            }
        }


        for (int i = 0; i < maxLen; i++) {
            if (max[i] > 0) {
                System.out.println("第" + (i + 1) + "个公共子串:");
                for (int j = maxIndex[i] - max[i] + 1; j <= maxIndex[i]; j++) {
                    System.out.print(str1[j]);
                }
                System.out.println(" ");
            }
        }



    }


    public static void main(String[] args) {
        String str1 = new String("12345abc234fdf");
        String str2 = new String("1234fds5abc2f34fdf");
        getLCString(str1.toCharArray(), str2.toCharArray());
    }
}
