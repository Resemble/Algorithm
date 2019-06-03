package ninth;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package ninth
 * @Description:
 * @date 2019-06-03 23:24
 */
public class IsUglySolution {

    /**
     * @param num: An integer
     * @return: true if num is an ugly number or false
     */
    public boolean isUgly(int num) {
        // write your code here

        if (num == 0) {
            return false;
        }
        while (num % 2 == 0) {
            num = num / 2;
        }
        while (num % 3 == 0) {
            num = num / 3;
        }
        while (num % 5 == 0) {
            num = num / 5;
        }
        if (num == 1) {
            return true;
        } else {
            return false;
        }
    }

}
