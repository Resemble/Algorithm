package package12;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package package12
 * @Description: 169. 多数元素
 * https://leetcode-cn.com/problems/majority-element/
 * @date 2020-12-13 11:41
 */
public class MajorityElementSolution {

    public int majorityElement(int[] nums) {
        int element = nums[0];
        int cnt = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == element) {
                cnt++;
            } else {
                if (cnt == 0) {
                    element = nums[i];
                    cnt++;
                } else{
                    cnt--;
                }
            }
        }
        return element;
    }

    public int majorityElement2(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > nums.length / 2) {
                return entry.getKey();
            }
        }
        return 0;
    }

}
