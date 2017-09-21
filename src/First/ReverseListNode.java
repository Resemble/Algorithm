package First;


/**
 * @author ranran
 * @version V1.0
 * @Title:
 * @Package First
 * @Description: 链表反转
 * @date 2017/8/28 15:43
 */
public class ReverseListNode {


    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(0);
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        listNode.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        ListNode reverseNode = reverseListNode(listNode);
//        ListNode reverseNode = reverse2(listNode, null);

        while (reverseNode != null) {
            System.out.println(reverseNode.val);
            reverseNode = reverseNode.next;
        }
    }

    public static ListNode reverseListNode(ListNode head) {
        ListNode pre = null;
        ListNode nextNode;
        ListNode reverseHead = null;
        while (head != null) {
            nextNode = head.next;
            if (nextNode == null) {
                reverseHead = head;
            }
            head.next = pre;
            pre = head;
            head = nextNode;
        }
        return reverseHead;
    }


    // 递归反转
    public static ListNode reverse2(ListNode head, ListNode pre) {
        ListNode next = head.next;
        head.next = pre;
        if(next == null) return head;
        return reverse2(next, head);
    }

}
