package ninth;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package ninth
 * @Description:
 * @date 2019-06-03 22:49
 */
public class NthUglyNumberSolution {

    /**
     * @param n: An integer
     * @return: return a  integer as description.
     */
    public int nthUglyNumber(int n) {
        // write your code here
        if (n <= 0) {
            return -1;
        }

        List<Integer> uglyList = new ArrayList<>();
        uglyList.add(1);
        /* p2、p3、p5都是一个 uglyList 的指针，指向一个较小的数 */
        int p2 = 0;
        int p3 = 0;
        int p5 = 0;

        for (int i = 1; i < n; i++) {
            /* 初始的数 */
            int last = uglyList.get(i - 1);
            if (uglyList.get(p2) * 2 == last) {
                p2++;
            }
            if (uglyList.get(p3) * 3 == last) {
                p3++;
            }
            if (uglyList.get(p5) * 5 == last) {
                p5++;
            }
            int min = Math.min(uglyList.get(p2) * 2, uglyList.get(p3) * 3);
            min = Math.min(min, uglyList.get(p5) * 5);
            uglyList.add(min);
        }
        return uglyList.get(n - 1);
    }

}
