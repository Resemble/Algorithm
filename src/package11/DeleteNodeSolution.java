package package11;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package package11
 * @Description: 删除链表中的节点: 删除当前节点
 * @date 2020-06-07 16:43
 */

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int x) { val = x; }
}

public class DeleteNodeSolution {

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(3);
        ListNode listNode2 = new ListNode(3);
        ListNode listNode3 = new ListNode(4);
        listNode1.next = listNode3;
        if (listNode1.equals(listNode2)) {
            System.out.println("相等");
        } else {
            System.out.println("不相等");
        }

        if (listNode1 == listNode2) {
            System.out.println("== 相等");
        } else {
            System.out.println("== 不相等");
        }

    }

}
