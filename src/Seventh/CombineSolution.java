package Seventh;

import java.util.ArrayList;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package Seventh
 * @Description:
 * @date 2018/4/3 上午9:43
 */
public class CombineSolution {
    ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        getAllCombineList(1, n, k, new ArrayList<>());
        return res;
    }

    public void getAllCombineList(int start, int n, int k, ArrayList<Integer> list) {
        if(k == 0) {
            res.add(new ArrayList<>(list));  // 如果仅仅add(list)那么list.remove后,这个res也会减少
            return;
        }

        for (int i = start; i <= n; i++) {
            list.add(i);
            getAllCombineList(i + 1, n, k - 1, list);
            list.remove(list.size() - 1);
        }

    }

    public static void main(String[] args) {
        CombineSolution combineSolution = new CombineSolution();
        int n = 1;
        int k = 1;
        combineSolution.combine(n, k);
    }

}
