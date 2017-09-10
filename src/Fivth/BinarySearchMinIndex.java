package Fivth;

/**
 * @author ranran
 * @version V1.0
 * @Title:
 * @Package Fivth
 * @Description: 二分查找最大下标和最小下标
 * @date 2017/9/10 22:57
 */
public class BinarySearchMinIndex {

    public static void main(String[] args) {
//        int[] array = {1, 2, 2, 2, 3};
//        int[] array = {1, 2, 2, 2, 2};
        int[] array = {3};
        System.out.println(firstIndex(array, 2));
        System.out.println(lastIndex(array, 2));
    }

    // 查找数组中某个数的位置的最小下标，没有返回-1
    public static int firstIndex(int[] a, int key) {
        int low = 0;
        int high = a.length - 1;
        int mid = 0;
        while(low <= high) {
            mid = low + ((high-low) >> 1);
            if (key <= a[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        System.out.println("firstIndex low:" + low + " high:" + high);
        return (low <= a.length - 1) && (a[low] == key) ? low : -1;
    }

    // 查找数组中某个数的位置的最大下标，没有返回-1
    public static int lastIndex(int[] a, int key) {
        int low = 0;
        int high = a.length - 1;
        int mid = 0;
        while(low <= high) {
            mid = low + ((high-low) >> 1);
            if (key >= a[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        System.out.println("lastIndex low:" + low + " high:" + high);
//        return (low - 1 >= 0 && (a[low - 1] == key )) ? low - 1 : -1;
        return (high >= 0 && a[high] == key ) ? high : -1;
    }
}
