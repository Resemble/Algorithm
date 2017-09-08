package Forth;

/**
 * @author ranran
 * @version V1.0
 * @Title:
 * @Package Forth
 * @Description:
 * 在一条环路上有 N 个加油站，其中第 i 个加油站有汽油gas[i]，并且从第_i_个加油站前往第_i_+1个加油站需要消耗汽油cost[i]。
  你有一辆油箱容量无限大的汽车，现在要从某一个加油站出发绕环路一周，一开始油箱为空。
  求可环绕环路一周时出发的加油站的编号，若不存在环绕一周的方案，则返回-1。
 * @date 2017/9/8 10:31
 */
public class CanCompleteCircuitSolution {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        // write your code here
        int[] rest = new int[gas.length];
        for (int i = 0; i < gas.length; i++) {
            rest[i] = gas[i] - cost[i];
        }
        int tank = 0;
        int index = 0;
        int res = 0;
        for (int i = 0; i < gas.length * 2 - 1; i++) {
            index = i % gas.length;
            tank += rest[index];
            if (tank < 0) {
                tank = 0;
                res = i + 1;
            }
        }
        return res > gas.length ? -1 : res;


    }

}
