package package11;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package package11
 * @Description: 103. 二叉树的锯齿形层次遍历
 * https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/
 * @date 2020-06-02 23:13
 */
public class ZigzagLevelOrderSolution {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tempResult;
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.add(root);
        int cnt = 1;
        int levelCnt = 1;
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            tempResult = new ArrayList<>();
            while (cnt > 0) {
                TreeNode tempNode;
                if (levelCnt % 2 == 1) {
                    tempNode = stack1.pop();
                    if (tempNode.left != null) {
                        stack2.add(tempNode.left);
                    }
                    if (tempNode.right != null) {
                        stack2.add(tempNode.right);
                    }
                } else {
                    tempNode = stack2.pop();
                    if (tempNode.right != null) {
                        stack1.add(tempNode.right);
                    }
                    if (tempNode.left != null) {
                        stack1.add(tempNode.left);
                    }
                }
                tempResult.add(tempNode.val);
                cnt--;
            }
            levelCnt++;
            cnt = stack1.size() == 0 ? stack2.size() : stack1.size();
            result.add(tempResult);
        }
        return result;
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
        ZigzagLevelOrderSolution solution = new ZigzagLevelOrderSolution();
        System.out.println(solution.zigzagLevelOrder(node1));
    }

}
