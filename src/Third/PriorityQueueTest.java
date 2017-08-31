package Third;

import java.util.PriorityQueue;

/**
 * @author ranran
 * @version V1.0
 * @Title:
 * @Package Third
 * @Description: 优先队列 小堆
 * @date 2017/8/31 9:42
 */
public class PriorityQueueTest {
    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(4);
        priorityQueue.add(2);
        priorityQueue.add(9);
        priorityQueue.add(5);
        priorityQueue.add(22);
        priorityQueue.add(11);
        while(!priorityQueue.isEmpty()) {
            System.out.println(priorityQueue.poll());
        }
    }
}
