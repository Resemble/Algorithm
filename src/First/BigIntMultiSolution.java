package First;

import java.math.BigInteger;

/**
 * @author ranran
 * @version V1.0
 * @Title:
 * @Package First
 * @Description: 大数相乘
 * @date 2017/8/1 21:14
 */
public class BigIntMultiSolution {

    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String string1 = sc.nextLine();
//        String string2 = sc.nextLine();
        String string1 = "0";
        String string2 = "0";
        BigInteger bigInteger1 = new BigInteger(string1);
        BigInteger bigInteger2 = new BigInteger(string2);
        System.out.println("BigInteger:");
        System.out.println(bigInteger1.multiply(bigInteger2));
        System.out.println("bigDigitalMultiply:");
        System.out.println(bigDigitalMultiply(string1, string2));
        System.out.println("multiply:");
        System.out.println(multiply(string1, string2));
    }

    public static void getReverse(char[] chars) {
        int begin = 0;
        int end = chars.length - 1;
        char temp;
        while (begin <= end) {
            temp = chars[end];
            chars[end] = chars[begin];
            chars[begin] = temp;
            begin++;
            end--;
        }
    }


    public static String multiply(String string1, String string2) {
        // Write your code here
        char[] char1 = new StringBuilder(string1).reverse().toString().toCharArray();
        char[] char2 = new StringBuilder(string2).reverse().toString().toCharArray();

        int[] eachNum = new int[char1.length + char2.length];
        for (int i = 0; i < string1.length(); i++) {
            for (int j = 0; j < string2.length(); j++) {
                int intString1 = char1[i] - '0';
                int intString2 = char2[j] - '0';
                eachNum[i + j] = intString1 * intString2 + eachNum[i + j];
                if (eachNum[i + j] >= 10) {
                    eachNum[i + j + 1] = (eachNum[i + j] / 10) + eachNum[i + j + 1];
                    eachNum[i + j] = eachNum[i + j] % 10;
                }
            }
        }
//        System.out.println(Arrays.toString(eachNum));
        StringBuilder stringBuilder = new StringBuilder();
        boolean flag = true;
        for (int i = eachNum.length - 1; i >= 0; i--) {
            if (eachNum[i] != 0) {
                stringBuilder.append(eachNum[i]);
                flag = false;
            } else if (!flag) {
                stringBuilder.append(eachNum[i]);
            }
        }
        if (stringBuilder.toString().equals("")) {
            stringBuilder.append('0');
        }
        return stringBuilder.toString();

    }


    /**
     * 两个大数相乘
     *
     * @param a
     * @param b
     * @return
     */
    public static String bigDigitalMultiply(String a, String b) {
        //判断两字符串是否带有符号位，以及计算乘积的符号位
        char signA = a.charAt(0);
        char signB = b.charAt(0);
        char sign = '+';
        if (signA == '+' || signA == '-') {
            sign = signA;
            a = a.substring(1);
        }
        if (signB == '+' || signB == '-') {
            if (sign == -signB)
                sign = '+';
            else
                sign = '-';
            b = b.substring(1);
        }
        //将大数翻转，并转化为数组
        char[] aArray = new StringBuffer(a).reverse().toString().toCharArray();
        char[] bArray = new StringBuffer(b).reverse().toString().toCharArray();
        int aLength = aArray.length;
        int bLength = bArray.length;
        int length = aLength + bLength;
        int[] result = new int[length];
        //计算结果集合
        for (int i = 0; i < aLength; i++) {
            for (int j = 0; j < bLength; j++) {
                result[i + j] = result[i + j] + (aArray[i] - '0') * (bArray[j] - '0');
            }
        }
        //处理结果集合，如果大于10的则向高位产生进位
        for (int i = 0; i < length - 1; i++) {
            if (result[i] > 10) {
                result[i + 1] += result[i] / 10;
                result[i] %= 10;
            }

        }
        //把结果转化为正常序列
        StringBuffer sb = new StringBuffer();
        if (sign == '-')
            sb.append('-');
        boolean flag = true;
        for (int i = length - 1; i >= 0; i--) {
            if (result[i] == 0 && flag)
                continue;
            else
                flag = false;
            sb.append(result[i]);
        }
        if (sb.toString() == "")
            sb.append('0');
        return sb.toString();
    }
}
