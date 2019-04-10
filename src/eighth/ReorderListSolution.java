package eighth;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package eighth
 * @Description: TODO! https://www.lintcode.com/problem/reorder-list/description
 * @date 2019/4/9 11:50 PM
 */
public class ReorderListSolution {



    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }


    /**
     * @param head: The head of linked list.
     * @return: nothing
     */
    public void reorderList(ListNode head) {
        // write your code here
        if (head == null || head.next == null) {
            return;
        }
        ListNode slowNode = head;
        ListNode fastNode = head.next.next;
        while (fastNode != null && fastNode.next != null) {
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
        }

        ListNode preNode = null;
        ListNode currNode = slowNode.next;
        ListNode afterNode = null;

        while (currNode.next != null) {
            afterNode = currNode.next;
            currNode.next = preNode;
            preNode = currNode;
            currNode = afterNode;
        }
        currNode.next = preNode;

        slowNode.next = null;
        ListNode tempHeadNext = null;
        ListNode tempTailNext = null;
        while (currNode.next != null) {
            tempHeadNext = head.next;
            tempTailNext = currNode.next;
            head.next = currNode;
            currNode.next = tempHeadNext;
            currNode = tempTailNext;
            if (tempHeadNext != null) {
                head = head.next.next;
            } else {
                head = head.next;
            }
        }
        head.next = currNode;
    }

    public static void main(String[] args) {
        ListNode two = new ListNode(0);
        ListNode one = new ListNode(-1);
        ListNode head = new ListNode(2);
        head.next = one;
        one.next = two;
        ReorderListSolution reorderListSolution = new ReorderListSolution();
        reorderListSolution.reorderList(head);
        while(head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

}
