package tenth;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package tenth
 * @Description:
 * @date 2019-08-17 10:04
 */
public class FindPoisonedDurationSolution {

    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if (timeSeries == null || timeSeries.length == 0) {
            return 0;
        } else if (timeSeries.length == 1) {
            return duration;
        }
        int endTime = timeSeries[0] + duration;
        int count = duration;
        for (int i = 1; i < timeSeries.length; i++) {
            if (timeSeries[i] >= endTime) {
                count = count + duration;
            } else {
                count = count + timeSeries[i] - timeSeries[i - 1];
            }
            endTime = timeSeries[i] + duration;
        }
        return count;
    }

}
