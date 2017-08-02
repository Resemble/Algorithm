package First;

/**
 * @author ranran
 * @version V1.0
 * @Title:
 * @Package First
 * @Description: 大数相加
 * @date 2017/8/2 12:28
 */
public class BigIntAddSolution {

    public static void main(String[] args) {
        String string1 = "9";
        String string2 = "99";
        System.out.println(addStrings(string1, string2));
    }

    /**
     * 2个大数相加
     * @param num1
     * @param num2
     * @return
     */
    public static String addStrings(String num1, String num2) {
        // Write your code here
        char[] chars1 = new StringBuilder(num1).reverse().toString().toCharArray();
        char[] chars2 = new StringBuilder(num2).reverse().toString().toCharArray();
        char[] charsBig;
        char[] charsSmall;
        int[] sum;
        if (chars1.length > chars2.length) {
            charsBig = chars1;
            charsSmall = chars2;
        } else {
            charsBig = chars2;
            charsSmall = chars1;
        }
        sum = new int[charsBig.length + 1];

        for (int i = 0; i < charsSmall.length; i++) {
            sum[i] += ((int)charsBig[i] - '0') + ((int)charsSmall[i] - '0');
            if (sum[i] >= 10) {
                sum[i + 1] += (sum[i] / 10);
                sum[i] = sum[i] % 10;
            }
        }
        for (int i = charsSmall.length; i < charsBig.length; i++) {
            sum[i] += ((int)charsBig[i] - '0');
            if (sum[i] >= 10) {
                sum[i + 1] += (sum[i] / 10);
                sum[i] = sum[i] % 10;
            }

        }

//        System.out.println(Arrays.toString(sum));
        return getStringFromArrays(sum);

    }

    /**
     * 从 Arrays 中转成 String
     * @param sum
     * @return
     */
    public static String getStringFromArrays (int[] sum) {
        StringBuilder stringBuilderSum = new StringBuilder();
        System.out.println(stringBuilderSum);
        boolean flag = true;
        for (int i = sum.length - 1; i >= 0; i--) {
            if (sum[i] != 0) {
                stringBuilderSum.append(sum[i]);
                flag = false;
            } else if (!flag) {
                stringBuilderSum.append(sum[i]);
            }
        }
        if (stringBuilderSum.toString().equals("")) {
            stringBuilderSum.append("0");
        }
        return stringBuilderSum.toString();

    }

}
