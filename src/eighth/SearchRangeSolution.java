package eighth;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package eighth
 * @Description:
 * @date 2019/3/10 4:46 PM
 */
public class SearchRangeSolution {


    // Definition of TreeNode:
    public class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    private ArrayList<Integer> treeValue = new ArrayList<>();

    /**
     * @param root: param root: The root of the binary search tree
     * @param k1:   An integer
     * @param k2:   An integer
     * @return: return: Return all keys that k1<=key<=k2 in ascending order
     */
    public List<Integer> searchRange(TreeNode root, int k1, int k2) {
        // write your code here

        traversingTree(root, k1, k2);
        return treeValue;
    }


    public void traversingTree(TreeNode root, int k1, int k2) {
        if(root == null) return;
        if (root.left != null) {
            traversingTree(root.left, k1, k2);
        }

        int val = root.val;
        if (val >= k1 && val <= k2 ) {
            treeValue.add(root.val);
        }
        if (root.right != null) {
            traversingTree(root.right, k1, k2);
        }
    }

}
