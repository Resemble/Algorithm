package Seventh;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package Seventh
 * @Description:
 * Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.
 *
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 *
 * Note:
 * You are not suppose to use the library's sort function for this problem.
 *
 * click to show follow up.
 *
 * Follow up:
 * A rather straight forward solution is a two-pass algorithm using counting sort.
 * First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.
 *
 * Could you come up with an one-pass algorithm using only constant space?
 * @date 2018/7/21 下午2:57
 */
public class SortColorsSulution {

    public void sortColors(int[] A) {
        int red = 0;
        int white = 0;
        int blue = 0;
        for (int i = 0; i < A.length; i++) {
            if(A[i] == 0) {
                red++;
            } else if(A[i] == 1) {
                white++;
            } else if(A[i] == 2) {
                blue++;
            }
        }
        int index = 0;
        for (int i = 0; i < red; i++) {
            A[index] = 0;
            index++;
        }
        for (int i = 0; i < white; i++) {
            A[index] = 1;
            index++;
        }
        for (int i = 0; i < blue; i++) {
            A[index] = 2;
            index++;
        }
    }

    public void sortColors2(int[] A) {
        int redIndex = 0;
        int blueIndex = A.length - 1;

        for (int i = 0; i < blueIndex + 1; i++) {
            if(A[i] == 0){
                swap(A, redIndex, i);
                redIndex++;
            } else if(A[i] == 2) {
                swap(A, blueIndex, i);
                blueIndex--;
                i--;
            }
        }

    }

    public void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    public static void main(String[] args) {
        int[] A = {0, 1, 2};
        SortColorsSulution sortColorsSulution = new SortColorsSulution();
        sortColorsSulution.sortColors2(A);
        for (int i = 0; i < A.length; i++) {
            System.out.println(A[i]);
        }
    }

}
