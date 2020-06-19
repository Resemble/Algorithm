package package11;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package package11
 * @Description: 328. 奇偶链表
 * https://leetcode-cn.com/problems/odd-even-linked-list/
 * @date 2020-06-19 10:24
 */
public class OddEvenListSolution {


    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // head 为奇链表头结点，evenLast 为奇链表尾节点
        ListNode evenLast = head;
        // oddHead 为偶链表头结点
        ListNode oddHead = head.next;
        // oddLast 为偶链表尾节点
        ListNode oddLast = oddHead;
        // 找到最后两个节点
        while (evenLast.next != null && oddLast.next != null) {
            evenLast.next = oddLast.next;
            evenLast = evenLast.next;
            oddLast.next = evenLast.next;
            oddLast = oddLast.next;
        }
        // 最后一个奇数节点本来next可能是偶数的最后一个，这样变成第一个就完美了
        evenLast.next = oddHead;
        return head;
    }


    public ListNode oddEvenList2(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }
        ListNode dummyEvenNode = new ListNode(0);
        dummyEvenNode.next = head;
        ListNode tempOddNode = head.next;
        ListNode oddNodeHead = null;
        ListNode evenLastNode = head;
        while (head != null && head.next != null) {
            if (oddNodeHead == null) {
                oddNodeHead = head.next;
            } else {
                oddNodeHead.next = head.next;
                oddNodeHead = oddNodeHead.next;
            }
            head.next = head.next.next;
            head = head.next;
            if (head != null) {
                evenLastNode = head;
            }
        }
        oddNodeHead.next = null;
        evenLastNode.next = tempOddNode;
        return dummyEvenNode.next;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        OddEvenListSolution oddEvenListSolution = new OddEvenListSolution();
        ListNode result = oddEvenListSolution.oddEvenList(head);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}
