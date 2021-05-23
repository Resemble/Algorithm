package package12;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package package12
 * @Description: 199. 二叉树的右视图
 * https://leetcode-cn.com/problems/binary-tree-right-side-view/
 * @date 5/23/21 3:54 PM
 */
public class RightSideViewSolution {




    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> nodeQueue = new LinkedBlockingQueue<>();
        nodeQueue.add(root);
        int currentLineCnt = 0;
        int lastLineCnt = 1;
        while (!nodeQueue.isEmpty()) {
            TreeNode tempNode = nodeQueue.poll();
            if (tempNode.left != null) {
                currentLineCnt++;
                nodeQueue.add(tempNode.left);
            }
            if (tempNode.right != null) {
                currentLineCnt++;
                nodeQueue.add(tempNode.right);
            }
            lastLineCnt = lastLineCnt - 1;
            if (lastLineCnt == 0) {
                result.add(tempNode.val);
                lastLineCnt = currentLineCnt;
                currentLineCnt = 0;
            }
        }

        return result;
    }


    // [1,null,2,null,5,4,6,3]
    // [1,2,5,6]
    // [1,2,5,6,3]
    // 上面的测试用例无法通过，没有考虑到这种情况，右边下面左边的节点更长
    public List<Integer> rightSideView2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        getRightSideNode(root, result);
        List<Integer> leftResult = new ArrayList<>();
        if (root.left != null) {
            getRightSideNode(root.left, leftResult);
        }
        // result n 3，leftResult 5 那左边就比右边多 5 - 3 + 1 = 3个数字
        for (int i = result.size() - 1; i < leftResult.size(); i++) {
            result.add(leftResult.get(i));
        }
        return result;
    }

    public void getRightSideNode(TreeNode root, List<Integer> result) {
        if (root != null) {
            result.add(root.val);
        } else {
            return;
        }
        if (root.right != null) {
            getRightSideNode(root.right, result);
        } else {
            getRightSideNode(root.left, result);
        }
    }


}
