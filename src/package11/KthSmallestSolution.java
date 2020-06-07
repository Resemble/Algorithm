package package11;

import java.util.Stack;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package package11
 * @Description: 230. 二叉搜索树中第K小的元素
 * https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst/
 * @date 2020-06-07 10:32
 */
public class KthSmallestSolution {

    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            // 这个 if 用的好
            if (!stack.isEmpty()) {
                root = stack.pop();
                k--;
                if (k == 0) {
                    return root.val;
                }
                root = root.right;
            }

        }
        return 0;
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
        KthSmallestSolution solution = new KthSmallestSolution();
        System.out.println(solution.kthSmallest(node1, 3));
    }

}
