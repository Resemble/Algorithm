package tenth;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package tenth
 * @Description:
 * @date 2019-06-09 15:48
 */
public class SwapNodesSolution {


    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }


    /**
     * @param head: a ListNode
     * @param v1:   An integer
     * @param v2:   An integer
     * @return: a new head of singly-linked list
     */
    public ListNode swapNodes(ListNode head, int v1, int v2) {
        // write your code here
        if (head == null || v1 == v2) {
            return head;
        }
        /* v1在前，v2在后 */
        ListNode v1Node = null;
        ListNode v2Node = null;
        ListNode v1NodePre = null;
        ListNode v2NodePre = null;
        ListNode preNode = null;

        ListNode headTemp = head;
        while (head != null) {
            if (head.val == v1 || head.val == v2) {
                if (v1Node == null) {
                    v1Node = head;
                    v1NodePre = preNode;
                } else {
                    v2Node = head;
                    v2NodePre = preNode;
                }
            }
            preNode = head;
            head = head.next;
        }

        if (v1Node == null || v2Node == null) {
            return headTemp;
        }
        ListNode v1NodeNext = v1Node.next;
        ListNode v2NodeNext = v2Node.next;
        if (v1NodePre != null) {
            v1NodePre.next = null;
        }
        v2NodePre.next = null;
        v1Node.next = null;
        v2Node.next = null;
        if (v1NodePre != null) {
            v1NodePre.next = v2Node;
        } else {
            headTemp = v2Node;
        }
        if (v1NodeNext == v2Node) {
            v2Node.next = v1Node;
            v1Node.next = v2NodeNext;
        } else {
            v2Node.next = v1NodeNext;
            v2NodePre.next = v1Node;
            v1Node.next = v2NodeNext;
        }
        return headTemp;
    }

}
