package package11;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package package11
 * @Description: 108. 将有序数组转换为二叉搜索树
 * https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/
 * @date 2020-05-31 16:56
 */
public class SortedArrayToBSTSolution {

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return sortedArrayToBSTHelper(nums, 0, nums.length - 1);
    }

    public TreeNode sortedArrayToBSTHelper(int[] nums, int begin, int end) {
        int index = (begin + end) / 2;
        TreeNode root = new TreeNode(nums[index]);
        if (index - 1 >= begin) {
            root.left = sortedArrayToBSTHelper(nums, begin, index - 1);
        }
        if (index + 1 <= end) {
            root.right = sortedArrayToBSTHelper(nums, index + 1, end);
        }
        return root;
    }

}
