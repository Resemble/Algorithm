package eighth;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package eighth
 * @Description:
 * @date 2019/4/7 11:16 AM
 */
public class HasCycleSolution {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     * @param head: The first node of linked list.
     * @return: True if it has a cycle, or false
     */
    public boolean hasCycle(ListNode head) {
        // write your code here
        if (head == null) {
            return false;
        }
        ListNode slowNode = head;
        ListNode fastNode = head;
        while (true) {
            if (fastNode.next != null && fastNode.next.next != null) {
                fastNode = fastNode.next.next;
                slowNode = slowNode.next;
                if (fastNode == slowNode) {
                    return true;
                }
            } else {
                return false;
            }

        }
    }

}
