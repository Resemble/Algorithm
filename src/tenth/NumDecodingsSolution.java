package tenth;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package tenth
 * @Description:
 * @date 2019-06-09 18:02
 */
public class NumDecodingsSolution {

    /**
     * @param s: a string,  encoded message
     * @return: an integer, the number of ways decoding
     */
    public int numDecodings(String s) {
        // write your code here
        if (s == null || "".equals(s)) {
            return 0;
        }
        int prepre = 0;
        int pre = 1;
        for (int i = 1; i <= s.length(); i++) {
            int cur = 0;
            if (s.charAt(i - 1) <= '9' && s.charAt(i - 1) >= '1') {
                cur = pre;
            }
            if (i > 1) {
                int v = Integer.valueOf(s.substring(i - 2, i));
                /* 19261001 解决这种 */
                if (v <= 26 && v >= 10) {
                    cur = cur + prepre;
                }
            }
            if (cur == 0) {
                return 0;
            }
            prepre = pre;
            pre = cur;
        }
        return pre;
    }

    public static void main(String[] args) {
        String s = "192611";
        // 1 ~ 26 就行
//        s = "201";
//        for (int i = 0; i < s.length(); i++) {
//
//            if (s.charAt(i) > '1') {
//                System.out.println(s.charAt(i));
//            }
//        }
        System.out.println(s.substring(0, 1));
        System.out.println(s.substring(1, 2));
        NumDecodingsSolution solution = new NumDecodingsSolution();
        int cnt = solution.numDecodings(s);
        System.out.println(cnt);
    }
}
