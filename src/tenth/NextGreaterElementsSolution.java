package tenth;

import java.util.Stack;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package tenth
 * @Description: 503. 下一个更大元素 II
 * @date 2019-08-19 22:09
 */
public class NextGreaterElementsSolution {

    public int[] nextGreaterElements(int[] nums) {
        if (nums == null) {
            return null;
        }

        int[] res = new int[nums.length];

        for (int i = 0; i < res.length; i++) {
            res[i] = -1;
        }
        Stack<Integer> stackValue = new Stack<>();
        Stack<Integer> stackIndex = new Stack<>();
        search(res, nums, stackValue, stackIndex);
        search(res, nums, stackValue, stackIndex);
        return res;
    }

    public void search(int[] res, int[] nums, Stack<Integer> stackValue, Stack<Integer> stackIndex) {

        for (int i = 0; i < nums.length; i++) {

            while (!stackValue.isEmpty() && stackValue.peek() < nums[i]) {
                res[stackIndex.pop()] = nums[i];
                stackValue.pop();
            }
            stackValue.push(nums[i]);
            stackIndex.push(i);
        }

    }



    public static void main(String[] args) {
        int[] nums = new int[] {-1,0};
        NextGreaterElementsSolution solution = new NextGreaterElementsSolution();
        int[] res = solution.nextGreaterElements(nums);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }

}
