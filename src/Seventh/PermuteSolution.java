package Seventh;

import java.util.ArrayList;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package Seventh
 * @Description: 数组全排列
 * @date 2018/3/20 上午9:26
 */
public class PermuteSolution {


    // 解法二
    ArrayList<ArrayList<Integer>> res2 = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> permute2(int[] num) {
        permutation(num, 0);
        return res2;
    }

    public void permutation(int[] num, int start) {
        if(start == num.length - 1) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < num.length; i++) {
                list.add(num[i]);
            }
            res2.add(list);
        }

        for (int i = start; i < num.length; i++) {
            if(i == start || num[i] != num[start]) {
                // 除了第一个而外后面相同的元素就不排序了
                swap(num, i, start);
                permutation(num, start + 1);
                swap(num, i, start);
            }

        }

    }

    public void swap(int[] num, int i, int j) {
        int temp;
        temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }




    public static void main(String[] args) {
//        ArrayList<Integer> arrayList = new ArrayList<>();
//        ArrayList<Integer> arrayList2 = new ArrayList<>();
//        arrayList.add(1);
//        arrayList.add(2);
//        arrayList.add(3);
//        arrayList2.add(1);
//        arrayList2.add(2);
//        arrayList2.add(3);
//
//
//        HashSet<ArrayList<Integer>> hashSet = new HashSet<>();
//        hashSet.add(arrayList);
//        hashSet.add(arrayList2);
//        hashSet.forEach(System.out::println);

//        System.out.println("-------");
        PermuteSolution permuteSolution = new PermuteSolution();
        int[] num = {1, 2, 3};
//        permuteSolution.swap(num, 0, 1);
//        for (int i = 0; i < num.length; i++) {
//            System.out.println(num[i]);
//        }

        permuteSolution.permute2(num).forEach(System.out::println);

    }

}
