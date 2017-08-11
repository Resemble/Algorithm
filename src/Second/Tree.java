package Second;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

/**
 * @author ranran
 * @version V1.0
 * @Title:
 * @Package Second
 * @Description:
 *  有一棵二叉树，树上每个点标有权值，权值各不相同，
 * 请设计一个算法算出权值最大的叶节点到权值最小的叶节点的距离。二叉树每条边的距离为1，一个节点经过多少条边到达另一个节点为这两个节点之间的距离。
 * [13,8,12,9,6,4,3,7,11,10,14,2,5,1,#]
 * @date 2017/8/11 10:45
 */
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
    public TreeNode(int val) {
        this.val = val;
    }
}

public class Tree {

    private static TreeNode minNode;
    private static TreeNode maxNode;
    private static int minValue;
    private static int maxValue;
    private static HashMap<TreeNode, TreeNode> treeNodeHashMap = new HashMap<>();

    public static int getDis(TreeNode root) {
        // write code here
        if (root == null) {
            return -1;
        }
        maxValue = root.val;
        minValue = root.val;
        maxNode = root;
        minNode = root;
        Stack<TreeNode> treeNodeStack = new Stack<>();
        // 非递归中序遍历
        while (root != null || !treeNodeStack.isEmpty()) {
            while (root != null) {
                treeNodeHashMap.put(root.left, root);
                treeNodeStack.push(root);
                root = root.left;
            }
            if (!treeNodeStack.isEmpty()) {
                root = treeNodeStack.pop();
                if (root.left == null && root.right == null) {
                    if (root.val >= maxValue) {
                        maxValue = root.val;
                        maxNode = root;
                    } else if (root.val <= minValue) {
                        minValue = root.val;
                        minNode = root;
                    }
                }
                treeNodeHashMap.put(root.right, root);
                root = root.right;
            }
        }
        List<TreeNode> minArrayList = new ArrayList<>();
        List<TreeNode> maxArrayList = new ArrayList<>();
        minArrayList.add(minNode);
        maxArrayList.add(maxNode);
        while (treeNodeHashMap.containsKey(minNode)) {
            minNode = treeNodeHashMap.get(minNode);
            minArrayList.add(minNode);
        }
        while (treeNodeHashMap.containsKey(maxNode)) {
            maxNode = treeNodeHashMap.get(maxNode);
            maxArrayList.add(maxNode);
        }
        int count = 1;
        List<TreeNode> smallList;
        List<TreeNode> bigList;
        if (minArrayList.size() <= maxArrayList.size()) {
            smallList = minArrayList;
            bigList = maxArrayList;
        } else {
            smallList = maxArrayList;
            bigList = minArrayList;
        }

        int i = smallList.size() - 1;
        while(i >= 0) {
            if (smallList.get(i) != bigList.get(bigList.size() - count)) {
                break;
            }
            i--;
            count++;
        }
//        System.out.println("smallList:" + smallList);
//        System.out.println("smallList.size():" + smallList.size());
//        System.out.println("bigList:" + bigList);
//        System.out.println("bigList.size():" + bigList.size());
//        System.out.println("count:" + count);
        return (smallList.size() + bigList.size() -2 - (count - 2) * 2);
    }

    public static void main(String[] args) {
        TreeNode node13 = new TreeNode(13);
        TreeNode node8 = new TreeNode(8);
        TreeNode node12 = new TreeNode(12);
        TreeNode node9 = new TreeNode(9);
        TreeNode node6 = new TreeNode(6);
        TreeNode node4 = new TreeNode(4);
        TreeNode node3 = new TreeNode(3);
        TreeNode node7 = new TreeNode(7);
        TreeNode node11 = new TreeNode(11);
        TreeNode node10 = new TreeNode(10);
        TreeNode node14 = new TreeNode(14);
        TreeNode node2 = new TreeNode(2);
        TreeNode node5 = new TreeNode(5);
        TreeNode node1 = new TreeNode(1);

        node13.left = node8;
        node13.right = node12;
        node8.left = node9;
        node8.right = node6;
        node12.left = node4;
        node12.right = node3;
        node9.left = node7;
        node9.right = node1;
//        node9.right = node11;
        node6.left = node10;
        node6.right = node14;
        node4.left = node2;
        node4.right = node5;
//        node3.left = node1;
        node3.left = node11;


        System.out.println(getDis(node13));
    }
}