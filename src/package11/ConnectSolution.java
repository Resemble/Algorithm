package package11;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package package11
 * @Description: 116. 填充每个节点的下一个右侧节点指针
 * https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node/
 * @date 2020-06-07 09:40
 */
public class ConnectSolution {

    public Node connect2(Node root) {
        if (root == null) {
            return root;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        Node tempNode;
        Node sameLevelLastNode = null;
        int cnt;
        while (!queue.isEmpty()) {
            cnt = queue.size();
            while (cnt > 0) {
                tempNode = queue.poll();
                if (sameLevelLastNode != null) {
                    sameLevelLastNode.next = tempNode;
                }
                sameLevelLastNode = tempNode;
                if (tempNode.left != null) {
                    queue.add(tempNode.left);
                }
                if (tempNode.right != null) {
                    queue.add(tempNode.right);
                }
                cnt--;
            }
            sameLevelLastNode = null;
        }
        return root;
    }

    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        if (root.left != null) {
            root.left.next = root.right;
        }
        if (root.right != null) {
            if (root.next != null) {
                root.right.next = root.next.left;
            }
        }
        connect(root.left);
        connect(root.right);
        return root;
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        /**
         *      1
         *    /   \
         *   2     3
         *  /       \
         * 4         5
         / \
         7   6
         */


        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node3.right = node5;
        node4.right = node6;
        node4.left = node7;
        ConnectSolution solution = new ConnectSolution();
        System.out.println(solution.connect(node1));
    }

}


class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
