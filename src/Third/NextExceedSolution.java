package Third;

import java.util.Stack;

/**
 * @author ranran
 * @version V1.0
 * @Title:
 * @Package Third
 * @Description: 单调栈
 * 题目是这样的，给一个数组，返回一个大小相同的数组。返回的数组的第i个位置的值应当是，对于原数组中的第i个元素，至少往右走多少步，才能遇到一个比自己大的元素（如果之后没有比自己大的元素，或者已经是最后一个元素，则在返回数组的对应位置放上-1）。
   简单的例子：
   input: 5,3,1,2,4
   return: -1 3 1 1 -1 右边第一个比他大
 * return: -1 -1 -1 1 1 左边第一个比他小，反向遍历数组
 * @date 2017/8/23 10:29
 */
public class NextExceedSolution {

    public static int[] nextExceed(int[] array) {

        int[] result = new int[array.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = -1;
        }

        Stack<Integer> stack = new Stack<>();
        // 着重在于 出栈 的元素顺便赋一个值   出栈的含义
        for (int i = array.length - 1; i >= 0; i--) {
            while(!stack.isEmpty() && array[i] < array[stack.firstElement()]) {
                result[stack.firstElement()] = stack.firstElement() - i;  // 左边第一个比他小的距离
                stack.pop();
            }
            stack.push(i);
        }
        return result;
    }

    public static void main(String[] args) {
//        Stack<Integer> stack = new Stack<>();
//        System.out.println(stack.firstElement());
        int[] array = {5,3,1,2,4};
        int[] result = nextExceed(array);
        for (int i = 0; i < result.length; i++) {
            if (i == result.length - 1) {
                System.out.println(result[i]);
            } else {
                System.out.print(result[i] + " ");
            }
        }
    }
}
