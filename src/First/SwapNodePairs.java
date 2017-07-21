package First;

/**
 * @author ranran
 * @version V1.0
 * @Title:
 * @Package First
 * @Description: 给一个链表，两两交换其中的节点，然后返回交换后的链表。
 * @date 2017/6/6 21:13
 */



public class SwapNodePairs {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    /**
     * @param head a Node
     * @return a Node
     */
    public ListNode swapPairs(ListNode head) {
        // Write your code here

        if(head.next != null) {
            ListNode listNode = head;
            head = head.next;
            listNode.next = head.next;
            head.next = listNode;
            if (head.next.next != null) {
                head.next.next = swapPairs(head.next.next);
            }
        }
        return  head;
    }



}
