package tenth;

import java.util.Stack;

/**
 * @author ranbo
 * @version V1.0
 * @Title: 1130. 叶值的最小代价生成树
 * @Package tenth
 * @Description:给你一个正整数数组 arr，考虑所有满足以下条件的二叉树：
 *
 * 每个节点都有 0 个或是 2 个子节点。
 * 数组 arr 中的值与树的中序遍历中每个叶节点的值一一对应。（知识回顾：如果一个节点有 0 个子节点，那么该节点为叶节点。）
 * 每个非叶节点的值等于其左子树和右子树中叶节点的最大值的乘积。
 * 在所有这样的二叉树中，返回每个非叶节点的值的最小可能总和。这个和的值是一个 32 位整数。
 *
 *
 *
 * 示例：
 *
 * 输入：arr = [6,2,4]
 * 输出：32
 * 解释：
 * 有两种可能的树，第一种的非叶节点的总和为 36，第二种非叶节点的总和为 32。
 *
 *     24            24
 *    /  \          /  \
 *   12   4        6    8
 *  /  \               / \
 * 6    2             2   4
 * @date 2020-03-08 17:02
 */
public class MctFromLeafValuesSolution {

    public int mctFromLeafValues(int[] arr) {

        int result = 0;

        Stack<Integer> stack = new Stack<>();
        stack.push(Integer.MAX_VALUE);
        for (int i = 0; i < arr.length; i++) {
            /** 单调递减栈 */
            while (stack.peek() < arr[i]) {
                /** 有一个大的数据，就计算一次 result，当前数据的左右对比 */
                result += stack.pop() * Math.min(stack.peek(), arr[i]);
            }
                stack.push(arr[i]);
        }
        while (stack.size() > 2) {
            result += stack.pop() * stack.peek();
        }
        return result;
    }



//    public int mctFromLeafValues2(int[] arr) {
//        int minValue = Integer.MAX_VALUE;
//        int count = arr.length;
//        int ans = 0;
//        while (count > 2) {
//            for (int a = 0; a < ; a++) {
//
//            }
//        }
//    }

    public static void main(String[] args) {
        int[] arr = {6,2,4};
        MctFromLeafValuesSolution solution = new MctFromLeafValuesSolution();
        System.out.println(solution.mctFromLeafValues(arr));
    }

}
