package package11;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package package11
 * @Description: 234. 回文链表
 * https://leetcode-cn.com/problems/palindrome-linked-list/submissions/
 * @date 2020-06-07 17:47
 */
public class IsPalindromeSolution {

    public boolean isPalindrome2(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode dummyHead = new ListNode(0);
        ListNode tempDummyHead = dummyHead;
        ListNode tempNode = head;
        while (tempNode != null) {
            tempDummyHead.next = new ListNode(tempNode.val);
            tempDummyHead = tempDummyHead.next;
            tempNode = tempNode.next;
        }
        ListNode reverseHead = reverseList(dummyHead.next);
        while (head != null) {
            if (head.val != reverseHead.val) {
                return false;
            }
            head = head.next;
            reverseHead = reverseHead.next;
        }
        return true;
    }

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

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode fast = head;
        ListNode slow = head;
        ListNode pre = null;
        // 1.快慢指针，找到链表的中点
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // 2.将slow之后的链表反转
        while (slow != null) {
            ListNode next = slow.next;
            slow.next = pre;
            pre = slow;
            slow = next;
        }
        // 3.将前后链表比较，注意若为奇数链表，多一个节点，然而不影响判断
        while (head != null && pre != null) {
            if (head.val != pre.val) {
                return false;
            }
            head = head.next;
            pre = pre.next;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(1);
        ListNode listNode4 = new ListNode(1);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        IsPalindromeSolution solution = new IsPalindromeSolution();
        //        solution.isPalindrome(listNode1);
        ListNode reverseHead = solution.reverseList(listNode1);
        while (reverseHead != null) {
            System.out.println(reverseHead.val);
            reverseHead = reverseHead.next;
        }
    }
}
