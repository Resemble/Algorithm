package eighth;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package eighth
 * @Description:
 * @date 2019/4/7 10:57 AM
 */
public class CompareStringsSolution {
    /**
     * @param A: A string
     * @param B: A string
     * @return: if string A contains all of the characters in B return true else return false
     */
    public boolean compareStrings(String A, String B) {
        // write your code here
        if ("".equals(B)) {
            return true;
        }
        if ("".equals(A)){
            return false;
        }
        char[] a = A.toCharArray();
        char[] b = B.toCharArray();
        int tempValue;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            if (map.get(a[i]) == null) {
                map.put(a[i], 1);
            } else {
                tempValue = map.get(a[i]);
                map.put(a[i], tempValue + 1);
            }
        }

        for (int i = 0; i < b.length; i++) {
            if (map.get(b[i]) == null) {
                return false;
            } else {
                tempValue = map.get(b[i]);
                if (tempValue == 0) {
                    return false;
                } else {
                    map.put(b[i], tempValue - 1);
                }
            }
        }

        return true;
    }


}
