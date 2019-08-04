package tenth;

import java.util.Arrays;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package tenth
 * @Description:
 * @date 2019-08-04 10:06
 */
public class LargestPerimeterSolution {

    public int largestPerimeter(int[] A) {
        if(A == null || A.length <= 2) {
            return 0;
        }
        Arrays.sort(A);
        int one;
        int two;
        int three;

        for (int i = A.length - 1; i >= 2; i--) {
            one = A[i];
            two = A[i - 1];
            three = A[i - 2];
            if (two + three > one) {
                return one + two + three;
            }
        }
        return 0;
    }


}
