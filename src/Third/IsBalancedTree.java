package Third;


/**
 * @author ranran
 * @version V1.0
 * @Title:
 * @Package Third
 * @Description: 二叉平衡树判断
 * @date 2017/8/28 16:09
 */
public class IsBalancedTree {


    public static class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
//        System.out.println(IsBalanced_Solution(treeNode));
    }

    private boolean isBalanced = true;

    public boolean IsBalanced_Solution(TreeNode root) {
        getDepth(root);
        return isBalanced;
    }

    public int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = getDepth(root.left);
        int right = getDepth(root.right);
        if (Math.abs(left - right) > 1) {
            isBalanced = false;
        }
        return left > right ? left + 1 : right + 1;

    }

}
