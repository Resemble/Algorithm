package tenth;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package tenth
 * @Description:
 * @date 2019-07-22 22:27
 */
public class KClosestSolution {

    class Axis {
        int x;
        int y;

        public Axis(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int[][] kClosest(int[][] points, int K) {
        if (K <= 0) {
            return new int[points.length][2];
        }
        if (K > points.length) {
            return points;
        }
        PriorityQueue<Axis> axisPriorityQueue = new PriorityQueue<>(new Comparator<Axis>() {
            @Override public int compare(Axis o1, Axis o2) {
                int o1XY = o1.x * o1.x + o1.y * o1.y;
                int o2XY = o2.x * o2.x + o2.y * o2.y;
                /* 后放入的是否需要交换位置 */
                if (o2XY < o1XY) {
                    return 1;
                } else if (o2XY > o1XY) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
        for (int i = 0; i < points.length; i++) {
            Axis axis = new Axis(points[i][0], points[i][1]);
            axisPriorityQueue.add(axis);
        }
        int[][] result = new int[K][2];
        for (int i = 0; i < K; i++) {
            Axis axis = axisPriorityQueue.poll();
            result[i][0] = axis.x;
            result[i][1] = axis.y;
        }
        return result;
    }

}
