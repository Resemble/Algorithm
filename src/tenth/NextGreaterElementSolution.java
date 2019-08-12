package tenth;

import java.util.Arrays;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package tenth
 * @Description:
 * @date 2019-08-12 23:21
 */
public class NextGreaterElementSolution {

    public int nextGreaterElement(int n) {
        if (n < 10) {
            return -1;
        }
        char[] map = (n + "").toCharArray();
        boolean flag = false;
        int index = 0;
        int size = map.length;
        for (int i = size - 2; i >= 0; i--) {
            for (int j = size - 1; j > i; j--) {
                if (map[j] > map[i]) {
                    char tmp = map[j];
                    map[j] = map[i];
                    map[i] = tmp;
                    flag = true;
                    index = i;
                    break;
                }
            }
            if (flag) {
                break;
            }
        }
        if (!flag) {
            return -1;
        }
        Arrays.sort(map,  index + 1, map.length);
        long val = Long.parseLong(new String(map));
        return (val <= Integer.MAX_VALUE) ? (int) val : -1;

    }

}
