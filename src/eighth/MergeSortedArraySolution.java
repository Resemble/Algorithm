package eighth;

import java.util.Arrays;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package eighth
 * @Description:
 * @date 2019/3/2 4:37 PM
 */
public class MergeSortedArraySolution {

    /**
     * @param A: sorted integer array A
     * @param B: sorted integer array B
     * @return: A new sorted integer array
     */
    public static int[] mergeSortedArray(int[] A, int[] B) {
        // write your code here
        int aLen = A.length;
        int bLen = B.length;
        int[] result = new int[aLen + bLen];
        for (int i = 0, j = 0; i < aLen || j < bLen;) {

            if(i == aLen) {
                result[i + j] = B[j];
                j++;
                if (j == bLen) break;
            }
            if (j == bLen) {
                result[i + j] = A[i];
                i++;
                if (i == aLen) break;
            }
            if (i != aLen && j != bLen) {
                if(A[i] == B[j]) {
                    result[i + j] = A[i];
                    result[i + j + 1] = B[j];
                    i++;
                    j++;
                } else if (A[i] < B[j]) {
                    result[i + j] = A[i];
                    i++;
                } else if (A[i] > B[j]) {
                    result[i + j] = B[j];
                    j++;
                }
            }

        }
        return result;
    }

    public static void main(String[] args) {
        int A[] = {1,2,3,4};
        int B[] = {2,4,5,6};

        System.out.println(Arrays.toString(mergeSortedArray(A, B)));
    }

}
