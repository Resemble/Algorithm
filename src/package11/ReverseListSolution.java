package package11;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package package11
 * @Description: 反转链表
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/6/linked-list/43/
 * @date 2020-06-07 17:05
 */
public class ReverseListSolution {

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode beforeNode = null;
        ListNode curNode;
        ListNode nextNode = head;
        while (nextNode != null) {
            // 每次都是新的 next 节点
            curNode = nextNode;
            nextNode = curNode.next;
            curNode.next = beforeNode;
            beforeNode = curNode;
        }
        return beforeNode;
    }

}
