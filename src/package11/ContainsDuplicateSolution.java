package package11;

import java.util.HashSet;
import java.util.Set;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package package11
 * @Description: 存在重复元素
 * @date 2020-06-20 17:15
 */
public class ContainsDuplicateSolution {

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        if (set.size() < nums.length) {
            return true;
        }
        return false;
    }

}
