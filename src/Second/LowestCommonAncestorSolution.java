package Second;

import java.util.*;

/**
 * @author ranran
 * @version V1.0
 * @Title:
 * @Package Second
 * @Description: 求二叉树最低公共祖先
 * @date 2017/8/11 16:18
 */
public class LowestCommonAncestorSolution {

    public static TreeNode lowestCommonAncestorSolution(TreeNode root, TreeNode p, TreeNode q) {
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        parent.put(root, null);
        stack.push(root);

        while (!parent.containsKey(p) || !parent.containsKey(q)) {
            TreeNode node = stack.pop();
            if (node.left != null) {
                parent.put(node.left, node);
                stack.push(node.left);
            }
            if (node.right != null) {
                parent.put(node.right, node);
                stack.push(node.right);
            }
        }
        Set<TreeNode> ancestors = new HashSet<>();
        while (p != null) {
            ancestors.add(p);
            p = parent.get(p);
        }
        while (!ancestors.contains(q)) {
            q = parent.get(q);
        }
        return q;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        /**
         *      1
         *    /   \
         *   2     3
         *  / \     \
         * 4   6     5
         */

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node3.right = node5;
        node2.right = node6;
        System.out.println(lowestCommonAncestorSolution(node1, node4, node6).val);
        System.out.println(lowestCommonAncestorSolution(node1, node4, node5).val);
    }

}
