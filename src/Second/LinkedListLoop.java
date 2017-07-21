package Second;

/**
 * @author ranran
 * @version V1.0
 * @Title:
 * @Package Second
 * @Description: 判断链表是否有环，并找到环，跳一步跳两步终将相遇
 * @date 2017/7/21 10:24
 */
public class LinkedListLoop {

    public class Node {
        int val;
        Node next;

        Node(int x) {
            val = x;
            next = null;
        }
    }

    public Node FindLoopPort(Node head) {

        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break; // 链表存在环
            }

        }
        if (fast == null || fast.next == null) {
            return null;
        }
        // 从头开始
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;

    }


}
