package package12;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package package12
 * @Description:
 * @date 2020-10-08 17:34
 */
public class MaxAreaSolution {

    // 双指针移动数据较小那个。原因是 移动较大那个得到的Math.min(height[r], height[l])最小值
    // 总是小于当前的Math.min(height[r], height[l])最小值
    public int maxArea(int[] height) {
        int maxValue = 0;
        int l = 0;
        int r = height.length - 1;
        while (l < r) {
            maxValue = Math.max(maxValue, Math.min(height[r], height[l]) * (r - l));
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return maxValue;
    }


    public int maxArea2(int[] height) {
        int maxValue = 0;
        for (int i = 0; i < height.length; i++) {
            int minHeight;
            for (int j = i; j >= 0; j--) {
                minHeight = Math.min(height[i], height[j]);
                maxValue = Math.max(maxValue, (i - j) * minHeight);
            }
        }
        return maxValue;
    }

}
