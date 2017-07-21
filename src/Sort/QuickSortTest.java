package Sort;

/**
 * @author ranran
 * @version V1.0
 * @Title:
 * @Package Sort
 * @Description: 快速排序，左右填坑，分治法，平均效果最好的排序
 *  当初始的序列整体或局部有序时，快速排序的性能将会下降，此时，快速排序将退化为冒泡排序，填左坑直到第二个
 * @date 2017/7/21 15:22
 */
public class QuickSortTest {

    public static void sort(int array[], int low, int high) {
        int i, j;
        int index;
        if (low >= high) return;

        i = low;
        j = high;
        index = array[i];
        while (i < j) {
            while (i < j && array[j] >= index) {
                j--;
            }
            if (i < j) {
                array[i++] = array[j]; // 填左坑
            }
            while (i < j && array[i] < index) {
                i++;
            }
            if (i < j) {
                array[j--] = array[i]; // 填右坑
            }
        }
        array[i] = index;
        sort(array, low, i - 1);
        sort(array, i + 1, high);
    }


    public static void quickSort(int array[]) {
        sort(array, 0, array.length - 1);
    }


    public static void main(String[] args) {
        long startTime;
        long endTime;
        startTime = System.nanoTime();
        int array[] = {3, 34, 43, 2, 543, 23, 13, 324};
        quickSort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
        endTime = System.nanoTime();
        System.out.println(String.format("this take %s ns", (endTime - startTime)));
    }


}
