package tenth;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package tenth
 * @Description: 1217. 玩筹码
 * @date 2020-05-04 17:47
 */
public class MinCostToMoveChipsSolution {

    public int minCostToMoveChips(int[] chips) {
        int oddCnt = 0;
        int evenCnt = 0;
        for (int chip : chips) {
            if ((chip & 1) == 1) {
                // 奇数
                oddCnt++;
            } else {
                evenCnt++;
            }
        }
        return oddCnt < evenCnt ? oddCnt : evenCnt;
    }

}
