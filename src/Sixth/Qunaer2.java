package Sixth;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author ranran
 * @version V1.0
 * @Title:
 * @Package Sixth
 * @Description:
 * @date 2017/9/20 9:19
 */
public class Qunaer2 {

    private static class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int val = 0;
        if(sc.hasNext()) {
            val = sc.nextInt();
        } else {
            System.out.println(0);
            return;
        }
        TreeNode root = new TreeNode(val);
        TreeNode tempRoot;
        HashMap<Integer, TreeNode> hashMap = new HashMap<>();
        hashMap.put(val, root);
        int left;
        int right;
//        int count = 0;
        while (sc.hasNext()) {
            String string = sc.next();
            String[] tempString = string.split(":");
            int valRoot = Integer.parseInt(tempString[0]);
            String[] temp2 = tempString[1].split("\\|");
            left = Integer.parseInt(temp2[0]);
            right = Integer.parseInt(temp2[1]);
            tempRoot = hashMap.get(valRoot);
            if(tempRoot == null) {
                System.out.println(0);
                return;
            }
            if(left != -1) {
                if(left >= valRoot) {
                    System.out.println(0);
                    return;
                }
                if(valRoot == 0) {
                    System.out.println(0);
                    return;
                }
                TreeNode leftNode = new TreeNode(left);
                tempRoot.left = leftNode;
                if(hashMap.containsKey(left)) {
                    System.out.println(0);
                    return;
                }
                hashMap.put(left, leftNode);
            }
            if(right != -1) {
                if(right <= valRoot) {
                    System.out.println(0);
                    return;
                }
                TreeNode rightNode = new TreeNode(right);
                tempRoot.right = rightNode;
                if(hashMap.containsKey(right)) {
                    System.out.println(0);
                    return;
                }
                hashMap.put(right, rightNode);
            }


//            if(count == 5) break;
//            count++;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        inOrder2(root, arrayList);
        for (int i = 0; i < arrayList.size() - 1; i++) {
            if(arrayList.get(i + 1) < arrayList.get(i)) {
                System.out.println(0);
                return;
            }
        }
        System.out.println(1);
    }

    public static void inOrder2(TreeNode node, ArrayList<Integer> arrayList) {
        Stack<TreeNode> stack = new Stack<>();
        while(node != null || !stack.isEmpty()) {
            while(node != null) {
                stack.push(node);
                node = node.left;
            }
            if(!stack.isEmpty()) {
                node = stack.pop();
                arrayList.add(node.val);
                node = node.right;
            }
        }

    }

}
