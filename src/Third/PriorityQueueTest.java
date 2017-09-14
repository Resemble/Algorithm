package Third;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

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
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();  // 默认小堆 获取TopN大
//        PriorityQueue<Integer> priorityQueue = getTopNSamll();  // 使用 comparator 获取TopN小
        priorityQueue.add(4);
        priorityQueue.add(2);
        priorityQueue.add(9);
        priorityQueue.add(5);
        priorityQueue.add(22);
        priorityQueue.add(11);
        Random random = new Random(1000);
        for (int i = 0; i < 100; i++) {
            if (priorityQueue.size() > 10) {
                priorityQueue.poll();
            }
            priorityQueue.add(random.nextInt(100));
        }
        while(!priorityQueue.isEmpty()) {
            System.out.println(priorityQueue.poll());
        }
    }



    // 模拟大顶堆 解决 TopN小问题
    public static PriorityQueue<Integer> getTopNSamll() {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        return priorityQueue;

    }


}
