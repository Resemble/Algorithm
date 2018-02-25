package Sixth;

import java.util.PriorityQueue;

/**
 * @author ranran
 * @version V1.0
 * @Title:
 * @Package Sixth
 * @Description:
 * @date 2017/9/23 11:39
 */
public class SlidWindow {


    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(1);
        priorityQueue.add(2);
        priorityQueue.add(3);
        priorityQueue.add(3);
        priorityQueue.add(4);
        priorityQueue.add(4);
        priorityQueue.add(5);
        priorityQueue.remove(4);
        while(!priorityQueue.isEmpty()) {
            System.out.println(priorityQueue.poll());
        }
    }

    public static get

}
