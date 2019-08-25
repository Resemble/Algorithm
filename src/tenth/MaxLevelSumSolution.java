package tenth;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package tenth
 * @Description: 1161. 最大层内元素和
 * @date 2019-08-25 15:55
 */
public class MaxLevelSumSolution {

    int maxLevel = 0;
    int maxSum = Integer.MIN_VALUE;
    int tempLevel = 0;
    Queue<TreeNode> oneQueue = new LinkedBlockingQueue<>();
    Queue<TreeNode> twoQueue = new LinkedBlockingQueue<>();

    public int maxLevelSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        oneQueue.add(root);
        /** 层次遍历，取最大的替换 */
        search();
        return maxLevel;
    }

    public void search() {
        if (oneQueue.isEmpty() && twoQueue.isEmpty()) {
            return;
        } else {
            tempLevel = tempLevel + 1;
            int tempSum = 0;
            if (!oneQueue.isEmpty()) {
                while (!oneQueue.isEmpty()) {
                    TreeNode root = oneQueue.poll();
                    tempSum = tempSum + root.val;
                    if (root.left != null) {
                        twoQueue.add(root.left);
                    }
                    if (root.right != null) {
                        twoQueue.add(root.right);
                    }
                }
            } else {
                while (!twoQueue.isEmpty()) {
                    TreeNode root = twoQueue.poll();
                    tempSum = tempSum + root.val;
                    if (root.left != null) {
                        oneQueue.add(root.left);
                    }
                    if (root.right != null) {
                        oneQueue.add(root.right);
                    }
                }
            }
            if (tempSum > maxSum) {
                maxLevel = tempLevel;
                maxSum = tempSum;
            }
        }
        search();
    }

}
