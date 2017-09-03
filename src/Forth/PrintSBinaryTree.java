package Forth;


import java.util.Stack;

/**
 * @author ranran
 * @version V1.0
 * @Title:
 * @Package Forth
 * @Description: S 形打印二叉树
 * @date 2017/9/3 20:54
 */
public class PrintSBinaryTree {

    static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }


    public static void printSTree(TreeNode root) {

        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();

        int currentLevel = 1;
        stack1.push(root);
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            if (currentLevel % 2 == 1) {
                TreeNode tempNode = stack1.pop();
                System.out.println(tempNode.val);
                if (tempNode.right != null)
                    stack2.push(tempNode.right);
                if (tempNode.left != null)
                    stack2.push(tempNode.left);
                if (stack1.isEmpty()) {
                    currentLevel++;
                }
            }
            else {
                TreeNode tempNode = stack2.pop();
                System.out.println(tempNode.val);
                if (tempNode.left != null)
                    stack1.push(tempNode.left);
                if (tempNode.right != null)
                    stack1.push(tempNode.right);

                if (stack2.isEmpty()) {
                    currentLevel++;
                }
            }

        }

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
        node3.left = node9;
        node3.right = node5;
        node4.right = node6;
        node4.left = node7;
        printSTree(node1);
    }
}
