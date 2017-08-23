package Sort;

/**
 * @author ranran
 * @version V1.0
 * @Title:
 * @Package Sort
 * @Description: 冒泡排序，2重循环，第二重循环不断交换到第一个
 * @date 2017/7/21 14:33
 */
public class BubbleSortTest {

    public static void BublleSort(int array[]) {
        int i, j;
        int len = array.length;
        int tmp;
        for (i = 0; i < len - 1; i++) {
            boolean booleanSwap = false; // 最优时间复杂度，数据正序排列
            for (j = len - 1; j > i; j--) {
                if (array[j] < array[j-1]) {
                    tmp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = tmp;
                    booleanSwap = true;
                }
                if (!booleanSwap) {
                    return;
                }
            }
        }
    }

    public static void main(String[] args) {
        long startTime;
        long endTime;
        startTime = System.nanoTime();
//        int array[] = {3, 34, 43, 2, 543, 23, 13, 324};
        int array[] = {3, 34, 43, 543, 324};
        BublleSort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
        endTime = System.nanoTime();
        System.out.println(String.format("this take %s ns", (endTime - startTime)));
    }


}
