package First;

/**
 * @author ranran
 * @version V1.0
 * @Title:
 * @Package First
 * @Description: 你有两个用链表代表的整数，其中每个节点包含一个数字。
 * 数字存储按照在原来整数中相反的顺序，使得第一个数字位于链表的开头。写出一个函数将两个整数相加，用链表形式返回和。
 * @date 2017/6/12 22:14
 */
public class addListsSolution {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }



    public ListNode addLists2(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode node = result;
        // 进位标志
        int flag = 0;
        while (l1 != null && l2 != null) {
            int value = l1.val + l2.val + flag;
            flag = value / 10;
            value = value % 10;
            node.next = new ListNode(value);
            node = node.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            int value = l1.val + flag;
            flag = value / 10;
            value = value % 10;
            node.next = new ListNode(value);
            node = node.next;
            l1 = l1.next;
        }

        while (l2 != null) {
            int value = l2.val + flag;
            flag = value / 10;
            value = value % 10;
            node.next = new ListNode(value);
            node = node.next;
            l2 = l2.next;
        }

        if (flag == 1) {
            node.next = new ListNode(1);
            node = node.next;
        }
        return result.next;
















//        int l1Length = 0;
//        int l2Length = 0;
//        Node l1Tmp = l1;
//        Node l2Tmp = l2;
//        while (l1Tmp.next != null) {
//            l1Tmp = l1Tmp.next;
//            l1Length += 1;
//        }
//        while (l2Tmp.next != null) {
//            l2Tmp = l2Tmp.next;
//            l2Length += 1;
//        }
//        if (l1Length == l2Length) {
//            result.val = l1.val + l2.val;
//            if (result.val >= 10) {
//                Node result2 = new Node(0);
//                result2.next = result;
//                result2.val = result.val%10;
//                result.val = result.val - result2.val * 10;
//            }
//        }else if(l1Length > l2Length) {
//
//        }else {
//
//        }

    }

}
