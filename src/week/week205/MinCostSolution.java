package week.week205;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package week.week205
 * @Description:
 * @date 2020-09-06 11:44
 */
public class MinCostSolution {

    public int minCost(String s, int[] cost) {
        int costCnt = 0;
        Character lastChar = '0';
        int lastCost = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == lastChar) {
                costCnt = costCnt + Math.min(lastCost, cost[i]);
                lastCost = Math.max(lastCost, cost[i]);
            } else {
                lastCost = cost[i];
            }
            lastChar = s.charAt(i);
        }
        return costCnt;
    }

}
