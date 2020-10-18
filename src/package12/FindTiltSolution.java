package package12;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package package12
 * @Description: 563. 二叉树的坡度
 * @date 2020-10-18 10:50
 */
public class FindTiltSolution {

    int sum = 0;
    public int findTilt(TreeNode root) {
        findTiltHelper(root);
        return sum;
    }

    public int findTiltHelper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftSum = findTiltHelper(root.left);
        int rightSum = findTiltHelper(root.right);
        sum = sum + Math.abs(leftSum - rightSum);
        return leftSum + rightSum + root.val;
    }
}
