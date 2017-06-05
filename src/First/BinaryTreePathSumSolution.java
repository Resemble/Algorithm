package First;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ranran
 * @version V1.0
 * @Title:
 * @Package First
 * @Description:
 * @date 2017/6/4 20:58
 */
public class BinaryTreePathSumSolution {

    public class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }


    /**
     * @param root   the root of binary tree
     * @param target an integer
     * @return all valid paths
     */
    public List<List<Integer>> binaryTreePathSum(TreeNode root, int target) {
        // Write your code here
        List<List<Integer>> resultTotal = new ArrayList<>();
        List<Integer> resultSingle = new ArrayList<>();
        search(root, target, resultTotal, resultSingle);
        return resultTotal;
    }

    private void search(TreeNode root, int target, List<List<Integer>> resultTotal, List<Integer> resultSingle) {

        if (root == null) {
            return;
        }

        target -= root.val;

        if(root.left == null && root.right == null & target == 0){
            resultSingle.add(root.val);
            resultTotal.add(resultSingle);
            return;
        }

        if (root.left != null) {
            List<Integer> left = new ArrayList<Integer>(resultSingle);
            left.add(root.val);
            search(root.left, target, resultTotal, left);
        }
        if (root.right != null) {
            List<Integer> right = new ArrayList<Integer>(resultSingle);
            right.add(root.val);
            search(root.right, target, resultTotal, right);
        }

    }

}
