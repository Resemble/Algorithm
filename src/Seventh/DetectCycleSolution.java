package Seventh;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package Seventh
 * @Description:
 * @date 2018/3/18 上午10:57
 */

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}


public class DetectCycleSolution {

    public ListNode detectCycle(ListNode head) {
        if (head == null)
            return null;
        ListNode fast = head;
        ListNode slow = head;
        while (true) {
            if (fast.next != null && fast.next.next != null) {
                fast = fast.next.next;
            } else {
                return null;
            }
            slow = slow.next;
            if (slow == fast) {
                fast = head;
                while (fast != slow) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
    }
}
