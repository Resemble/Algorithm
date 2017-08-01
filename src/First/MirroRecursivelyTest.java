package First;

/**
 * @author ranran
 * @version V1.0
 * @Title:
 * @Package First
 * @Description: 求二叉树的镜像
 * @date 2017/7/31 22:49
 */
public class MirroRecursivelyTest {

    public class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    public void mirrorRecursive (TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        if (treeNode.left == null && treeNode.right == null) {
            return;
        }
        TreeNode treeNodeTemp = treeNode.left;
        treeNode.right = treeNode.left;
        treeNode.left = treeNode.right;
        if (treeNode.left != null) {
            mirrorRecursive(treeNode.left);
        }
        if (treeNode.right != null) {
            mirrorRecursive(treeNode.right);
        }

    }
}
