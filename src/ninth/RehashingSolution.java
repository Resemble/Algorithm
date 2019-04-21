package ninth;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package ninth
 * @Description:
 * @date 2019/4/20 9:52 PM
 */
public class RehashingSolution {

     public static class ListNode {
         int val;
         ListNode next;
         ListNode(int x) {
             val = x;
             next = null;
         }
     }


    /**
     * @param hashTable: A list of The first node of linked list
     * @return: A list of The first node of linked list which have twice size
     */
    public static ListNode[] rehashing(ListNode[] hashTable) {
        // write your code here
        int capacity = hashTable.length;
        capacity = capacity * 2;
        ListNode[] resultNode = new ListNode[capacity];

        for (int i = 0; i < hashTable.length; i++) {
            ListNode tempNode = hashTable[i];
            while (tempNode != null) {
                int hashcode = (tempNode.val % capacity  + capacity) % capacity;
                if (resultNode[hashcode] == null) {
                    resultNode[hashcode] = new ListNode(tempNode.val);
                } else {
                    ListNode resultTempNode = resultNode[hashcode];
                    while (resultTempNode.next != null) {
                        resultTempNode = resultTempNode.next;
                    }
                    resultTempNode.next = new ListNode(tempNode.val);
                }
                tempNode = tempNode.next;
            }
        }

        return resultNode;
    }

    int hashcode(int key, int capacity) {
        return key % capacity;
    }

    public static void main(String[] args) {
        ListNode node29 = new ListNode(29);
        ListNode node5 = new ListNode(5);
        node29.next = node5;

        ListNode[] hashTable = new ListNode[3];
        hashTable[2] = node29;
        rehashing(hashTable);
    }

}
