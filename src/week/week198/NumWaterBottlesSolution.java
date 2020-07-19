package week.week198;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package week
 * @Description:
 * @date 2020-07-19 10:33
 */
public class NumWaterBottlesSolution {

    public int numWaterBottles(int numBottles, int numExchange) {
        int cnt = numBottles;
        int curTimeBottles = 0;
        while (numBottles >= numExchange) {
            curTimeBottles = numBottles / numExchange;
            cnt = cnt + curTimeBottles;
            numBottles = curTimeBottles + numBottles % numExchange;
        }
        return cnt;
    }

}
