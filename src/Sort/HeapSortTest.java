package Sort;

/**
 * @author ranran
 * @version V1.0
 * @Title:
 * @Package Sort
 * @Description: 堆排序 1.构建堆 2.交换堆顶元素与最后一个元素的位置
 * @date 2017/7/21 17:01
 */
public class HeapSortTest {

    public static void adjustMinHeap(int[] a, int pos, int len) {
        int temp;
        int child;
        for (temp = a[pos]; 2 * pos + 1 <= len; pos = child) {
            child = 2 * pos + 1;
            if (child < len && a[child] > a[child + 1]) {
                child++;
            }
            if (a[child] < temp) {
                a[pos] = a[child];
            } else {
                break;
            }
        }
        a[pos] = temp;
    }

    public static void myMinHeapSort(int[] array) {
        int i;
        int len = array.length;
        for (i = len/2 - 1; i >= 0; i--) {
            adjustMinHeap(array, i, len -1);
        }
        for (i = len -1; i >= 0; i--) {
            int tmp = array[0];
            array[0] = array[i];
            array[i] = tmp;
            adjustMinHeap(array, 0, i - 1);
        }
    }

    public static void main(String[] args) {
        long startTime;
        long endTime;
        startTime = System.nanoTime();
        int array[] = {3, 34, 43, 2, 543, 23, 13, 324};
        myMinHeapSort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
        endTime = System.nanoTime();
        System.out.println(String.format("this take %s ns", (endTime - startTime)));
    }


}
