package Third;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author ranran
 * @version V1.0
 * @Title:
 * @Package Third
 * @Description:
 * @date 2017/8/23 15:53
 */
public class LargestRectangleAreaSolution {

    public static int largestRectangleArea(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int largestArea = 0;
        int[] heigh2 = new int[height.length + 1];
        heigh2 = Arrays.copyOf(height, height.length + 1);
        for (int i = 0; i < heigh2.length; i++) {
            while (!stack.isEmpty() && heigh2[i] < heigh2[stack.peek()]) {
                int h = heigh2[stack.pop()];
                largestArea = Math.max(largestArea, stack.isEmpty() ? i * h : (i - stack.peek() - 1) * h);
            }
            stack.push(i);
        }
        return largestArea;
    }


    public static void main(String[] args) {
        int[] height = {5,4,1,2};
        int[] heigh2 = new int[height.length + 1];
        heigh2 = Arrays.copyOf(height, height.length + 1);  // Arrays.copy直接拷贝数组不错
        for (int i = 0; i < heigh2.length; i++) {
            System.out.println("heght2[" + i + "]:" + heigh2[i]);
        }
        int largestArea = largestRectangleArea(height);
        System.out.println(largestArea);
    }

}
