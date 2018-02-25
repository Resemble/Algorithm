package Sixth;

/**
 * @author ranran
 * @version V1.0
 * @Title:
 * @Package Sixth
 * @Description:
 *
 * Given two sorted integer arrays A and B, merge B into A as one sorted array.
 * Note:
 * You may assume that A has enough space to hold additional elements from B. The number of elements initialized in A \
 * and B are m and n respectively.
 * @date 2018/2/25 10:38
 */
public class MergeSortedArraySolution {
    public void merge(int A[], int m, int B[], int n) {
        int index = m + n - 1;
        int i = m - 1;
        int j = n - 1;
        while(i >= 0 && j >= 0) {
            A[index--] = A[i] > B[j] ? A[i--] : B[j--];
        }
        while(j >= 0) {
            A[index--] = B[j--];
        }
    }

}
