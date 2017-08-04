package First;

/**
 * @author ranran
 * @version V1.0
 * @Title:
 * @Package First
 * @Description:最开始题意理解错了，我也是醉了
 * 题目描述
   有 N 个小孩站成一列。每个小孩有一个评级。按照以下要求，给小孩分糖果：每个小孩至少得到一颗糖果。评级越高的小孩可以得到更多的糖果。需最少准备多少糖果？
   样例
   给定评级 = [1, 2], 返回 3.
   给定评级 = [1, 1, 1], 返回 3.
   给定评级 = [1, 2, 2], 返回 4. ([1,2,1]).
   思路
   首先题目中的第三个样例一开始我想不明白为什么是那样，后来才发现，评级比两旁的小孩高的话，糖果肯定要比旁边的小孩多，但是评级与两旁的小孩一样的话，是可以比他们少的。
   其次本题只需要从前往后以及从后往前遍历两次即可，只需要保证评级高得到多一个糖果，不需要保证评级相同也得到相同的糖果。
 * @date 2017/8/3 15:14
 */
public class CandySolution {

    public static int candy(int[] ratings) {
        int[] getCandy = new int[ratings.length];
        int count = 0;
        getCandy[0] = 1;
        getCandy[ratings.length - 1] = 1;
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                getCandy[i] = getCandy[i - 1] + 1;
            } else {
                getCandy[i] = 1;
            }
        }

        count += getCandy[ratings.length - 1];
        for (int i = (ratings.length - 1); i > 0; i--) {
            if (ratings[i - 1] > ratings[i] ) {
                // 和之前最大比
                getCandy[i - 1] = Math.max(getCandy[i] + 1, getCandy[i - 1]);
            }
            count += getCandy[i - 1];
        }

//        for (int i = 0; i < getCandy.length; i++) {
//            System.out.println("getCandy[" + i + "]:" + getCandy[i]);
//        }

        return count;
    }


    public static void main(String[] args) {
//        int[] array = {1,3,4,3,2,1};
        int[] array = {2,2};
//        int[] array = {1,0,2};
//        int[] array = {5,3,1};  // 6
//        int[] array = {2,2,1};  // 4
//        int[] array = {4,2,3,4,1};  // 4
//        int[] array = {1,2,2};  // 4
        System.out.println(candy(array));
    }

}
