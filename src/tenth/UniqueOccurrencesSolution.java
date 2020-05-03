package tenth;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package tenth
 * @Description: 1207. 独一无二的出现次数
 * @date 2020-05-03 17:41
 */
public class UniqueOccurrencesSolution {

    public boolean uniqueOccurrences2(int[] arr) {
        int minValue = Integer.MAX_VALUE;
        int maxValue = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            minValue = arr[i] < minValue ? arr[i] : minValue;
            maxValue = arr[i] > maxValue ? arr[i] : maxValue;
        }
        int[] temp = new int[maxValue - minValue + 1];
        for (int i = 0; i < arr.length; i++) {
            temp[arr[i] - minValue]++;
        }
        int[] tempSum = new int[arr.length + 1];
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] != 0) {
                tempSum[temp[i]]++;
            }
        }
        for (int i = 0; i < tempSum.length; i++) {
            if (tempSum[i] >= 2) {
                return false;
            }
        }
        return true;
    }

    public boolean uniqueOccurrences(int[] arr) {

        Map<Integer, Integer> counter = new HashMap<>();
        for (int elem : arr) {
            counter.put(elem, counter.getOrDefault(elem, 0) + 1);
        }

        return counter.size() == new HashSet<Integer>(counter.values()).size();
    }

}
