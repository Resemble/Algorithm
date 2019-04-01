package eighth;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package eighth
 * @Description:
 * @date 2019/3/31 10:46 AM
 */
public class MedianIISolution {


    /**
     * @param nums: A list of integers
     * @return: the median of numbers
     * 最大堆最小堆
     */

    PriorityQueue<Integer> maxHeap, minHeap;

    public int[] medianII(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        maxHeap = new PriorityQueue<>(n, Collections.reverseOrder());
        minHeap = new PriorityQueue<>(n);
        for (int i = 0; i < n; i++) {
            if (maxHeap.size() == 0 || nums[i] <= maxHeap.peek()) {
                maxHeap.offer(nums[i]);
            } else {
                minHeap.offer(nums[i]);
            }
            blance();
            res[i] = maxHeap.peek();
        }
        return res;
    }

    private void blance() {
        while (maxHeap.size() < minHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
        while (minHeap.size() < maxHeap.size() - 1) {
            minHeap.offer(maxHeap.poll());
        }
    }

    // 超时版本
    public int[] medianII2(int[] nums) {
        // write your code here
        int returnIndex;
        int[] sortNums = new int[nums.length];
        int[] returnNums = new int[nums.length];
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        PriorityQueue<Integer> priorityQueue2;
        for (int i = 0; i < nums.length; i++) {
            priorityQueue.add(nums[i]);
            priorityQueue2 = new PriorityQueue<>(priorityQueue);
            returnIndex = i / 2;
            for (int j = 0; j < returnIndex; j++) {
                priorityQueue2.poll();
            }
            returnNums[i] = priorityQueue2.poll();
        }
        return returnNums;
    }

    public static void main(String[] args) {
        //  [4, 4, 4, 3, 3, 3, 3]
        int[] nums = {4, 5, 1, 3, 2, 6, 0};
        MedianIISolution medianIISolution = new MedianIISolution();
        int[] result = medianIISolution.medianII(nums);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

}
