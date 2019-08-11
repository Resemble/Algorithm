package tenth;

import java.util.HashSet;
import java.util.Set;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package tenth
 * @Description: 983. 最低票价
 * @date 2019-08-11 17:10
 */
public class MincostTicketsSolution {

    Integer[] memo;
    Set<Integer> dayset;

    public int mincostTickets(int[] days, int[] costs) {
        memo = new Integer[366];
        dayset = new HashSet<>();
        for (int i = 0; i < days.length; i++) {
            dayset.add(days[i]);
        }
        return dp(1, costs);
    }

    public int dp(int i, int[] costs) {
        if (i > 365) {
            return 0;
        }
        if (memo[i] != null) {
            return memo[i];
        }
        int ans;
        if (dayset.contains(i)) {
            ans = Math.min(dp(i + 1, costs) + costs[0],  dp(i + 7, costs) + costs[1]);
            ans = Math.min(ans, dp(i + 30 , costs) + costs[2]);
        } else {
            ans = dp(i + 1, costs);
        }
        memo[i] = ans;
        return ans;
    }

}
