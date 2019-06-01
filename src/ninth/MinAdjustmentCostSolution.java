package ninth;

import java.util.Arrays;
import java.util.List;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package ninth
 * @Description:
 * @date 2019-04-27 17:51
 */
public class MinAdjustmentCostSolution {

    /*
     * @param A: An integer array
     * @param target: An integer
     * @return: An integer
     */
    public int MinAdjustmentCost(List<Integer> A, int target) {
        // write your code here
        int length = A.size();
        if (length == 0 || length == 1) {
            return 0;
        } else if (length == 2) {
            int sub = Math.abs(A.get(0) - A.get(1));
            return sub > target ? sub - target : 0;
        }
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int temp;
        for (int i = 0; i < length; i++) {
            temp = A.get(i);
            max = Math.max(max, temp);
            min = Math.min(min, temp);
        }
        int sub = max - min;
        int[][] cost = new int[length][sub + 1];
        for (int i = 0; i < length; i++) {
            temp = A.get(i);
            for (int j = 0; j <= sub; j++) {
                cost[i][j] = Math.abs(temp - (j + min));
            }
        }


        int[][] adjustCost = new int[length][sub + 1];
        for (int i = 0; i < sub + 1; i++) {
            adjustCost[0][i] = cost[0][i];

        }
        for (int i = 1; i < length; i++) {
            for (int j = 0; j <= sub; j++) {
                int lastMinCost = Integer.MAX_VALUE;
                for (int k = -target; k <= target; k++) {
                    if (j + k <= sub && j + k >= 0) {
                        lastMinCost = Math.min(lastMinCost, adjustCost[i - 1][j + k]);
                    }
                }
                adjustCost[i][j] = lastMinCost + cost[i][j];

            }
        }

        int minCost = Integer.MAX_VALUE;
        for (int i = 0; i < sub + 1; i++) {
            minCost = Math.min(adjustCost[length - 1][i], minCost);
        }
        return minCost;
    }

    public static void main(String[] args) {
        List<Integer> A = Arrays.asList(1,4,2,3);
        int target = 1;
        MinAdjustmentCostSolution solution = new MinAdjustmentCostSolution();
        int minCost = solution.MinAdjustmentCost(A, target);
        System.out.println("*******");
        System.out.println(minCost);
    }


}
