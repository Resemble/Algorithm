package tenth;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package tenth
 * @Description:
 * @date 2019-06-29 10:33
 */
public class CountOfSmallerNumberSolution {

    /**
     * @param A: An integer array
     * @param queries: The query list
     * @return: The number of element in the array that are smaller that the given integer
     */
    public List<Integer> countOfSmallerNumber(int[] A, int[] queries) {
        // write your code here
        List<Integer> resultList = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < queries.length; i++) {
            count = 0;
            for (int j = 0; j < A.length; j++) {
                if (A[j] < queries[i]) {
                    count++;
                }
            }
            resultList.add(count);
        }

        return resultList;
    }


}
