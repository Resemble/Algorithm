package week.week205;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package week.week205
 * @Description:
 * @date 2020-09-06 11:00
 */
public class NumTripletsSolution {
    public int numTriplets(int[] nums1, int[] nums2) {
        return numTripletsHelper(nums1, nums2) + numTripletsHelper(nums2, nums1);
    }

    public int numTripletsHelper(int[] nums1, int[] nums2) {
        long cnt = 0;
        Map<Long, Long> map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            long left = (long) nums1[i] * (long) nums1[i];
            map.put(left, map.getOrDefault(left, 0L) + 1L);
        }
        for (int i = 0; i < nums2.length; i++) {
            for (int j = i + 1; j < nums2.length; j++) {
                long right = (long) nums2[i] * (long) nums2[j];
                if (map.containsKey(right)) {
                    cnt = cnt + map.get(right);
                }
            }
        }
        return (int)cnt;
    }

    public static void main(String[] args) {
        System.out.println((long)1864 * (long)1864);
        System.out.println((long)43024 * (long)99908);
        long value = 43024 * 99908;
        if ((int)value != value) {
            System.out.println("不等");
        }

    }

}
