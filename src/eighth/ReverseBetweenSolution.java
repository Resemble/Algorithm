package eighth;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package eighth
 * @Description:
 * @date 2019/4/5 11:18 AM
 */


public class ReverseBetweenSolution {

    /**
     * Definition for ListNode
     */
    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     * @param head: ListNode head is the head of the linked list
     * @param m:    An integer
     * @param n:    An integer
     * @return: The head of the reversed ListNode
     */
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        // write your code here
        if (m > n || head == null) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        for (int i = 1; i < m; i++) {
            if (head == null) {
                return null;
            }
            head = head.next;
        }
        ListNode premNode = head;
        ListNode mNode = head.next;
        ListNode nNode = mNode;
        ListNode postnNode = mNode.next;

        for (int i = m; i < n; i++) {
            if (postnNode == null) {
                return null;
            }
            ListNode temp = postnNode.next;
            postnNode.next = nNode;
            nNode = postnNode;
            postnNode = temp;
        }
        mNode.next = postnNode;
        premNode.next = nNode;
        return dummy.next;
    }

    public static void main(String[] args) {
        ReverseBetweenSolution reverseNodeSolution = new ReverseBetweenSolution();
        ListNode four = new ListNode(5);
        ListNode three = new ListNode(4);
        ListNode two = new ListNode(3);
        ListNode one = new ListNode(2);
        ListNode head = new ListNode(1);
        head.next = one;
        one.next = two;
        two.next = three;
        three.next = four;
        head = reverseBetween(head, 3, 4);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

}
