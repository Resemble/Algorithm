package Sixth;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package Sixth
 * @Description:
 * @date 2018/3/6 上午9:43
 */
public class RemoveDuplicatesSolution {

    public int removeDuplicates(int[] A) {
        int index = 2;
        if(A.length < 3) {
            return A.length;
        }
        int count = 1;
        for (int i = 2; i < A.length; i++) {
            if(A[i] != A[index - 2]) {
                A[index] = A[i];
                index++;
            }
        }
        return index;
    }

}
