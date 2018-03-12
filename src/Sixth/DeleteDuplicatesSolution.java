package Sixth;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package Sixth
 * @Description:
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
   For example,
   Given1->1->2, return1->2.
   Given1->1->2->3->3, return1->2->3.
 * @date 2018/3/12 上午9:30
 */
public class DeleteDuplicatesSolution {

    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;
        int lastValue = head.val;
        ListNode root = head;
        ListNode temp = head;
        while(head.next != null) {
            temp = head.next;
            if(temp.val == lastValue) {
                // remove temp node
                head.next = temp.next;
            } else {
                head = temp;
                lastValue = temp.val;
            }
        }
        return root;
    }


}
