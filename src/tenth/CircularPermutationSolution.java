package tenth;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package tenth
 * @Description: 1238. 循环码排列
 * @date 2020-05-04 10:26
 */
public class CircularPermutationSolution {

    List<Integer> res = new ArrayList<>();
    int[] flag; // 保存那个数用没用过，1表示用过，0表示没用过

    public List<Integer> circularPermutation(int n, int start) {
        int size = 1 << n;
        flag = new int[size];
        flag[start] = 1;
        res.add(start); // 固定0位
        dfs(start, n, 0);
        return res;
    }


    /**
     * @title dfs
     * @description
     * @param: left 表示当前 index 的左边是什么数， index 要填的数只要二进位与该数1位不同即可
     * @param: n 表示每个数的最多二进制位数，所以每个 index 下可填的数最多 n 种可能
     * @param: index 当前枚举到那个数
     * @return boolean
     */
    public boolean dfs(int left, int n, int index) {
        // 枚举到 size -1 表示成功找到合法解
        int size = 1 << n;
        if (index == size - 1) {
            return true;
        }
        // 枚举n种情况
        for (int i = 0; i < n; i++) {
            // 异或找到 与 left 只有一位不同的数
            int num = left ^ (1 << i);
            if (flag[num] == 0) {
                res.add(num);
                flag[num] = 1;
                if (dfs(num, n, index + 1)) {
                    return true;
                }
                // 恢复现场
                flag[num] = 0;
            }
        }
        return false;
    }




}
