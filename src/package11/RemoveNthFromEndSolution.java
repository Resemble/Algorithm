package package11;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package package11
 * @Description: 删除链表的倒数第N个节点
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/6/linked-list/42/
 * @date 2020-06-07 16:50
 */
public class RemoveNthFromEndSolution {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fastNode = head;
        ListNode slowNode = head;
        ListNode slowNodeBefore = head;
        for (int i = 0; i < n - 1; i++) {
            fastNode = fastNode.next;
        }
        while (fastNode.next != null) {
            fastNode = fastNode.next;
            slowNodeBefore = slowNode;
            slowNode = slowNode.next;
        }
        if (slowNode == head) {
            if (head.next == null) {
                return null;
            } else {
                return head.next;
            }
        }
        slowNodeBefore.next = slowNodeBefore.next.next;
        return head;
    }

}
