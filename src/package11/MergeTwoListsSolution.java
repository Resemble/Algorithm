package package11;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package package11
 * @Description: 21. 合并两个有序链表
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/submissions/
 * @date 2020-06-07 17:27
 */
public class MergeTwoListsSolution {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode resultHead = new ListNode(0);
        ListNode head = resultHead;
        int curVal;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                curVal = l1.val;
                l1 = l1.next;
            } else {
                curVal = l2.val;
                l2 = l2.next;
            }
            head.next = new ListNode(curVal);
            head = head.next;
        }
        if (l1 == null) {
            head.next = l2;
        } else {
            head.next = l1;
        }
        return resultHead.next;
    }

    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode head = null;
        ListNode resultHead = null;
        int curVal;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                curVal = l1.val;
                l1 = l1.next;
            } else {
                curVal = l2.val;
                l2 = l2.next;
            }
            if (head == null) {
                head = new ListNode(curVal);
                resultHead = head;
            } else {
                head.next = new ListNode(curVal);
                head = head.next;
            }
        }
        if (l1 == null) {
            head.next = l2;
        } else {
            head.next = l1;
        }
        return resultHead;
    }

}
