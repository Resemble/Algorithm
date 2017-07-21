package Sort;

/**
 * @author ranran
 * @version V1.0
 * @Title:
 * @Package Sort
 * @Description:
 * @date 2017/7/21 11:02
 */
public class InsertSortTest {

    public static void insertSort(int[] a) {
        if (a != null) {
            for (int i = 1; i < a.length; i++) {
                int temp = a[i], j = i;
                if (a[j - 1] > temp) {
                    // 依次往左对比，直到找到合适的位置
                    while (j >= 1 && a[j - 1] > temp) {
                        a[j] = a[j - 1];
                        j--;
                    }
                }
                a[j] = temp;
            }
        }
    }

    public static void main(String[] args) {
        long startTime;
        long endTime;
        startTime = System.nanoTime();
        int array[] = {3, 34, 43, 2, 543, 23, 13, 324};
        insertSort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
        endTime = System.nanoTime();
        System.out.println(String.format("this take %s ns", (endTime - startTime))); //
    }


}
