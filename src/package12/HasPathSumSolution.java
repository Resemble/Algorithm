package package12;


/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package package12
 * @Description:
 * https://leetcode-cn.com/problems/path-sum/submissions/
 * 112. 路径总和
 *
 * @date 2020-10-08 10:18
 */
public class HasPathSumSolution {

   public class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
   }
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        // 判断当前节点是否是叶子节点，是叶子节点判断和。不是叶子节点判断下一层
        if (root.left == null && root.right == null) {
            return sum == root.val;
        }
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

}
