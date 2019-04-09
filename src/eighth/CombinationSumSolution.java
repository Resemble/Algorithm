package eighth;

import java.util.*;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package eighth
 * @Description:
 * @date 2019/4/7 9:45 PM
 */
public class CombinationSumSolution {

    /**
     * @param candidates: A list of integers
     * @param target: An integer
     * @return: A list of lists of integers
     */
    static List<List<Integer>> resultList = new ArrayList<>();
    Set<List<Integer>> resultSet = new HashSet<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // write your code here
        Arrays.sort(candidates);
        searchRight(candidates, target, new ArrayList<>(), 0);
        resultList.addAll(resultSet);
        return resultList;
    }

    public void searchRight(int[] candidates, int target, List<Integer> result, int beginIndex) {
        for (int i = beginIndex; i < candidates.length; i++) {
            target = target - candidates[i];
            result.add(candidates[i]);
            if (target == 0) {
                resultSet.add(result);
                return;
            } else if (target < 0) {
                return;
            } else {
                searchRight(candidates, target, new ArrayList<>(result), i);
                target += candidates[i];
                result.remove(result.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        CombinationSumSolution sumSolution = new CombinationSumSolution();
        int[] candidates = new int[] {2,2,3};
        int target = 5;
        sumSolution.combinationSum(candidates, target);
        for (int i = 0; i < resultList.size(); i++) {
            System.out.println("**************");
            for (int j = 0; j < resultList.get(i).size(); j++) {
                System.out.print(resultList.get(i).get(j) + " ");
            }
            System.out.println("");
        }
    }


}
