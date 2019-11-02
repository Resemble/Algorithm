package tenth;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package tenth
 * @Description: 1094. 拼车
 * @date 2019-11-02 17:49
 */
public class CarPoolingSolution {

    public boolean carPooling(int[][] trips, int capacity) {
        int[] arr = new int[1001];
        for (int i = 0; i < trips.length; i++) {
            int num = trips[i][0];
            int start = trips[i][1];
            int end = trips[i][2];
            /** 上车减容量，下次加容量 */
            arr[start] = arr[start] - num;
            arr[end] = arr[end] + num;
        }
        for (int i = 0; i < arr.length; i++) {
            capacity = capacity + arr[i];
            if (capacity < 0) {
                return false;
            }
        }
        return true;
    }

}
