package package11;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package package11
 * @Description: 102. 二叉树的层序遍历
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 * @date 2020-05-31 16:37
 */
public class LevelOrderSolution {

    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tempResult;
        if (root == null) {
            return result;
        }
        Queue<TreeNode> lastLevel = new LinkedList<>();
        Queue<TreeNode> thisLevel = new LinkedList<>();
        lastLevel.add(root);
        while (lastLevel.size() > 0 || thisLevel.size() > 0) {
            tempResult = new ArrayList<>();
            if (lastLevel.size() > 0) {
                while (lastLevel.size() > 0) {
                    TreeNode tempNode = lastLevel.poll();
                    if (tempNode.left != null) {
                        thisLevel.add(tempNode.left);
                    }
                    if (tempNode.right != null) {
                        thisLevel.add(tempNode.right);
                    }

                    tempResult.add(tempNode.val);
                }
            } else {
                while (thisLevel.size() > 0) {
                    TreeNode tempNode = thisLevel.poll();
                    if (tempNode.left != null) {
                        lastLevel.add(tempNode.left);
                    }
                    if (tempNode.right != null) {
                        lastLevel.add(tempNode.right);
                    }

                    tempResult.add(tempNode.val);
                }
            }
            result.add(tempResult);
        }
        return result;
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tempResult;
        if (root == null) {
            return result;
        }
        Queue<TreeNode> lastLevel = new LinkedList<>();
        lastLevel.add(root);
        while (lastLevel.size() > 0) {
            int count = lastLevel.size();
            tempResult = new ArrayList<>();
            while (count > 0) {
                TreeNode tempNode = lastLevel.poll();
                if (tempNode.left != null) {
                    lastLevel.add(tempNode.left);
                }
                if (tempNode.right != null) {
                    lastLevel.add(tempNode.right);
                }
                tempResult.add(tempNode.val);
                count--;
            }
            result.add(tempResult);
        }
        return result;
    }


}
