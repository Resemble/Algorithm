package Sort;

/**
 * @author ranran
 * @version V1.0
 * @Title:
 * @Package Sort
 * @Description:
 * @date 2017/7/21 16:32
 */
public class ShellSortTest {

    public static void shellSort(int array[]) {
        int length = array.length;
        int i, j;
        int h;
        int temp;
        for (h = length / 2; h > 0; h = h / 2) {
            for (i = h; i < length; i++) {
                temp = array[i];
                for (j = i - h; j >= 0; j -= h) {
                    if (temp < array[j]) {
                        array[j + h] = array[j];
                    } else {
                        break;
                    }
                }
                array[j + h] = temp;
            }
        }
    }

}
