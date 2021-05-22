package package12;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package package12
 * @Description: 杨辉三角
 * @date 5/22/21 7:31 PM
 */
public class GenerateSolution {

    public List<List<Integer>> generate(int numRows) {
        List<Integer> lastList = new ArrayList<>();
        List<Integer> currList = new ArrayList<>();
        List<List<Integer>> resultList = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    currList.add(1);
                } else if (j <= i / 2) {

                    currList.add(lastList.get(j - 1) + lastList.get(j));
                } else {
                    currList.add(currList.get(i - j));
                }
            }
            resultList.add(currList);
            lastList = new ArrayList<>(currList);
            currList = new ArrayList<>();
        }
        return resultList;
    }


}
