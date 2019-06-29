package tenth;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package tenth
 * @Description:
 * @date 2019-06-29 11:18
 */
public class IsHappySolution {

    public boolean isHappy(int n) {
        List<Integer> happyList = new ArrayList<>();
        int newN = 0;
        while (n != 1) {
            if (happyList.contains(n)) {
                return false;
            }
            happyList.add(n);
            newN = 0;
            while (n >= 1) {
                newN = (n % 10) * (n % 10) + newN;
                n = n / 10;
            }
            n = newN;
        }
        return true;
    }

    public static void main(String[] args) {
        IsHappySolution happySolution = new IsHappySolution();
        boolean isHappy = happySolution.isHappy(3);
        if (isHappy) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }

}
