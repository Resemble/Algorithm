package eighth;

import java.util.HashMap;
import java.util.List;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package eighth
 * @Description:
 * @date 2019/3/2 5:18 PM
 */
public class MajorityNumberSolution {

    /**
     * @param nums: A list of integers
     * @param k: An integer
     * @return: The majority number
     */
    public int majorityNumber(List<Integer> nums, int k) {
        // write your code here
        int majorNumber = nums.size() / k;
        HashMap<Integer, Integer> countHashMap = new HashMap<>();
        for (int i = 0; i < nums.size(); i++) {
            if (countHashMap.containsKey(nums.get(i))) {
                int temp = countHashMap.get(nums.get(i));
                countHashMap.put(nums.get(i), temp + 1);
            } else {
                countHashMap.put(nums.get(i), 1);
            }
        }
        for (Integer key : countHashMap.keySet()) {
            int value = countHashMap.get(key);
            if (value > majorNumber) {
                return key;
            }
        }
        return 0;
    }

}
