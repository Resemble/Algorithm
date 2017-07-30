package Sort;

/**
 * @author ranran
 * @version V1.0
 * @Title:
 * @Package Sort
 * @Description:
 * @date 2017/7/30 21:49
 */
public class MidGetTest {

    public static int getIndexOfNumByMid(int array[], int low, int high, int num) {
        if (num > array[high] || num < array[low]) {
//            System.out.println("num:" + num);
//            System.out.println("array[low]:" + array[low]);
//            System.out.println("array[high]:" + array[high]);
            return -1;
        }
        int mid = (low + high) / 2;
        if (array[mid] == num) {
            return mid;
        } else if (array[mid] < num) {
            return getIndexOfNumByMid(array, mid + 1, high, num);
        } else {
            return getIndexOfNumByMid(array, low, mid - 1, num);
        }
    }

    public static void main(String[] args) {
        int array[] = {3, 34, 38, 43, 203, 304, 543, 2344, 13324, 324324};
        int index = getIndexOfNumByMid(array, 0, array.length - 1, 34);
        System.out.println(index);
    }

}
