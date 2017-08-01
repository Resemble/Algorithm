package First;

/**
 * @author ranran
 * @version V1.0
 * @Title:
 * @Package First
 * @Description: 找到单链表倒数第n个节点，保证链表中节点的最少数量为n。
 * @date 2017/8/1 9:08
 */
public class NthToLastElementSolution {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    ListNode nthToLast(ListNode head, int n) {
        // write your code here
        ListNode fastNode = head;
        ListNode slowNode = head;
        for (int i = 0; i < n; i++) {
            fastNode = fastNode.next;
        }
        while(fastNode != null) {
            slowNode = slowNode.next;
            fastNode = fastNode.next;
        }
        return slowNode;

    }


}
