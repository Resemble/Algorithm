package Sort;

/**
 * @author ranran
 * @version V1.0
 * @Title:
 * @Package Sort
 * @Description: 归并排序，递归和分治技术
 * @date 2017/7/21 14:52
 */
public class MergeSortTest {

    public static void Merge(int array[], int p, int q, int r) {
        int i, j, k, n1, n2;
        n1 = q - p + 1;
        n2 = r - q;
        int[] L = new int[n1];
        int[] R = new int[n2];
        // 左边赋值
        for (i = 0, k = p; i < n1; i++, k++) {
            L[i] = array[k];
        }
        // 右边赋值
        for(i = 0, k = q+1; i < n2; i++, k++) {
            R[i] = array[k];
        }
        // 2个都遍历完，排序
        for(k = p, i = 0, j = 0; i < n1 && j < n2; k++) {
            if(L[i] > R[j]) {
                array[k] = L[i];
                i++;
            } else {
                array[k] = R[j];
                j++;
            }
        }
        if (i < n1) {
            for(j = i; j < n1; j++, k++) {
                array[k] = L[j];
            }
        }
        if (j < n2) {
            for(i = j; i < n2; i++, k++) {
                array[k] = R[i];
            }
        }

    }

    public static void MergeSort(int array[], int p, int r) {
        if (p < r) {
            int q = (p+r)/2;
            MergeSort(array, p, q);  // 左
            MergeSort(array, q+1, r); // 右
            Merge(array, p, q, r); // 合并左右
        }
    }

    public static void main(String[] args) {
        long startTime;
        long endTime;
        startTime = System.nanoTime();
        int array[] = {3, 34, 43, 2, 543, 23, 13, 324};
        MergeSort(array, 0, array.length-1);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
        endTime = System.nanoTime();
        System.out.println(String.format("this take %s ns", (endTime - startTime)));
    }

}
