package ninth;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package ninth
 * @Description:
 * @date 2019-05-18 15:25
 */
public class FindSubtreeSolution {


    public class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }


    /**
     * @param root: the root of binary tree
     * @return: the maximum weight node
     */
    int maxSum = Integer.MIN_VALUE;
    TreeNode maxSubTreeNode;

    public TreeNode findSubtree(TreeNode root) {
        // write your code here
        subTreeSum(root);
        return maxSubTreeNode;
    }

    public int subTreeSum(TreeNode root) {
        if (root == null) {
            return 0;
        } else if (root.left == null && root.right == null) {
            if (root.val > maxSum) {
                maxSum = root.val;
                maxSubTreeNode = root;
            }
            return root.val;
        } else {
            int tempMax = root.val;
            if (root.left != null) {
                tempMax = tempMax + subTreeSum(root.left);
            }
            if (root.right != null) {
                tempMax = tempMax + subTreeSum(root.right);
            }
            if (tempMax > maxSum) {
                maxSum = tempMax;
                maxSubTreeNode = root;
            }
            return tempMax;
        }

    }


}
