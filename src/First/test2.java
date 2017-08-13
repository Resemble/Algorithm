package First;

import java.util.Arrays;

/**
 * @author ranran
 * @version V1.0
 * @Title:
 * @Package First
 * @Description:
 * @date 2017/8/12 16:32
 */
public class test2 {
    public static void main(String[] args) {
        int[] tes = new int[3];
        tes[0] = 1;
        tes[1] = 4;
        tes[2] = 3;
        Arrays.sort(tes);
        for (int i = 0; i < tes.length; i++) {
            System.out.println(tes[i]);
        }
        System.out.println();
    }
}
