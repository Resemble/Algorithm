package Sort;

/**
 * @author ranran
 * @version V1.0
 * @Title:
 * @Package Sort
 * @Description: 选择排序，每次在无序队列中“选择”出最小值，放到有序队列的最后，并从无序队列中去除该值
 *
 *    数据交换swap发生在while，for 等循环里面的是 『插入排序』，在循环外的，是『选择排序』。
 *
 * @date 2017/7/21 10:47
 */
public class SelectSortTest {

    public static void selectSort(int[] a) {
        int i;
        int j;
        int temp = 0;
        int flag = 0;
        int n = a.length;
        for (i = 0; i < n; i++) {
            temp = a[i];
            flag = i;
            for (j = i+1; j < n; j++) {
                if (a[j] < temp) {
                    temp = a[j];
                    flag = j;
                }
            }
            if (flag != i) {
                a[flag] = a[i];
                a[i] = temp;
            }
        }
    }

    public static void main(String[] args) {
        long startTime;
        long endTime;
        startTime = System.nanoTime();
        int array[] = {3, 34, 43, 2, 543, 23, 13, 324};
        selectSort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
        endTime = System.nanoTime();
        System.out.println(String.format("this take %s ns", (endTime-startTime))); // this take 438773 ns
    }
}
