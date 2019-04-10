package eighth;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package eighth
 * @Description: https://www.lintcode.com/problem/partition-list/description
 * @date 2019/4/10 11:29 PM
 */
public class PartitionSolution {


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }


    /**
     * @param head: The first node of linked list
     * @param x:    An integer
     * @return: A ListNode
     */
    public ListNode partition(ListNode head, int x) {
        // write your code here
        if (head == null || head.next == null) {
            return head;
        }
        ListNode bigNode = null;
        ListNode smallNode = null;
        ListNode bigNodeHead = null;
        ListNode smallNodeHead = null;
        while (head != null) {
            if (head.val < x) {
                if (smallNode == null) {
                    smallNode = new ListNode(head.val);
                    smallNodeHead = smallNode;
                } else {
                    smallNode.next = new ListNode(head.val);
                    smallNode = smallNode.next;
                }
            } else {
                if (bigNode == null) {
                    bigNode = new ListNode(head.val);
                    bigNodeHead = bigNode;
                } else {
                    bigNode.next = new ListNode(head.val);
                    bigNode = bigNode.next;
                }
            }
            head = head.next;
        }
        if (smallNodeHead == null) {
            return bigNodeHead;
        }
        if (bigNodeHead == null) {
            return smallNodeHead;
        }
        smallNode.next = bigNodeHead;
        return smallNodeHead;
    }


    public static void main(String[] args) {
//        3->3->1->2->4->null
//        3
        PartitionSolution partitionSolution = new PartitionSolution();
        ListNode head = new ListNode(3);
        ListNode head1 = new ListNode(3);
        ListNode head2 = new ListNode(1);
        ListNode head3 = new ListNode(2);
        ListNode head4 = new ListNode(4);
        head.next = head1;
        head1.next = head2;
        head2.next = head3;
        head3.next = head4;
        ListNode resultNode = partitionSolution.partition(head, 3);
        while(resultNode != null) {
            System.out.println(resultNode.val);
            resultNode = resultNode.next;
        }
    }

}
