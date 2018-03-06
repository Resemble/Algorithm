package Sixth;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package Sixth
 * @Description:
 * @date 2018/3/5 上午9:47
 */

public class HasSubTreeSolution {

    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        boolean result = false;
        if(root1 != null && root2 != null) {
            if(root1.val == root2. val) {
                result = DoesTree1HaveTree2(root1, root2);
            }
            if(!result) {
                result = HasSubtree(root1.left, root2);
            }
            if(!result) {
                result = HasSubtree(root1.right, root2);
            }
        }
        return result;
    }

    public boolean DoesTree1HaveTree2(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 != null) return false;
        if(root2 == null) return true;
        if(root1.val != root2.val) return false;
        return DoesTree1HaveTree2(root1.left, root2.left) && DoesTree1HaveTree2(root1.right, root2.right);
    }


    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(8);
        TreeNode root2 = new TreeNode(8);
        TreeNode root3 = new TreeNode(7);
        TreeNode root4 = new TreeNode(9);
        TreeNode root5 = new TreeNode(2);
        TreeNode root6 = new TreeNode(4);
        TreeNode root7 = new TreeNode(7);
        root1.left = root2;
        root1.right = root3;
        root2.left = root4;
        root2.right = root5;
        root5.left = root6;
        root5.right = root7;
    }

}
