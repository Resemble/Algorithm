package week.week199;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package week.week199
 * @Description:
 * @date 2020-07-26 10:31
 */
public class RestoreStringSolution {

    public String restoreString(String s, int[] indices) {
        char[] result = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            result[indices[i]] = s.charAt(i);
        }
        return String.valueOf(result);
    }

}
