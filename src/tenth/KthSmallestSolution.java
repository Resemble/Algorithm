package tenth;

import java.util.Arrays;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package tenth
 * @Description: 378. 有序矩阵中第K小的元素
 * @date 2019-08-18 22:10
 */
public class KthSmallestSolution {


    public int kthSmallest(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        int low = matrix[0][0];
        int high = matrix[m - 1][n - 1];
        while (low <= high) {
            int cnt = 0;
            int mid = low + (high - low) / 2;
            int i = m - 1;
            int j = 0;
            while (i >= 0 && j < n) {
                if (matrix[i][j] <= mid) {
                    cnt = cnt + i + 1;
                    j++;
                } else {
                    i--;
                }
            }
            if (cnt < k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    public int kthSmallest2(int[][] matrix, int k) {
        int[] array = new int[matrix.length * matrix.length];
        int index = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                array[index] = matrix[i][j];
                index++;
            }
        }
        Arrays.sort(array);
        return array[k - 1];
    }

}
