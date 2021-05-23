package package12;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package package12
 * @Description: 402. 移掉K位数字
 * https://leetcode-cn.com/problems/remove-k-digits/
 * @date 5/23/21 5:17 PM
 */
public class RemoveKdigitsSolution {

    // 从左到右，找到第一个比后面大的字符，删除，清零，k次扫描


    public String removeKdigits(String num, int k) {
        if (num.length() == 0) {
            return "0";
        }
        StringBuilder s = new StringBuilder(num);
        for (int i = 0; i < k; i++) {
            // 这个 for 循环最后一位删除不掉，比如
            // "10001"
            //  4
//            for (int j = 1; j < s.length(); j++) {
//                if (s.charAt(j) < s.charAt(j - 1)) {
//                    s.deleteCharAt(j - 1);
//                    System.out.println("s:" + s);
//                    break;
//                }
//            }
            // 最后一位可以删除
            int idx = 0;
            for (int j = 1; j < s.length() && s.charAt(j) >= s.charAt(j - 1); j++) {
                idx = j;
            }
            s.delete(idx, idx + 1);
            while (s.length() > 1 && s.charAt(0) == '0') {
                s.deleteCharAt(0);
            }
        }
        if (s.length() == 0) {
            return "0";
        }
        return s.toString();
    }

}
