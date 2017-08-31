package Third;

import java.util.Stack;

/**
 * @author ranran
 * @version V1.0
 * @Title:
 * @Package Third
 * @Description: 二叉树镜像栈实现非递归
 * @date 2017/8/31 10:30
 */
public class MirrorNoneRecursiveSolution2 {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static void Mirror(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) return;
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode tempRoot = stack.pop();
            TreeNode temp = tempRoot.left;
            tempRoot.left = tempRoot.right;
            tempRoot.right = temp;
            if (tempRoot.right != null) stack.push(tempRoot.right);
            if (tempRoot.left != null) stack.push(tempRoot.left);
        }

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        TreeNode left = new TreeNode(1);
        TreeNode right = new TreeNode(2);
        root.left = left;
        root.right = right;

        Mirror(root);

//        TreeNode tempRoot = root;
//        TreeNode temp = tempRoot.left;
//        tempRoot.left = tempRoot.right;
//        tempRoot.right = temp;
//
//        tempRoot = root.left;
//
//        System.out.println(root.left.val);
//        System.out.println(root.right.val);
//
//        System.out.println(root.val);
//        System.out.println(tempRoot.val);
    }

}
