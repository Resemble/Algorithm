package Sixth;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package Sixth
 * @Description:
 * @date 2018/3/1 下午2:37
 */
public class GetLeastNumbersSolution {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < input.length; i++) {
            priorityQueue.add(input[i]);
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        if(k <= input.length) {
            for (int i = 0; i < k; i++) {
                arrayList.add(priorityQueue.poll());
            }

        }
        return arrayList;

    }

    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(2);
        priorityQueue.add(1);
        priorityQueue.add(3);
        priorityQueue.add(4);
        priorityQueue.add(0);
        while(!priorityQueue.isEmpty()) {
            System.out.println(priorityQueue.poll());
        }
    }

}
