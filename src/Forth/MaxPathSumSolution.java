package Forth;

/**
 * @author ranran
 * @version V1.0
 * @Title:
 * @Package Forth
 * @Description: 二叉树中的最大路径和
 * 给出一棵二叉树，寻找一条路径使其路径和最大，路径可以在任一节点中开始和结束（路径和为两个节点之间所在路径上的
 * 节点权值之和）
 * @date 2017/9/4 17:20
 */
public class MaxPathSumSolution {


    private static class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        node1.left = node2;
        node1.right = node3;
        System.out.println(maxPathSum(node1));
    }

    public static int maxSum = Integer.MIN_VALUE;
    public static int maxPathSum(TreeNode root) {
        // write your code here
        getMaxSum(root);
        return maxSum;
    }

    public static int getMaxSum(TreeNode root) {
        if (root == null) return Integer.MIN_VALUE;
        int left = 0;
        int right = 0;
        if (root.left != null) left = getMaxSum(root.left);
        if (root.right != null) right = getMaxSum(root.right);
        int tempMax = Math.max(root.val, root.val + Math.max(left, right));
        maxSum = Math.max(maxSum, tempMax);
        maxSum = Math.max(maxSum, root.val + left + right);
        return tempMax;
    }


}
