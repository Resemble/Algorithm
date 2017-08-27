package Third;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author ranran
 * @version V1.0
 * @Title:
 * @Package Third
 * @Description:
 * @date 2017/8/26 16:02
 */
public class GetTheNthNumber {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> arrayList = new ArrayList<>();
        while(scanner.hasNext()) {
            arrayList.add(scanner.nextInt());
        }

        int Nth = arrayList.get(arrayList.size() - 1);
        int[] array = new int[arrayList.size() - 1];
        for (int i = 0; i < array.length; i++) {
            array[i] = arrayList.get(i);
        }

        quickSort(array);
        System.out.println(array[array.length - Nth]);

    }


    public static void sort(int array[], int low, int high) {
        if (low > high) {
            return;
        }
        int i = low;
        int j = high;
        int temp = array[i];
        while (i < j) {  // while 循环保证一个数一直填坑
            while (i < j && array[j] >= temp) {
                j--;
            }
            array[i] = array[j];
            while (i < j && array[i] < temp) {
                i++;
            }
            array[j] = array[i];
        }
        array[j] = temp;
        sort(array, low, j - 1);
        sort(array, j + 1, high);
    }

    public static void quickSort(int array[]) {
        sort(array, 0, array.length - 1);
    }


}
