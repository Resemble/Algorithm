package Forth;

/**
 * @author ranran
 * @version V1.0
 * @Title:
 * @Package Forth
 * @Description: 二叉树深度
 * @date 2017/9/4 15:11
 */
public class GetTheDepthOfTreeNode {

    static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static int getTheDepth(TreeNode root) {
        if (root == null) return 0;
        int left = 0;
        int right = 0;
        if (root.left != null) left = getTheDepth(root.left);
        if (root.right != null) right = getTheDepth(root.right);
        return left > right ? left + 1 : right + 1;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
        TreeNode node9 = new TreeNode(9);
        /**
         *      1
         *    /   \
         *   2     3
         *  / \   / \
         * 4   8  9  5
         / \
         7   6
         */

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node8;
//        node3.left = node9;
        node3.right = node5;
//        node4.right = node6;
        node4.left = node7;
        System.out.println(getTheDepth(node1));
    }

}
