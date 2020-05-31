package package11;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package package11
 * @Description:  二叉树的最大深度
 * https://leetcode-cn.com/explore/featured/card/top-interview-questions-easy/7/trees/47/
 * @date 2020-05-31 11:14
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}


public class MaxDepthSolution {

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = root.left == null ? 1 : 1 + maxDepth(root.left);
        int rightDepth = root.right == null ? 1 : 1 + maxDepth(root.right);
        return Math.max(leftDepth, rightDepth);
    }

}
