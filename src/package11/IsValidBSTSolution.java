package package11;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package package11
 * @Description: 98. 验证二叉搜索树
 * https://leetcode-cn.com/problems/validate-binary-search-tree/
 * @date 2020-05-31 11:23
 */

public class IsValidBSTSolution {

    class Result {
        int max;
        int min;
        boolean isValid;

        public Result(int max, int min, boolean isValid) {
            this.max = max;
            this.min = min;
            this.isValid = isValid;
        }

        public int getMax() {
            return max;
        }

        public void setMax(int max) {
            this.max = max;
        }

        public int getMin() {
            return min;
        }

        public void setMin(int min) {
            this.min = min;
        }

        public boolean isValid() {
            return isValid;
        }

        public void setValid(boolean valid) {
            isValid = valid;
        }
    }

    public boolean isValidBST2(TreeNode root) {

        return isValidBSTHelper(root).isValid;
    }


    public Result isValidBSTHelper(TreeNode root) {
        if (root == null) {
            return new Result(Integer.MIN_VALUE, Integer.MAX_VALUE, true);
        }
        Result leftIsValidBST;
        Result rightIsValidBST;

        leftIsValidBST = isValidBSTHelper(root.left);
        rightIsValidBST = isValidBSTHelper(root.right);
        if (root.left != null) {
            if (leftIsValidBST.max >= root.val) {
                return new Result(Integer.MIN_VALUE, Integer.MAX_VALUE, false);
            }
        }
        if (root.right != null) {
            if (rightIsValidBST.min <= root.val) {
                return new Result(Integer.MIN_VALUE, Integer.MAX_VALUE, false);
            }
        }
        return new Result(Math.max(Math.max(leftIsValidBST.max, rightIsValidBST.max), root.val), Math.min(Math.min(leftIsValidBST.min, rightIsValidBST.min), root.val), leftIsValidBST.isValid && rightIsValidBST.isValid);
    }

    long last = Long.MIN_VALUE;
    // 中序遍历升序
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (isValidBST(root.left)) {
            if (last < root.val) {
                last = root.val;
                return isValidBST(root.right);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(Double.MIN_VALUE);
        System.out.println( -Double.MAX_VALUE);
    }

}
