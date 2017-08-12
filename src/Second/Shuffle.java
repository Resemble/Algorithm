package Second;

import java.util.Scanner;

/**
 * @author ranran
 * @version V1.0
 * @Title:
 * @Package Second
 * @Description: 洗牌
 * @date 2017/8/12 9:17
 */
public class Shuffle {


    public static void shuffleArray(int[] array, int k) {

        int[] tempArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            tempArray[i] = array[i];
        }
        for (int i = 0; i < array.length - 1; i = i + 2) {
            array[i] = tempArray[array.length - 1 - i / 2];
            array[i + 1] = tempArray[array.length/2 - 1 - i / 2];
        }

//        for (int i = 0; i < array.length; i++) {
//            System.out.println(array[i]);
//        }

        int temp;
        for (int i = 0; i < array.length / 2; i++) {
            temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 -i] = temp;
        }
        if (k == 1) {
            for (int i = 0; i < array.length - 1; i++) {
                System.out.print(array[i] + " ");
            }
            System.out.print(array[array.length - 1]);
        }
        if (k > 1) {

            shuffleArray(array, k - 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int[][] nk = new int[T][2];
        for (int i = 0; i < T; i++) {
            nk[i][0] = sc.nextInt();
            nk[i][1] = sc.nextInt();
            int[] array = new int[nk[i][0] * 2];
            for (int j = 0; j < nk[i][0] * 2; j++) {
                array[j] = sc.nextInt();
            }
            shuffleArray(array, nk[i][1]);
            System.out.println();
        }

    }

}
