package tenth;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package tenth
 * @Description:
 * @date 2019-06-29 11:37
 */

public class RemoveElementsSolution {



    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    public ListNode removeElements(ListNode head, int val) {
        ListNode hd = new ListNode(0);
        hd.next = head;
        ListNode preNode = hd;
        ListNode nextNode = null;
        while (head != null) {
            nextNode = head.next;
            if (head.val == val) {

                head.next = null;
                preNode.next = nextNode;
                head = nextNode;
            } else {
                preNode = head;
                head = nextNode;
            }
        }
        return hd.next;
    }

}
