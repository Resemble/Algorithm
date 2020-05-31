package package11;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package package11
 * @Description: 中序遍历二叉树
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/32/trees-and-graphs/85/
 * @date 2020-05-31 17:28
 */
public class InorderTraversalSolution {

    List<Integer> result = new ArrayList<>();

    public List<Integer> inorderTraversal2(TreeNode root) {
        if (root == null) {
            return result;
        }
        if (root.left != null) {
            inorderTraversal2(root.left);
        }
        result.add(root.val);
        if (root.right != null) {
            inorderTraversal2(root.right);
        }
        return result;
    }



    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> inorderResult = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            if (!stack.isEmpty()) {
                root = stack.pop();
                inorderResult.add(root.val);
                // 最后一定 root = null，这样  while (root != null)  循环不会进入，达到弹出效果，666
                root = root.right;
            }
        }
        return inorderResult;
    }

    // 中序遍历非递归
    public static void inOrder2(TreeNode node) {
        Stack<TreeNode> stack = new Stack<>();
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            if (!stack.isEmpty()) {
                node = stack.pop();
                System.out.print(node.val + " ");
                node = node.right;
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
        /**
         *      1
         *    /   \
         *   2     3
         *  /       \
         * 4         5
         / \
         7   6
         */


        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node3.right = node5;
        node4.right = node6;
        node4.left = node7;
        InorderTraversalSolution solution = new InorderTraversalSolution();
        System.out.println(solution.inorderTraversal(node1));
    }
}
