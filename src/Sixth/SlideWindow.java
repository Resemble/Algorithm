package Sixth;

import java.util.PriorityQueue;
import java.util.Stack;

/**
 * @author ranran
 * @version V1.0
 * @Title:
 * @Package Sixth
 * @Description:
 * @date 2017/9/23 11:39
 */
public class SlideWindow {

    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 2, 8, 2, 7, 3, 3, 4, 5, 6, 7, 8, 9, 10};
        slideWindow(arr, 4);
    }

    // 获得滑动窗口 75% 大的数
    public static void slideWindow(int[] arr, int m) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < m; i++) {
            priorityQueue.add(arr[i]);
        }
        int n = (int) (m * 0.75);
        getNum(priorityQueue, n);
        for (int i = m; i < arr.length; i++) {
            priorityQueue.remove(arr[i - m]);
            priorityQueue.add(arr[i]);
            getNum(priorityQueue, n);
        }
    }

    // 去除优先级队列中第n大的数
    public static void getNum(PriorityQueue<Integer> priorityQueue, int n) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            stack.push(priorityQueue.poll());
        }
        System.out.println(stack.peek());
        while(!stack.isEmpty()) {
            priorityQueue.add(stack.pop());
        }
    }

}
