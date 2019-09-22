package tenth;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package tenth
 * @Description: 846. 一手顺子
 * @date 2019-09-22 17:46
 */
public class IsNStraightHandSolution {

    public boolean isNStraightHand(int[] hand, int W) {
        if (hand == null || hand.length == 0) {
            return false;
        }
        if (W == 0 || W == 1) {
            return true;
        }
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < hand.length; i++) {
            priorityQueue.add(hand[i]);
        }

        Queue<Integer> tempQueue = new LinkedBlockingQueue<>();
        int last = -1;
        int current;
        int tempW = W;
        while (!priorityQueue.isEmpty()) {
            if (last == -1) {
                last = priorityQueue.poll();
                tempW--;
            } else {
                current = priorityQueue.poll();
                if (current != last + 1) {
                    tempQueue.add(current);
                } else {
                    last = current;
                    tempW--;
                }
            }
            if (tempW == 0) {
                tempW = W;
                last = -1;
                priorityQueue.addAll(tempQueue);
                tempQueue.clear();
            }

        }
        if (tempQueue.isEmpty()) {
            if (last == -1) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public static void main(String[] args) {

        int[] hand = {1,2,3,4,5};
        int W = 4;
        IsNStraightHandSolution solution = new IsNStraightHandSolution();
        if (solution.isNStraightHand(hand, W)) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }

        //        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        //        priorityQueue.add(3);
        //        priorityQueue.add(6);
        //        priorityQueue.add(2);
        //        priorityQueue.add(7);
        //        while (!priorityQueue.isEmpty()) {
        //            System.out.println(priorityQueue.poll());
        //        }
    }

}
