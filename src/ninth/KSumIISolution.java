package ninth;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package ninth
 * @Description: https://www.lintcode.com/problem/k-sum-ii/
 * @date 2019/4/13 10:45 AM
 */
public class KSumIISolution {

    /*
     * @param A: an integer array
     * @param k: a postive integer <= length(A)
     * @param target: an integer
     * @return: A list of lists of integer
     */
    static List<List<Integer>> resultList = new ArrayList<>();
    public List<List<Integer>> kSumII(int[] A, int k, int target) {
        // write your code here
        kSumCombination(A, k, target, new ArrayList<>(), 0);
        return resultList;
    }

    public void kSumCombination(int[] A, int k, int target, List<Integer> result, int beginIndex) {
        if (target == 0 && k == 0) {
            resultList.add(new ArrayList<>(result));
            return;
        } else if (target == 0 || k == 0) {
            return;
        }

        for (int i = beginIndex; i < A.length; i++) {
            if (target > 0 && k > 0) {
                if (target - A[i] >= 0) {
                    result.add(A[i]);
                    kSumCombination(A, k - 1, target - A[i], result, i + 1);
                    result.remove(result.size() - 1);
                } else {
                    kSumCombination(A, k, target, result, i + 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        KSumIISolution sumSolution = new KSumIISolution();
        int[] candidates = new int[] {1,2,3,4};
        int target = 5;
        sumSolution.kSumII(candidates, 2, target);
        for (int i = 0; i < resultList.size(); i++) {
            System.out.println("**************");
            for (int j = 0; j < resultList.get(i).size(); j++) {
                System.out.print(resultList.get(i).get(j) + " ");
            }
            System.out.println("");
        }
    }

}
