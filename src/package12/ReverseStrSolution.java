package package12;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package package12
 * @Description: 541. 反转字符串 II
 * @date 2020-10-18 09:49
 */
public class ReverseStrSolution {

    public String reverseStr(String s, int k) {

        char[] charStr = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            charStr[i] = s.charAt(i);
        }
        int beginIndex = 0;
        int endIndex = k < s.length() ? k - 1 : s.length() - 1;
        int tempBeginIndex = beginIndex;
        while (tempBeginIndex < s.length()) {
            if (endIndex > s.length() - 1) {
                endIndex = s.length() - 1;
            }
            for (int j = 0; j < (endIndex - beginIndex + 1) / 2; j++) {
                char temp = charStr[beginIndex + j];
                charStr[beginIndex + j] = charStr[endIndex - j];
                charStr[endIndex - j] = temp;
            }
            beginIndex = beginIndex + 2 * k < s.length() - 1 ? beginIndex + 2 * k : s.length() - 1;
            endIndex = endIndex + 2 * k < s.length() - 1 ? endIndex + 2 * k : s.length() - 1;
            tempBeginIndex = tempBeginIndex + 2 * k;
        }

        return String.valueOf(charStr);
    }

}
