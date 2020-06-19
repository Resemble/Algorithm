package package11;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package package11
 * @Description: 38. 外观数列
 * https://leetcode-cn.com/problems/count-and-say/
 * @date 2020-06-19 19:00
 */
public class CountAndSaySolution {

    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        n--;
        StringBuilder builder = new StringBuilder();
        StringBuilder tempBuilder = new StringBuilder();
        builder.append("1");
        for (int i = 0; i < n; i++) {
            int cnt = 0;
            char tempChar = builder.charAt(0);
            for (int j = 0; j < builder.length(); j++) {
                if (tempChar == builder.charAt(j)) {
                    cnt++;
                } else {
                    // 不相等
                    tempBuilder.append(cnt).append(tempChar);
                    tempChar = builder.charAt(j);
                    cnt = 1;
                }
            }
            tempBuilder.append(cnt).append(tempChar);
            builder = new StringBuilder(tempBuilder);
            tempBuilder = new StringBuilder();
        }
        return builder.toString();
    }

}
