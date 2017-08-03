package First;

/**
 * @author ranran
 * @version V1.0
 * @Title:
 * @Package First
 * @Description: 逆序对
 * 在数组中的两个数字如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。给你一个数组，求出这个数组中逆序对的总数。
    概括：如果a[i] > a[j] 且 i < j， a[i] 和 a[j] 构成一个逆序对。

    您在真实的面试中是否遇到过这个题？ Yes
    样例
    序列 [2, 4, 1, 3, 5] 中，有 3 个逆序对 (2, 1), (4, 1), (4, 3)，则返回 3 。
 * @date 2017/8/2 17:35
 */
public class ReversePairsSolution {

    private static long totalReversePairs = 0;

    public static void mergeSort(int[] array) {
        int copyArray[] = new int[array.length];
        mergeSort(array, 0, array.length - 1, copyArray);
    }

    public static void mergeSort(int[] array, int low, int high, int[] copyArray) {
        if (low < high) {
           int mid = (low + high) / 2;
           mergeSort(array, low, mid, copyArray);
           mergeSort(array, mid + 1, high, copyArray);
           merge(array, low, mid, high, copyArray);
        }
    }

    public static void merge(int[] array, int low, int mid, int high, int[] copyArray) {
        for (int i = low; i <= high; i++) {
            copyArray[i] = array[i];
        }
        int i = low;
        int j = mid + 1;
        int count = 0;
        for (int k = low; k <= high; k++) {
            if (i > mid) {
                 array[k] = copyArray[j++];
            } else if (j > high) {
                count = k - i;
                totalReversePairs += count;
                array[k] = copyArray[i++];
            } else if (copyArray[i] <= copyArray[j]) {
                count = k - i;
                totalReversePairs += count;
                array[k] = copyArray[i++];
            } else if (copyArray[i] > copyArray[j]) {  // 注意小于右移
                array[k] = copyArray[j++];
            }
        }
    }


    public static long reversePairs(int[] A) {
        // Write your code here
        mergeSort(A);
        return totalReversePairs;
    }

    public static void main(String[] args) {
        int array[] = {2, 4, 1, 3, 5};
//        mergeSort(array);
        System.out.println(reversePairs(array));
//        for (int i = 0; i < array.length; i++) {
//            System.out.println(array[i]);
//        }
    }


}
