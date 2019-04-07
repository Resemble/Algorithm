package eighth;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package eighth
 * @Description:
 * @date 2019/4/7 11:28 AM
 */
public class SortedListToBSTSolution {


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }


    public static class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }


    /*
     * @param head: The first node of linked list.
     * @return: a tree node
     */
    public TreeNode sortedListToBST(ListNode head) {
        // write your code here
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return new TreeNode(head.val);
        }
        ListNode fastNode = head.next.next;
        ListNode midNode = head;
        while (fastNode != null && fastNode.next!= null) {
            midNode = midNode.next;
            fastNode = fastNode.next.next;
        }
        TreeNode rootNode = new TreeNode(midNode.next.val);
        rootNode.right = sortedListToBST(midNode.next.next);
        midNode.next = null;
        rootNode.left = sortedListToBST(head);
        return rootNode;
    }

    public static void main(String[] args) {
        SortedListToBSTSolution listToBST = new SortedListToBSTSolution();
        ListNode head = new ListNode(-1);
        ListNode second = new ListNode(1);
        head.next = second;
//        TreeNode treeNode = listToBST.sortedListToBST(head);
//        System.out.println(treeNode);

        ListNode tempNode = head;
        tempNode.next = null;

    }

}
