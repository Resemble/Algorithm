package Sort;

/**
 * @author ranran
 * @version V1.0
 * @Title:
 * @Package Sort
 * @Description: 非递归，循环 注意 >> 运算符优先级小于 +
 * @date 2017/7/31 21:10
 */
public class BinarySearchTest2 {

    public static int getIndexByNum(int[] array, int num) {
        int left = 0;
        int right = array.length -1;
        int mid;

        while (left <= right) {
//            System.out.println("left:" + left + " right:" + right);
//            mid = (right + left) >> 1;
//            System.out.println("*** mid:" + mid);
            mid = left + ((right - left) >> 1);
//            mid = left + ((right - left) >> 1);
//            System.out.println("*** mid:" + mid);

            if (array[mid] == num) {
                return mid;
            } else if (array[mid] > num) {
                right = mid - 1;
            } else if (array[mid] < num) {
                left = mid + 1;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        System.out.println("5 / 2: " + (5 / 2));
        System.out.println("1 / 2: " + (1 / 2));
        System.out.println("1 / 2: " + (1 / 2));
        System.out.println("3 >> 1: " + (3 >> 1));
        System.out.println("2 >> 1: " + (2 >> 1));
        System.out.println("1 >> 1: " + (1 >> 1));

        int array[] = {3, 34, 38, 43, 203, 304, 543, 2344, 13324, 324324};
        System.out.println(getIndexByNum(array, 2));
        System.out.println(getIndexByNum(array, 3));
        System.out.println(getIndexByNum(array, 34));
        System.out.println(getIndexByNum(array, 35));
        System.out.println(getIndexByNum(array, 38));
        System.out.println(getIndexByNum(array, 304));
        System.out.println(getIndexByNum(array, 324324));
        System.out.println(getIndexByNum(array, 3243243));


    }
}
