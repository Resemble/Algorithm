package eighth;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package eighth
 * @Description:
 * @date 2019/4/1 10:33 PM
 */
public class ReverseNodeSolution {


    //   Definition for ListNode
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }


    /**
     * @param head: n
     * @return: The new head of reversed linked list.
     */
    public ListNode reverse(ListNode head) {
        // write your code here
        if (head == null || head.next == null) return head;
        ListNode prev = null;
        ListNode cur = head;
        ListNode temp = null;
        while (cur.next != null) {
            temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        cur.next = prev;
        return cur;

    }

    public static void main(String[] args) {
        ReverseNodeSolution reverseNodeSolution = new ReverseNodeSolution();
        ListNode two = new ListNode(2);
        ListNode one = new ListNode(1);
        ListNode head = new ListNode(0);
        head.next = one;
        one.next = two;
        head = reverseNodeSolution.reverse(head);
        while(head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

}
