package week.week204;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package week.week204
 * @Description: 没有解决
 * @date 2020-08-30 10:57
 */
public class GetMaxLenSolution {

    public int getMaxLen(int[] nums) {
        int maxCnt = 0;
        int slowThanZero = 0;
        int lastZero = -1;
        int lastSlowThanZero = -1;
        int firstSlowThanZero = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                lastSlowThanZero = i;
                slowThanZero = slowThanZero + 1;
                firstSlowThanZero = Math.min(firstSlowThanZero, i);
                // 小于0的为偶数个
                if (slowThanZero % 2 == 0) {
                    maxCnt = Math.max(i - lastZero, maxCnt);
                } else {
                    maxCnt = Math.max(i - firstSlowThanZero, maxCnt);
                }
            } else if (nums[i] == 0) {
                slowThanZero = 0;
                lastZero = i;
                firstSlowThanZero = Integer.MAX_VALUE;
            } else {
                if (lastSlowThanZero > lastZero && slowThanZero % 2 == 1) {
                    maxCnt = Math.max(i - lastSlowThanZero, maxCnt);
                    maxCnt = Math.max(i - firstSlowThanZero, maxCnt);
                } else {
                    maxCnt = Math.max(i - lastZero, maxCnt);
                }

            }
        }
        return maxCnt;
    }

}
