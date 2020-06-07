package package11;

import java.util.Arrays;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package package11
 * @Description: 105. 从前序与中序遍历序列构造二叉树
 * https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 * @date 2020-06-07 11:35
 */
public class BuildTreeSolution {

    // 左边右边找到后疯狂递归
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        // 根据前序数组的第一个元素，就可以确定根节点
        TreeNode root = new TreeNode(preorder[0]);
        for (int i = 0; i < inorder.length; i++) {
            // preorder[0] 去中序数组中查到对应的元素
            // i 在确定了 left 的长度
            if (preorder[0] == inorder[i]) {
                // 将前序数组分成左右两半，再将中序数组分成左右两半
                // 之后递归处理前序数组左边部分和中序数组左边部分
                // 递归处理前序数组右边部分和中序数组右边部分
                int[] preLeft = Arrays.copyOfRange(preorder, 1, i + 1);
                int[] preRight = Arrays.copyOfRange(preorder, i + 1, preorder.length);
                int[] inLeft = Arrays.copyOfRange(inorder, 0, i);
                int[] inRight = Arrays.copyOfRange(inorder, i + 1, inorder.length);
                root.left = buildTree(preLeft, inLeft);
                root.right = buildTree(preRight, inRight);
            }
        }
        return root;
    }

}
