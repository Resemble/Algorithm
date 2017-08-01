package First;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author ranran
 * @version V1.0
 * @Title:
 * @Package First
 * @Description: 返回两个数组的交
 * @date 2017/8/1 9:38
 */
public class IntersectionSolution {

    public int[] intersection(int[] nums1, int[] nums2) {
        // Write your code here
        ArrayList<Integer> arrayList = new ArrayList<>();

        HashMap<Integer, Boolean> nums1HashMap = new HashMap<>();
        HashMap<Integer, Boolean> nums2HashMap = new HashMap<>();

        for (int i = 0; i < nums1.length; i++) {
            nums1HashMap.put(nums1[i], true);
        }
        for (int i = 0; i < nums2.length; i++) {
            nums2HashMap.put(nums2[i], true);
        }

        for(int key : nums1HashMap.keySet()) {
            if (nums2HashMap.containsKey(key)) {
                arrayList.add(key);

            }
        }
        int[] result = new int[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            result[i] = arrayList.get(i);
        }
        return result;
    }

}
