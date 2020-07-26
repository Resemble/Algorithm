package week.week199;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package week.week199
 * @Description:
 * @date 2020-07-26 11:37
 */
 class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}



public class CountPairsSolution {

     int cnt = 0;
    public int countPairs2(TreeNode root, int distance) {
        countLength(root, distance);
        return cnt;
    }

    public List<Integer> countLength(TreeNode root, int distance) {
        List<Integer> result = new ArrayList<>();
        if (root.left == null && root.right == null) {
            result.add(0);
            return result;
        }
        List<Integer> leftList = new ArrayList<>();
        List<Integer> rightList = new ArrayList<>();
        if (root.left != null) {
           leftList = countLength(root.left, distance);
            for (int i = 0; i < leftList.size(); i++) {
                leftList.set(i, leftList.get(i) +  1);
            }
        }
        if (root.right != null) {
            rightList = countLength(root.right, distance);
            for (int i = 0; i < rightList.size(); i++) {
                rightList.set(i, rightList.get(i) +  1);
            }
        }
        if (root.left != null && root.right != null) {
            for (int i = 0; i < leftList.size(); i++) {
                for (int j = 0; j < rightList.size(); j++) {
                    if (leftList.get(i) + rightList.get(j) <= distance) {
                        cnt++;
                    }
                }
            }
        }
        result.addAll(leftList);
        result.addAll(rightList);
        return result;
    }

    private int distance = 0;
    private int res = 0;

    public int countPairs(TreeNode root, int distance) {
        this.distance = distance;
        dfs(root);
        return res;
    }

    // 自底向上的递归，用 dis[i] 的意义是记录距离为 i 的有多少个叶子节点
    private int[] dfs(TreeNode node) {
        if (node == null) {
            return new int[distance + 1];
        }
        // dis[i] 的意义是记录距离为 i 的有多少个叶子节点
        int[] dis = new int[distance + 1];
        if (node.left == null && node.right == null) {
            dis[1] = 1;
            return dis;
        }
        int[] left = dfs(node.left);
        int[] right = dfs(node.right);
        // 计算组合数
        for (int i = 1; i < distance; i++) {
            // 多于 distance 的不用考虑
            for (int j = 1; j <= distance - i; j++) {
                res = res + left[i] * right[j];
            }
        }
        // 向上返回距离 + 1
        for (int i = 2; i <= distance; i++) {
            dis[i] = left[i - 1] + right[i - 1];
        }
        return dis;
    }

    public static void main(String[] args) {
        // [1,1,1] 2
        // root = [1,2,3,4,5,6,7], distance = 3
        // [1,84,null,80,61]
        // 2
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(84);
        root.right = null;
        root.left.left = new TreeNode(80);
        root.left.right = new TreeNode(61);
//        root.right.left = new TreeNode(6);
//        root.right.right = new TreeNode(7);
        CountPairsSolution countPairsSolution = new CountPairsSolution();
        int count = countPairsSolution.countPairs(root, 2);
        System.out.println(count);
    }

}
