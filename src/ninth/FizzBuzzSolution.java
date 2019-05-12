package ninth;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package ninth
 * @Description:
 * @date 2019-05-09 23:15
 */
public class FizzBuzzSolution {


    /**
     * @param n: An integer
     * @return: A list of strings.
     */
    public List<String> fizzBuzz(int n) {
        // write your code here
        List<String> result = new ArrayList<>();

        String temp;
        for (int i = 1; i < n + 1; i++) {
            temp = String.valueOf(i);
            temp = (i % 3 == 0 && i % 5 == 0) ? "fizz buzz" : (i % 3 == 0) ? "fizz" : (i % 5 == 0) ? "buzz" : temp;
            result.add(temp);
        }
        return result;
    }

}
