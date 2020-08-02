package week.week200;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package week.week200
 * @Description:
 * @date 2020-08-02 10:53
 */
public class MinSwapsSolution {

    public int minSwaps(int[][] grid) {
        List<Integer> arrList = new ArrayList<>();
        int len = grid.length;
        int cnt;
        for (int i = 0; i < len; i++) {
            cnt = 0;
            for (int j = len - 1; j >= 0; j--) {
                // 统计0个数
                if (grid[i][j] == 0) {
                    cnt++;
                } else {
                    break;
                }
            }
            arrList.add(cnt);
        }
        int removeCnt = 0;
        int curNeedZeroLen = len - 1;
        while (curNeedZeroLen >= 1) {
            boolean isFind = false;
            for (int j = 0; j < arrList.size(); j++) {
                if (arrList.get(j) >= curNeedZeroLen) {
                    // 删除最近一行满足0的行，然后统计个数
                    arrList.remove(j);
                    removeCnt = removeCnt + j;
                    isFind = true;
                    break;
                }
            }
            if (!isFind) {
                return -1;
            }
            curNeedZeroLen--;

        }
        return removeCnt;
    }

}
