package Second;

import java.util.HashSet;

/**
 * @author ranran
 * @version V1.0
 * @Title:
 * @Package Second
 * @Description:
 * Given stones = [0,1,3,5,6,8,12,17]
 * There are a total of 8 stones.
 * The first stone at the 0th unit, second stone at the 1st unit,
 * third stone at the 3rd unit, and so on...
 * The last stone at the 17th unit.
 *
 * Return true. The frog can jump to the last stone by jumping
 * 1 unit to the 2nd stone, then 2 units to the 3rd stone, then
 * 2 units to the 4th stone, then 3 units to the 6th stone,
 * 4 units to the 7th stone, and 5 units to the 8th stone.
 *
 * Given stones = `[0,1,2,3,4,8,9,11]`
 *
 * Return false. There is no way to jump to the last stone as
 * the gap between the 5th and 6th stone is too large.
 * @date 2017/7/3 21:44
 */
public class CanCrossBetterSolution {

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
        CanCrossBetterSolution canCrossSolution = new CanCrossBetterSolution();
        System.out.println(canCrossSolution.canCross(stones));
    }

    /**
     * @param stones a list of stones' positions in sorted ascending order
     * @return true if the frog is able to cross the river or false
     */
    public boolean canCross(int[] stones) {
        if (stones == null || stones.length == 0) return false;
        int n = stones.length;
        if (n == 1) return true;
        if (stones[1] != 1) return false;
        if (n == 2) return true;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (i > 3 && stones[i] > stones[i - 1] * 2) return false;
            set.add(stones[i]);
        }
        return canCross(set, stones[n - 1], 1, 1);
    }

    public boolean canCross(HashSet<Integer> set, int last, int pos, int jump) {
        if (pos + jump == last || pos + jump + 1 == last || pos + jump - 1 == last) {
            return true;
        }
        if (set.contains(pos + jump + 1)) {
            if (canCross(set, last, pos + jump + 1, jump + 1)) return true;
        }
        if (set.contains(pos + jump)) {
            if (canCross(set, last, pos + jump, jump)) return true;
        }
        if (jump > 1 && set.contains(pos + jump - 1)) {
            if (canCross(set, last, pos + jump - 1, jump -1)) return true;
        }
        return false;
    }



}
