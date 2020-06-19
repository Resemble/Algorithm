package package11;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package package11
 * @Description: 160. 相交链表
 * https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
 * @date 2020-06-19 11:44
 */
public class GetIntersectionNodeSolution {


    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        /** 定义两个指针，第一轮让两个到达末尾的节点指向另一个链表的头部，最后如果相遇则为交点。
         * 都走了同样的距离，哈哈。没有相交就走完两个链表的距离，最后 null = null 返回。
        */
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA;
        ListNode pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }

    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        int headALen = 0;
        int headBLen = 0;
        ListNode dummyANode = new ListNode(0);
        ListNode dummyBNode = new ListNode(0);
        dummyANode.next = headA;
        dummyBNode.next = headB;
        while (headA != null) {
            headA = headA.next;
            headALen++;
        }
        while (headB != null) {
            headB = headB.next;
            headBLen++;
        }
        headA = dummyANode.next;
        headB = dummyBNode.next;

        while (headALen > headBLen) {
            headALen--;
            headA = headA.next;
        }

        while (headBLen > headALen) {
            headBLen--;
            headB = headB.next;
        }
        while (headALen > 0) {
            if (headA.equals(headB)) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
            headALen--;
        }
        return null;
    }




}
