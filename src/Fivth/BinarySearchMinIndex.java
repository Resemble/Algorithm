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

    // 假设有一个排序的按未知的旋转轴旋转的数组(比如，0 1 2 4 5 6 7 可能成为4 5 6 7 0 1 2)。给定一个目标值进行搜索，
    // 如果在数组中找到目标值返回数组中的索引位置，否则返回-1。
    public static int findTarget(int[] a, int target) {
        int start = 0;
        int end = a.length - 1;
        int mid;
        while(start <= end) {
            mid = (start + end) / 2;
            if(a[mid] == target) {
                return mid;
            }
            if(a[start] <= a[mid]) {
                if(target < a[mid] && target >= a[start]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
            if(a[mid] <= a[end]) {
                if(target <= a[end] && target > a[mid]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }

}
