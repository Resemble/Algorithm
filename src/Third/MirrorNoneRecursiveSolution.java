package Third;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author ranran
 * @version V1.0
 * @Title:
 * @Package Third
 * @Description: 二叉树镜像非递归实现
 * @date 2017/8/31 9:41
 */
public class MirrorNoneRecursiveSolution {

    private class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    public void Mirror(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        if (root == null) return;
        queue.add(root);
        TreeNode tempRoot;
        while(!queue.isEmpty()) {
            tempRoot = queue.poll();
            TreeNode temp = tempRoot.left;
            tempRoot.left = tempRoot.right;
            tempRoot.right = temp;
            if (tempRoot.left != null) queue.add(tempRoot.left);
            if (tempRoot.right != null) queue.add(tempRoot.right);
        }
    }

}
