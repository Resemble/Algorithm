package ninth;

import java.util.List;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package ninth
 * @Description:
 * @date 2019-06-07 11:41
 */
public class CountOfAirplanesSolution {

    class Interval {
        int start, end;
        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    /**
     * @param airplanes: An interval array
     * @return: Count of airplanes are in the sky.
     */
    public int countOfAirplanes(List<Interval> airplanes) {
        // write your code here
        if (airplanes == null) {
            return 0;
        } else if (airplanes.size() == 0) {
            return 0;
        } else if (airplanes.size() == 1) {
            return 1;
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        Interval interval;
        for (int i = 0; i < airplanes.size(); i++) {
            interval = airplanes.get(i);
            min  = Math.min(min, interval.start);
            max  = Math.max(max, interval.end);
        }

        int[] result = new int[max - min + 1];
        int maxCount = 1;
        for (int i = 0; i < airplanes.size(); i++) {
            interval = airplanes.get(i);
            for (int j = interval.start - min; j < interval.end - min; j++) {
                result[j] = result[j] + 1;
                maxCount = Math.max(maxCount, result[j]);
            }
        }
//        int[] result = new int[max];
//        int maxCount = 1;
//        for (int i = 0; i < airplanes.size(); i++) {
//            interval = airplanes.get(i);
//            for (int j = interval.start; j < interval.end; j++) {
//                result[j] = result[j] + 1;
//                maxCount = Math.max(maxCount, result[j]);
//            }
//        }
        return maxCount;
    }

}


