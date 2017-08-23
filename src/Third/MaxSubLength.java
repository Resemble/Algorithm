package Third;

import java.util.HashMap;

/**
 * @author ranran
 * @version V1.0
 * @Title:
 * @Package Third
 * @Description:给定一个无需数组arr,其中元素可正，可负，可0，给定一个整数k。求arr的所有子数组中累加和为k的最长子数组的长度。
 * @date 2017/8/23 22:12
 */
public class MaxSubLength {

    public static int maxLength(int[] array, int k) {
        int sum = 0;
        int result = 0;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(0, -1);
        for (int i = 0; i < array.length; i++) {
            sum = sum + array[i];

            if (hashMap.containsKey(sum - k)) {
                result = Math.max(result, i - hashMap.get(sum - k));
            }

            if (!hashMap.containsKey(sum)) {
                hashMap.put(sum, i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] array = {1, 3, 5, 7, 6, 2};
        System.out.println(maxLength(array, 16));
        System.out.println(maxLength(array, 18));

        int[] array2 = {1, 3, -5, 7, 6, 2};
        System.out.println(maxLength(array2, 11));
        System.out.println(maxLength(array2, 13));



    }

}
