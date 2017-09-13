package Fivth;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author ranran
 * @version V1.0
 * @Title:
 * @Package Fivth
 * @Description:
 * @date 2017/9/13 19:37
 */
public class HuaWei3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String string = sc.nextLine();
        int n = sc.nextInt();
        String[] strings = string.split(" ");
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < strings.length; i++) {
            arrayList.add(Integer.parseInt(strings[i]));
        }
        Collections.sort(arrayList, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int value1 = o1 % 1000;
                int value2 = o2 % 1000;
                return value1 - value2;
            }
        });
//        for (int i = 0; i < arrayList.size(); i++) {
//            System.out.println(arrayList.get(i));
//        }
        System.out.println(arrayList.get(n - 1));
    }

}
