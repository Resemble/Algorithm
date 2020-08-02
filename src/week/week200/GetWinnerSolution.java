package week.week200;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package week.week200
 * @Description:
 * @date 2020-08-02 10:36
 */
public class GetWinnerSolution {

    public int getWinner(int[] arr, int k) {
        List<Integer> arrList = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
            arrList.add(arr[i]);
        }

        if (arr.length <= k + 1) {
            return max;
        }
        int cnt = 0;
        while (cnt < k) {
            int temp;
            if (arrList.get(0) < arrList.get(1)) {
                cnt = 0;
                temp = arrList.get(0);
                arrList.remove(0);
            } else {
                cnt++;
                temp = arrList.get(1);
                arrList.remove(1);
            }
            arrList.add(temp);
            if (cnt == 0) {
                cnt++;
            }
        }
        return arrList.get(0);
    }

}
