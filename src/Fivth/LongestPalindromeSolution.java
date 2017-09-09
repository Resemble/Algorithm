package Fivth;

import java.util.HashMap;

/**
 * @author ranran
 * @version V1.0
 * @Title:
 * @Package Fivth
 * @Description: 最长回文串
 * 给出一个包含大小写字母的字符串。求出由这些字母构成的最长的回文串的长度是多少。
    数据是大小写敏感的，也就是说，"Aa" 并不会被认为是一个回文串。
 * @date 2017/9/9 11:21
 */
public class LongestPalindromeSolution {

    public static void main(String[] args) {
        String s = "abccccdd";
        System.out.println(longestPalindrome(s));
    }

    public static int longestPalindrome(String s) {
        // write your code here

        char[] chars = s.toCharArray();
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            if (hashMap.get(chars[i]) == null) {
                hashMap.put(chars[i], 1);
            } else {
                int value = hashMap.get(chars[i]);
                value++;
                hashMap.put(chars[i], value);
            }
        }

        int oddSign = 0;
        int count = 0;
        for (int value : hashMap.values()) {
            if (value % 2 == 1){
                oddSign++;
            }
            count += value / 2;
        }

        return oddSign == 0 ? count*2: count*2 + 1;

    }
}
