package Sixth;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package Sixth
 * @Description:
 * @date 2018/3/16 上午9:33
 */
public class FindKthToTailSolution {

    public ListNode FindKthToTail(ListNode head,int k) {
        if(head == null || k <= 0) return null;
        ListNode fastNode = head;
        ListNode slowNode = head;
        int i = 0;
        if(k > 1) {
            while (fastNode.next != null) {
                fastNode = fastNode.next;
                i++;
                if(i == k - 1) break;
            }
        }
        if(i < k - 1) return null;

        while(fastNode.next != null) {
            fastNode = fastNode.next;
            slowNode = slowNode.next;
        }
        return slowNode;
    }

}
