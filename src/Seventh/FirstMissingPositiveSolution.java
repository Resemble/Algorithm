package Seventh;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package Seventh
 * @Description:
 * @date 2018/3/30 上午9:57
 */
public class FirstMissingPositiveSolution {

    public int firstMissingPositive(int[] A) {
        if (A == null || A.length == 0)  // 防止越界
            return 1;
        for (int i = 0; i < A.length; i++) {
            //    A[i] - 1 < A.length 超出范围不交换    A[i] != A[A[i] - 1] 相等不交换
            while (A[i] > 0 && A[i] != i + 1 && A[i] - 1 < A.length && A[i] != A[A[i] - 1]) {
                swap(A, i, A[i] - 1);
            }

        }
        for (int i = 0; i < A.length; i++) {
            if (A[i] != i + 1) {
                return i + 1;  // 第一个不相等就返回
            }
        }
        return A[A.length - 1] + 1;  // 数组交换后是有序正数,就返回最大 + 1
    }

    public void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    public static void main(String[] args) {
        //        int[] A = {1,2,0};
        int[] A = {3, 4, -1, 1};
        FirstMissingPositiveSolution fmp = new FirstMissingPositiveSolution();
        System.out.println(fmp.firstMissingPositive(A));
        for (int i = 0; i < A.length; i++) {
            System.out.print(A[i] + " ");
        }
    }

}
