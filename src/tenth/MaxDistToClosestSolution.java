package tenth;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package tenth
 * @Description:
 * @date 2019-07-21 23:18
 */
public class MaxDistToClosestSolution {

    public int maxDistToClosest(int[] seats) {
        if (seats == null) {
            return 0;
        }
        int maxZeroCount = 0;
        int minSize;
        int temp = 0;

        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == 1) {
                temp = 0;
            } else {
                temp++;
                maxZeroCount = Math.max(maxZeroCount, temp);
            }
        }
        minSize = (maxZeroCount + 1) / 2;

        temp = 0;
        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == 0) {
                temp++;
            } else {
                break;
            }
        }
        if (temp > minSize) {
            minSize = temp;
        }

        temp = 0;
        for (int i = seats.length - 1; i >= 0; i--) {
            if (seats[i] == 0) {
                temp++;
            } else {
                break;
            }
        }
        if (temp > minSize) {
            minSize = temp;
        }

        return minSize;
    }

}
