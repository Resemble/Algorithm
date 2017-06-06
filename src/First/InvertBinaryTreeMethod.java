package First;

/**
 * @author ranran
 * @version V1.0
 * @Title:
 * @Package First
 * @Description: 翻转一棵二叉树
 * @date 2017/6/6 21:48
 */
public class InvertBinaryTreeMethod {

    public class TreeNode {
        public int val;
        public TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    /**
     * @param root: a TreeNode, the root of the binary tree
     * @return: nothing
     */
    public void invertBinaryTree(TreeNode root) {
        // write your code here
        if(root.left == null && root.right == null) {
            return;
        } else {
            if(root.left != null) {
                invertBinaryTree(root.left);
            }
            if(root.right != null) {
                invertBinaryTree(root.right);
            }
            TreeNode treeNodeLeft = root.left;
            TreeNode treeNodeRight  = root.right;
            root.right = treeNodeLeft;
            root.left = treeNodeRight;
        }
    }

}
