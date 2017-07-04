package Second;

import java.util.Arrays;

/**
 * @author ranran
 * @version V1.0
 * @Title:
 * @Package Second
 * @Description:
 * @date 2017/7/3 21:44
 */
public class CanCrossSolution {

    public static void main(String[] args) {
        int[] stones = new int[8];
        stones[0] = 0;
        stones[1] = 1;
        stones[2] = 3;
        stones[3] = 5;
        stones[4] = 6;
        stones[5] = 8;
        stones[6] = 12;
        stones[7] = 17;
        CanCrossSolution canCrossSolution = new CanCrossSolution();
        System.out.println(canCrossSolution.canCross(stones));
    }

    /**
     * @param stones a list of stones' positions in sorted ascending order
     * @return true if the frog is able to cross the river or false
     */
    public boolean canCross(int[] stones) {
        // Write your code here
//        int lengthOfList = stones.length;
//        int[] subtract = new int[lengthOfList-1];
//
//        if (lengthOfList==2) {
//            int firstSub = stones[1] - stones[0];
//            if (firstSub == 1) {
//                return true;
//            } else {
//                return false;
//            }
//        } else if (lengthOfList == 3) {
//            int secondSub = stones[2] -stones[1];
//            if (abs(secondSub - 1) > 1) {
//                return false;
//            } else {
//                return true;
//            }
//        }
//
//        for (int i = 0; i < lengthOfList-1; i++) {
//            subtract[i] = stones[i+1] - stones[i];
//        }
//
//        for (int i = 0; i < subtract.length-1; i++) {
//            int subSub = abs(subtract[i+1] - subtract[i]);
//            if (subSub > 1) {
//                if (abs(subtract[i+1] - subtract[i-1]) > 2) {
//                    return false;
//                }
//                return false;
//            }
//        }
//        return true;
        int k = 0;
        return helper(stones, 0, k);

    }

    private boolean helper(int[] stones, int index, int k) {
        // 到达了
        if (index == stones.length-1) return true;
        // 选择 k 的步伐，范围 k-1 到 k
        for (int i = k-1; i <= k + 1; i++) {
            int nextJump = stones[index] + i;
            int nextPosition = Arrays.binarySearch(stones, index + 1, stones.length, nextJump);
            if (nextPosition > 0) {
                if (helper(stones, nextPosition, i)) return true;
            }
        }
        return false;
    }

}
