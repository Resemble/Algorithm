package week.week203;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package week.week203
 * @Description:
 * @date 2020-08-23 10:34
 */
public class MostVisitedSolution {

    public List<Integer> mostVisited(int n, int[] rounds) {
        int maxCount = 0;
        int[] count = new int[n + 1];
        for (int i = 0; i < rounds.length - 1; i++) {
            int begin = rounds[i];
            int end = rounds[i + 1];
            if (begin >= end) {
                // 开头算，结束不算
                for (int j = begin; j <= n; j++) {
                    count[j] = count[j] + 1;
                    maxCount = Math.max(count[j], maxCount);
                }
                for (int j = 1; j < end; j++) {
                    count[j] = count[j] + 1;
                    maxCount = Math.max(count[j], maxCount);
                }
            } else {
                for (int j = begin; j < end; j++) {
                    count[j] = count[j] + 1;
                    maxCount = Math.max(count[j], maxCount);
                }
            }
        }
        int index = rounds[rounds.length - 1];
        count[index] = count[index] + 1;
        maxCount = Math.max(count[index], maxCount);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < count.length; i++) {
            if (count[i] == maxCount) {
                list.add(i);
            }
        }
        return list;
    }

    public static void main(String[] args) {
       int n = 2;
       int[] rounds = {2,1,2,1,2,1,2,1,2};
       MostVisitedSolution solution = new MostVisitedSolution();
        List<Integer> list = solution.mostVisited(n, rounds);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

}
