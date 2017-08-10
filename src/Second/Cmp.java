package Second;

import java.util.ArrayList;

/**
 * @author ranran
 * @version V1.0
 * @Title:
 * @Package Second
 * @Description: 小明陪小红去看钻石，他们从一堆钻石中随机抽取两颗并比较她们的重量。这些钻石的重量各不相同。在他们们比较了一段时间后，它们看中了两颗钻石g1和g2。现在请你根据之前比较的信息判断这两颗钻石的哪颗更重。
 * 给定两颗钻石的编号g1,g2，编号从1开始，同时给定关系数组vector,其中元素为一些二元组，第一个元素为一次比较中较重的钻石的编号，第二个元素为较轻的钻石的编号。最后给定之前的比较次数n。
 * 请返回这两颗钻石的关系，若g1更重返回1，g2更重返回-1，无法判断返回0。输入数据保证合法，不会有矛盾情况出现。
 * 测试样例：
 * 2,3,[[1,2],[2,4],[1,3],[4,3]],4
 * 返回: 1
 * @date 2017/8/10 21:38
 */
public class Cmp {

    public static int cmp(int g1, int g2, int[][] records, int n) {
        // write code here
        ArrayList<Integer> biggerThanG1List = new ArrayList<Integer>();
        ArrayList<Integer> smallerThanG1List = new ArrayList<Integer>();
        boolean flag = true;
        for (int i = 0; i < n; i++) {
            if (records[i][0] != records[i][1]) {
                if (records[i][0] == g1) {
                    if (records[i][1] == g2) {
                        return 1;
                    }
                    smallerThanG1List.add(records[i][1]);
                }else if (records[i][1] == g1) {
                    if (records[i][0] == g2) {
                        return -1;
                    }
                    biggerThanG1List.add(records[i][0]);
                }
            }
        }
        while(flag) {
            flag = false;
            for (int i = 0; i < smallerThanG1List.size(); i++) {
                for (int j = 0; j < n; j++) {
                    if (smallerThanG1List.get(i) == records[j][0]) {
                        smallerThanG1List.add(records[j][1]);
                        records[j][0] = -1;
                        flag = true;
                    }
                }
            }
        }
        flag = true;

        while(flag) {
            flag = false;
            for (int i = 0; i < biggerThanG1List.size(); i++) {
                for (int j = 0; j < n; j++) {
                    if (biggerThanG1List.get(i) == records[j][1]) {
                        biggerThanG1List.add(records[j][0]);
                        records[j][1] = -1;
                        flag = true;
                    }
                }
            }
        }
        for (int bigThanG1 : biggerThanG1List) {
            if (bigThanG1 == g2) {
                return -1;
            }
        }

        for (int smallThanG1 : smallerThanG1List) {
            if (smallThanG1 == g2) {
                return 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        // 2,3,[[1,2],[2,4],[1,3],[4,3]],4
        int g1 = 2;
        int g2 = 3;
        int[][] records = new int[4][2];
        records[0][0] = 1;
        records[0][1] = 2;
        records[1][0] = 2;
        records[1][1] = 4;
        records[2][0] = 1;
        records[2][1] = 3;
        records[3][0] = 4;
        records[3][1] = 3;
        int n = 4;
        System.out.println(cmp(g1, g2, records, n));
    }

}
