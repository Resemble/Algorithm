package package11;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package package11
 * @Description: 2. 两数相加
 * https://leetcode-cn.com/problems/add-two-numbers/submissions/
 * @date 2020-06-19 09:43
 */
public class AddTwoNumbersSolution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyNode = new ListNode(0);
        ListNode tempDummyNode = dummyNode;
        ListNode tempNode;
        int tempSum;
        int nextVal = 0;
        while (l1 != null || l2 != null) {
            tempNode = new ListNode();
            if (l1 != null && l2 != null) {
                tempSum = l1.val + l2.val + nextVal;
                l1 = l1.next;
                l2 = l2.next;
            } else if (l2 != null) {
                tempSum = l2.val + nextVal;
                l2 = l2.next;
            } else {
                tempSum = l1.val + nextVal;
                l1 = l1.next;
            }
            tempNode.val = tempSum % 10;
            tempDummyNode.next = tempNode;
            tempDummyNode = tempDummyNode.next;
            nextVal = tempSum / 10;
        }
        if (nextVal >= 1) {
            tempDummyNode.next = new ListNode(nextVal);
        }
        return dummyNode.next;
    }

}
