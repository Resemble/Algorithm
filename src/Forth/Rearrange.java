package Forth;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author ranran
 * @version V1.0
 * @Title:
 * @Package Forth
 * @Description: 一个数组，有正有负，把正的移到右边，负的移到左边。
 * @date 2017/9/4 16:11
 */
public class Rearrange {

    public static void main(String[] args) {
        int[] array = {-2, 1, 7, -5, 9, -12, 15};
        rearrange(array);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }


    public static void rearrange(int[] array) {
        int minIndex = 0;
        int maxIndex = array.length - 1;
        while (minIndex < maxIndex) {
            while (array[minIndex] < 0) {
                minIndex++;
            }
            while (array[maxIndex] > 0) {
                maxIndex--;
            }
            swap(array, minIndex, maxIndex);
            minIndex++;
            maxIndex--;
        }
    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void rearrange2(int[] array) {
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 0) deque.addFirst(array[i]);
            if (array[i] >= 0) deque.addLast(array[i]);
        }
        for (int i = 0; i < array.length; i++) {
            array[i] = deque.pop();
        }
    }



}
