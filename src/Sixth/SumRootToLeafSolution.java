package Sixth;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ranran
 * @version V1.0
 * @Title:
 * @Package Sixth
 * @Description:
 * @date 2018/2/25 15:58
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class SumRootToLeafSolution {
    int total;

    public int sumNumbers(TreeNode root) {
        List<Integer> arrayList = new ArrayList<>();
        if (root == null) return 0;
        arrayList.add(root.val);
        preOrder(root, arrayList);
        return total;
    }

    public void preOrder(TreeNode root, List<Integer> arrayList) {
        arrayList.add(root.val);
        if (root.left == null && root.right == null) {
            getValue(arrayList);
            arrayList.remove(arrayList.size() - 1);
            return;
        }

        if (root.left != null)
            preOrder(root.left, arrayList);
        if (root.right != null)
            preOrder(root.right, arrayList);
        arrayList.remove(arrayList.size() - 1);
    }

    public void getValue(List<Integer> arrayList) {
        int temp = 0;
        for (int i = 0; i < arrayList.size(); i++) {
            temp = temp * 10;
            temp = temp + arrayList.get(i);
        }
        total = total + temp;
    }
}
