package package11;

import java.math.BigDecimal;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package package11
 * @Description: https://leetcode-cn.com/problems/string-to-integer-atoi/
 * 8. 字符串转换整数 (atoi)
 * @date 2020-06-19 17:31
 */
public class MyAtoiSolution {

    public int myAtoi(String str) {
        char[] chars = str.toCharArray();
        int n = chars.length;
        int idx = 0;
        while (idx < n && chars[idx] == ' ') {
            // 去掉前面的空格
            idx++;
        }
        if (idx == n) {
            // 去掉前面的空格就到末尾了
            return 0;
        }
        boolean negative = false;
        if (chars[idx] == '-') {
            // 遇到负号
            negative = true;
            idx++;
        } else if (chars[idx] == '+') {
            idx++;
        } else if (!Character.isDigit(chars[idx])) {
            // 其他符号
            return 0;
        }
        int ans = 0;
        while (idx < n && Character.isDigit(chars[idx])) {
            int digit = chars[idx] - '0';
            if (ans > (Integer.MAX_VALUE - digit) / 10) {
                // 本来应该是 ans * 10 + digit > Integer.MAX_VALUE
                // 但是 *10 和 +digit 都有可能越界，所有都移动到右边就可以了
                return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            ans = ans * 10 + digit;
            idx++;
        }
        return negative ? -ans : ans;
    }

    public int myAtoi2(String str) {
        if (str == null || "".equals(str)) {
            return 0;
        }

        while (str.length() > 0 && Character.isSpaceChar(str.charAt(0))) {
            str = str.substring(1);
        }
        if ("".equals(str)) {
            return 0;
        }

        boolean isSmallerThanZero = false;
        if (str.charAt(0) == '-') {
            str = str.substring(1);
            isSmallerThanZero = true;
        } else if (str.charAt(0) == '+') {
            str = str.substring(1);
        }
        BigDecimal result = new BigDecimal(String.valueOf(0));
        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i))) {
                result = result.multiply(new BigDecimal(10)).add(new BigDecimal(str.charAt(i) - '0'));
            } else {
                break;
            }
        }
        if (result.compareTo(new BigDecimal(Integer.MAX_VALUE)) == 1) {
            return isSmallerThanZero ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }
        return (isSmallerThanZero ? -result.intValue() : result.intValue());
    }

    public static void main(String[] args) {
//        long result = Integer.MAX_VALUE + 3;
//        System.out.println(result);
//        System.out.println((int) result);
//        int result2 = (int) result;
//        if (result == (int) result) {
//            System.out.println("相等");
//        } else {
//            System.out.println("不相等");
//        }
//        if (result == result2) {
//            System.out.println("相等");
//        } else {
//            System.out.println("不相等");
//        }
//        System.out.println(Integer.MAX_VALUE);
//        System.out.println(Integer.MAX_VALUE + 3);

//        MyAtoiSolution solution = new MyAtoiSolution();
//        System.out.println(solution.myAtoi("9223372036854775808"));
        char[] chars = new char[3];
        chars[0] = '3';
        int temp = '3' - '0';
        System.out.println(temp);
    }

}
