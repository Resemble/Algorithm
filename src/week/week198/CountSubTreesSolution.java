package week.week198;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package week
 * @Description: 5465. 子树中标签相同的节点数
 * https://leetcode-cn.com/contest/weekly-contest-198/problems/number-of-nodes-in-the-sub-tree-with-the-same-label/
 * @date 2020-07-19 10:50
 */
public class CountSubTreesSolution {

    private List<Integer>[] g;
    private char[] labs;
    private boolean[] visited;
    private int[] ans;

    public int[] countSubTrees(int n, int[][] edges, String labels) {
        g = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
        }
        // 所有的都添加了，避免了方向问题
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            g[from].add(to);
            g[to].add(from);
        }
        labs = labels.toCharArray();
        visited = new boolean[n];
        ans = new int[n];
        dfs(0);
        return ans;
    }

    private int[] dfs(int root) {
        visited[root] = true;
        int[] res = new int[26];
        for (Integer son : g[root]) {
            if (visited[son]) {
                continue;
            }
            // 找到子节点
            int[] sub = dfs(son);
            for (int i = 0; i < 26; i++) {
                res[i] += sub[i];
            }
        }
        res[labs[root] - 'a']++;
        ans[root] = res[labs[root] - 'a'];
        return res;
    }



    // 暴力超时
    public int[] countSubTrees2(int n, int[][] edges, String labels) {
        for (int i = 0; i < edges.length; i++) {
            if (edges[i][1] == 0) {
                edges[i][1] = edges[i][0];
                edges[i][0] = 0;
            }

        }

        // 先排序，从序号末尾出发
        List<Integer> orderList = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            orderList.add(-999);
        }
        int[] newOrder = new int[n];
        int orderCnt = 0;
        for (int i = 0; i < edges.length; i++) {
            if (orderList.get(edges[i][0]) == -999) {
                orderList.set(edges[i][0], orderCnt);
                newOrder[orderCnt] = edges[i][0];
                orderCnt++;
            }
            if (orderList.get(edges[i][1]) == -999) {
                orderList.set(edges[i][1], orderCnt);
                newOrder[orderCnt] = edges[i][1];
                orderCnt++;
            }
        }
        for (int i = 0; i < edges.length; i++) {
            if (orderList.get(edges[i][0]) > orderList.get(edges[i][1])) {
                int temp = edges[i][0];
                edges[i][0] = edges[i][1];
                edges[i][1] = temp;
            }
        }

        int[] cntSameChar = new int[n];
        List<List<Character>> curCharCnt = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            curCharCnt.add(new ArrayList<>());
        }
        for (int i = n - 1; i >= 0; i--) {
            int cnt = 1;
            List<Character> curList = curCharCnt.get(newOrder[i]);
            for (int j = 0; j < edges.length; j++) {
                if (edges[j][0] == newOrder[i]) {
                    // 找到当前的子节点的 char 数字
                    List<Character> subList = curCharCnt.get(edges[j][1]);
                    curList.addAll(subList);
                }
            }
            Character curChar = labels.charAt(newOrder[i]);
            for (int j = 0; j < curList.size(); j++) {
                if (curChar.equals(curList.get(j))) {
                    cnt++;
                }
            }
            cntSameChar[newOrder[i]] = cnt;
            curList.add(curChar);
        }
        return cntSameChar;
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] edges = new int[3][2];
        String labels = "aeed";
        edges[0][0] = 0;
        edges[0][1] = 2;
        edges[1][0] = 0;
        edges[1][1] = 3;
        edges[2][0] = 1;
        edges[2][1] = 2;
        CountSubTreesSolution solution = new CountSubTreesSolution();
        int[] result = solution.countSubTrees(n, edges, labels);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }

    }

}
