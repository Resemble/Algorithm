package Third;

/**
 * @author ranran
 * @version V1.0
 * @Title:
 * @Package Third
 * @Description: 二叉树镜像递归
 * @date 2017/8/31 9:32
 */
public class MirrorRecursiveSolution {

    private class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    public void Mirror(TreeNode root) {

        if (root == null) return;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        if (root.left != null) Mirror(root.left);
        if (root.right != null) Mirror(root.right);
    }


}
