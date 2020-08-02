package week.week200;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package week.week200
 * @Description:
 * @date 2020-08-02 11:37
 */
public class MaxSumSolution {


    public int maxSum(int[] nums1, int[] nums2) {
        long sum1 = 0;
        long sum2 = 0;
        int i = nums1.length - 1;
        int j = nums2.length - 1;
        while (i >= 0 || j >= 0) {
            if (i < 0) {
                sum2 = sum2 + nums2[j];
                j--;
            } else if (j < 0) {
                sum1 = sum1 + nums1[i];
                i--;
            } else if (nums1[i] == nums2[j]) {
                sum1 = sum2 = nums1[i] + Math.max(sum1, sum2);
                i--;
                j--;
            } else if (nums1[i] > nums2[j]) {
                sum1 = sum1 + nums1[i];
                i--;
            } else {
                sum2 = sum2 + nums2[j];
                j--;
            }
        }
        return (int) (Math.max(sum1, sum2) % (Math.pow(10, 9) + 7));
    }

    public int maxSum2(int[] nums1, int[] nums2) {
        int mod = (int) Math.pow(10, 9) + 7;

        Map<Long, Long> map = new HashMap<>();
        int i = nums1.length - 1;
        int j = nums2.length - 1;
        while (i >= 0 || j >= 0) {
            long value;
            if (i < 0 || j >= 0 && nums1[i] < nums2[j]) {
                if (j == nums2.length - 1) {
                    value = nums2[j];
                } else {
                    value = nums2[j] + map.get(Long.valueOf(nums2[j + 1]));
                }
                value = Math.max(map.getOrDefault(Long.valueOf(nums2[j]), 0L), value);
                map.put(Long.valueOf(nums2[j]), value);
                j--;
            } else {
                if (i == nums1.length - 1) {
                    value = nums1[i];
                } else {
                    value = nums1[i] + map.get(Long.valueOf(nums1[i + 1]));
                }
                value = Math.max(map.getOrDefault(Long.valueOf(nums1[i]), 0L), value);
                map.put(Long.valueOf(nums1[i]), value);
                i--;
            }
        }
        return (int) (Math.max(map.get(Long.valueOf(nums1[0])), map.get(Long.valueOf(nums2[0])))
            % mod);
    }

}
