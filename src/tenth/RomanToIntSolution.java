package tenth;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package tenth
 * @Description:
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 *
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 *
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * @date 2020-03-08 16:49
 */
public class RomanToIntSolution {

    static Map<String, Integer> romanToIntMap = new HashMap<>(16);
    static {
        romanToIntMap.put("I", 1);
        romanToIntMap.put("V", 5);
        romanToIntMap.put("X", 10);
        romanToIntMap.put("L", 50);
        romanToIntMap.put("C", 100);
        romanToIntMap.put("D", 500);
        romanToIntMap.put("M", 1000);
        romanToIntMap.put("IV", 4);
        romanToIntMap.put("IX", 9);
        romanToIntMap.put("XL", 40);
        romanToIntMap.put("XC", 90);
        romanToIntMap.put("CD", 400);
        romanToIntMap.put("CM", 900);
    }


    public int romanToInt(String s) {
        int romanInt = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i < s.length() - 1 && romanToIntMap.containsKey(s.substring(i, i + 2))) {
                romanInt += romanToIntMap.get(s.substring(i, i + 2));
                i++;
            } else {
                romanInt += romanToIntMap.get(s.substring(i, i + 1));
            }
        }
        return romanInt;
    }


}
