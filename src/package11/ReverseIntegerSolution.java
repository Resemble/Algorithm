package package11;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package package11
 * @Description: 7. 整数反转
 * https://leetcode-cn.com/problems/reverse-integer/submissions/
 * @date 2020-06-19 16:20
 */
public class ReverseIntegerSolution {

    // x是负数，x % 10 还是负数
    public int reverse(int x) {
        long n = 0l;
        while (x != 0) {
            n = n * 10 + x % 10;
            x = x / 10;
        }
        return (int) n == n ? (int)n : 0;
    }

    public int reverse2(int x) {
        char[] s = (x + "").toCharArray();
        reverseString(s);

        long result = 0l;
        for (int i = 0; i < s.length; i++) {
            if (s[i] == '-') {
                result = -result;
            } else {
                result = 10 * result + Integer.parseInt(String.valueOf(s[i]));
            }
        }
        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
            return 0;
        }
        return (int) result;
    }


    public void reverseString(char[] s) {
        for (int i = 0; i < s.length / 2; i++) {
            swap(s, i, s.length - 1 - i);
        }
    }

    public void swap(char[] s, int left, int right) {
        char temp = s[left];
        s[left] = s[right];
        s[right] = temp;
    }

    public static void main(String[] args) {
        ReverseIntegerSolution solution = new ReverseIntegerSolution();
        int x = -123;
        System.out.println(solution.reverse(x));
    }

}
