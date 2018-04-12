package Seventh;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package Seventh
 * @Description:
 * @date 2018/4/12 上午10:01
 */
public class JumpFloorIISolution {
    public int JumpFloorII(int target) {
        int[] array = new int[target];
        array[0] = 1;
        for (int i = 1; i < target; i++) {
            array[i]++;
            for (int j = i - 1; j >= 0; j--) {
                array[i] = array[i] + array[j];
            }
        }
        return array[target - 1];
    }
}
