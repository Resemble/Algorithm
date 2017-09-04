package Forth;

/**
 * @author ranran
 * @version V1.0
 * @Title:
 * @Package Forth
 * @Description:
 * 交叉字符串

    给出三个字符串:s1、s2、s3，判断s3是否由s1和s2交叉构成。


    您在真实的面试中是否遇到过这个题？ Yes
    样例
    比如 s1 = "aabcc" s2 = "dbbca"

    - 当 s3 = "aadbbcbcac"，返回  true.

    - 当 s3 = "aadbbbaccc"， 返回 false.
 * @date 2017/9/4 20:13
 */
public class IsInterleaveSolution {


    public static void main(String[] args) {
        String s1 = "sdfjas;dfjoisdufzjkndfasdkfja;sdfa;dfa;dfaskdjhfasdhjdfakhdgfkajdfasdjfgajksdfgaksdhfasdkbfjkdsfbajksdfhakjsdfbajkdfbakdjsfgaksdhgfjkdsghfkdsfgadsjfgkajsdgfkjasdfh";
        String s2 = "dfnakdjnfjkzghdufguweygfasjkdfgb2gf8asf7tgbgasjkdfgasodf7asdgfajksdfguayfgaogfsdkagfsdhfajksdvfbgkadsghfakdsfgasduyfgajsdkfgajkdghfaksdgfuyadgfasjkdvfjsdkvfakfgauyksgfajkefgjkdasgfdjksfgadjkghfajksdfgaskdjfgasjkdgfuyaegfasdjkfgajkdfygadjskfgjkadfg";
        String s3 = "sdfjas;dfjoisdfnakdjnfjkzghdufguwdufzjkeygfasjkdfgb2gf8asf7ndtgbgasjkdfgasodf7asdfgfajkasdksdfguayfgaogfsdkagfsfjadhfajksdvfbgkadsghfa;sdkdsfgasduyfgajsdkfgafajkdghfaksdgfuyadgfas;dfjkdvfjsdkvfakfgauyksa;dgfajkefgjkdasgfdjksffaskdjhfasdhjdfakhdgadjkghfajgfkajdfksdfgaskdjfgasjkdgfuasdjfgajksdfgaksdhfasdkbfjkdsfbajksdfyaegfasdjkfgajkdfygadjskfgjkadfghakjsdfbajkdfbakdjsfgaksdhgfjkdsghfkdsfgadsjfgkajsdgfkjasdfh";
        System.out.println(isInterleave(s1, s2, s3));
    }


    public static boolean isInterleave(String s1, String s2, String s3) {
        // write your code here
        int l1 = s1.length();
        int l2 = s2.length();
        int l3 = s3.length();

        if (l1 + l2 != l3) return false;

        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        char[] c3 = s3.toCharArray();

        boolean[][] result = new boolean[l1 + 1][l2 + 1];
        result[0][0] = true;
        for (int i = 0; i < l1; i++) {
            if (c1[i] == c3[i]) result[i + 1][0] = true;
            else break;
        }
        for (int i = 0; i < l2; i++) {
            if (c2[i] == c3[i]) result[0][i + 1] = true;
            else break;
        }

        for (int i = 1; i <= l1; i++) {
            char ci = c1[i - 1];
            for (int j = 1; j <= l2; j++) {
                char cj = c2[j - 1];
                char ck = c3[i + j - 1];
                result[i][j] = (result[i][j - 1] && cj == ck) || (result[i - 1][j] && ci == ck);
            }
        }

        return result[l1][l2];

    }

}
