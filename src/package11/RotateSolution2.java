package package11;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package package11
 * @Description: 48. 旋转图像
 * https://leetcode-cn.com/problems/rotate-image/
 * @date 2020-06-20 18:39
 */
public class RotateSolution2 {

    public void rotate(int[][] matrix) {
        int abs1 = 0;
        int abs2 = matrix.length - 1;
        while (abs1 <= abs2) {
            int p1 = abs1;
            int p2 = abs2;
            while (p1 != abs2) {
                int temp = matrix[abs1][p1]; // 左上
                matrix[abs1][p1] = matrix[p2][abs1]; // 左上 = 左下
                matrix[p2][abs1] = matrix[abs2][p2]; // 左下 = 右下
                matrix[abs2][p2] = matrix[p1][abs2]; // 右下 = 右上
                matrix[p1][abs2] = temp; // 右上 = 左上
                p1 += 1;
                p2 -= 1;
            }
            abs1 += 1;
            abs2 -= 1;
        }
    }
}
