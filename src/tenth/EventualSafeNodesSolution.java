package tenth;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package tenth
 * @Description: 802. 找到最终的安全状态
 * @date 2019-09-21 10:00
 */
public class EventualSafeNodesSolution {

    /** 0未访问，1已访问，2安全，3成环 */
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> ans = new ArrayList<>();
        int n = graph.length;
        int[] type = new int[n];
        for (int i = 0; i < n; i++) {
            if (DFS(graph, i, type) == 2) {
                ans.add(i);
            }
        }
        return ans;
    }

    public int DFS(int[][] graph, int index, int[] type) {
        /** 已访问说明成环 */
        if (type[index] == 1) return 3;
        /** 多了一个2 return false 减少查询 */
        if (type[index] != 0) return type[index];
        type[index] = 1;
        for (int i : graph[index]) {
            if (DFS(graph, i, type) == 3) {
                type[i] = 3;
                return 3;
            }
        }
        type[index] = 2;
        return 2;
    }



}
