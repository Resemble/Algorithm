package ninth;

import java.util.*;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package ninth
 * @Description:
 * @date 2019-05-26 11:51
 */
public class CombineSolution {

    /**
     * @param n: Given the range of numbers
     * @param k: Given the numbers of combinations
     * @return: All the combinations of k numbers out of 1..n
     */

    static List<List<Integer>> resultList = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        // write your code here
        searchCombine(n, k, new ArrayList<>(), 1);
        return resultList;
    }


    public void searchCombine(int n, int k, List<Integer> result, int begin) {
        for (int i = begin; i <= n; i++) {
            k = k - 1;
            result.add(i);
            if (k == 0) {
                resultList.add(new ArrayList<>(result));
            } else if (k < 0) {
                return;
            }
            searchCombine(n, k, new ArrayList<>(result), i + 1);
            k = k + 1;
            result.remove(result.size() - 1);
        }
    }


    public static void main(String[] args) {
        CombineSolution solution = new CombineSolution();
        solution.combine(4, 2);
        for (int i = 0; i < resultList.size(); i++) {
            List<Integer> result = resultList.get(i);
            System.out.println(result);
        }

    }

}
