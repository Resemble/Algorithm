package ninth;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package ninth
 * @Description:
 * @date 2019-05-26 19:31
 */
public class GenerateParenthesisSolution {

    /**
     * @param n: n pairs
     * @return: All combinations of well-formed parentheses
     */

    List<String> resultList = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        // write your code here
        combination("", 0, 0, n);
        return resultList;
    }

    public void combination(String result, int leftCnt, int rightCnt, int n) {
        if (leftCnt <= n) {
            /* 左边添加 */
            result = result + "(";
            leftCnt++;
            combination(result, leftCnt, rightCnt, n);
            leftCnt--;
            result = result.substring(0, result.length() - 1);
        }

        if (rightCnt <= n && rightCnt < leftCnt) {
            /* 右边添加 */
            result = result + ")";
            rightCnt++;
            combination(result, leftCnt, rightCnt, n);
            rightCnt--;
            result = result.substring(0, result.length() - 1);
        }
        if (leftCnt == n && rightCnt == n) {
            resultList.add(result);
        }

    }




    public static void tetString(String test) {
        test = "23";
    }

    public static void main(String[] args) {
//        String s = "111";
//        tetString(s);
//        System.out.println(s);
//        System.out.println("01234".substring(0, 4));
        GenerateParenthesisSolution solution = new GenerateParenthesisSolution();
        solution.generateParenthesis(3);
//        for (int i = 0; i < resultList.size(); i++) {
//            System.out.println(resultList.get(i));
//        }
    }

}
