package tenth;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package tenth
 * @Description: 991. 坏了的计算器
 * @date 2019-08-19 23:36
 */
public class BrokenCalcSolution {

    public int brokenCalc(int X, int Y) {
        int count = 0;
        while (X < Y) {
            if (Y % 2 == 0) {
                count++;
                Y = Y / 2;
            } else {
                Y = (Y + 1) / 2;
                count = count + 1;
            }
        }
        return count + X - Y;
    }

}
