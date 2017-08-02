package Sort;


/**
 * @author ranran
 * @version V1.0
 * @Title:
 * @Package Sort
 * @Description: 时间复杂度低，而且好看
 * @date 2017/7/30 21:31
 */
public class MergeSortTest2 {


    public static void sort(int[] arr) {
        int[] helper = new int[arr.length];
        sort(arr, 0, arr.length - 1, helper);
    }

    private static void sort(int[] arr, int low, int high, int[] helper) {
        if (low >= high) {
            return;
        }
        int mid = low + (high - low) / 2;
        sort(arr, low, mid, helper);
        sort(arr, mid + 1, high, helper);
        merge(arr, low, mid, high, helper);
    }

    private static void merge(int[] arr, int low, int mid, int high, int[] helper) {
        for (int i = low; i <= high; i++) {
            helper[i] = arr[i];
        }
        int i = low;
        int j = mid + 1;
        for (int k = low; k <= high; k++) {
            if (i > mid) {
                // 左边已合并完
                arr[k] = helper[j++];
            } else if (j > high) {
                // 右边已合并完
                arr[k] = helper[i++];
            } else if (helper[i] < helper[j]) {
                // 左边小于右边
                arr[k] = helper[i++];
            } else {
                // 左边大于等于右边
                arr[k] = helper[j++];
            }

        }

    }


    public static void main(String[] args) {
        long startTime;
        long endTime;
        startTime = System.nanoTime();
//        int array[] = getRandomArray(400);
        int array[] = {3,2,1,4,5};
        sort(array);

        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
        endTime = System.nanoTime();
        System.out.println(String.format("this take %s ns", (endTime - startTime)));
    }
}
