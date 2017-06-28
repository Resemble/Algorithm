package First;

import java.util.Arrays;

/**
 * @author ranran
 * @version V1.0
 * @Title:
 * @Package First
 * @Description:给定两个字符串，请设计一个方法来判定
 * 其中一个字符串是否为另一个字符串的置换。
 * 置换的意思是，通过改变顺序可以使得两个字符串相等。
 * @date 2017/6/28 22:18
 */
public class StringPermutationSolution {

    public static void main(String[] args) {
        String A = "1bdfsd";
        String B = "fsd1bd";
        StringPermutationSolution stringPermutationSolution = new StringPermutationSolution();
        Boolean replacementResult = stringPermutationSolution.stringPermutation(A, B);
        System.out.println("replacementResult:" + replacementResult);
    }

    /**
     * @param A a string
     * @param B a string
     * @return a boolean
     */
    public boolean stringPermutation(String A, String B) {
        // Write your code here
        int aLength = A.length();
        int bLength = B.length();
        if (aLength != bLength) {
            return false;
        }
        char[] aStringChar = A.toCharArray();
        char[] bStringChar = B.toCharArray();
        Arrays.sort(aStringChar);
        Arrays.sort(bStringChar);

       if(Arrays.equals(aStringChar, bStringChar)) {
            return true;
       } else {
           return false;
       }
    }


}
