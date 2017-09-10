package Fivth;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author ranran
 * @version V1.0
 * @Title:
 * @Package Fivth
 * @Description:
 * @date 2017/9/10 19:27
 */
public class TouTiao1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int c = sc.nextInt();
        HashMap<Integer, ArrayList<Integer>> hashMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int len = sc.nextInt(); // 长度
            for (int j = 0; j < len; j++) {
                int key = sc.nextInt();
                ArrayList<Integer> arrayList = new ArrayList<>();
                if (hashMap.containsKey(key)) {
                    arrayList = hashMap.get(key);
                } else {
                    arrayList = new ArrayList<>();
                }
                arrayList.add(i);
                hashMap.put(key, arrayList);
            }
        }

        int count = 0;
        for (ArrayList<Integer> arrayList : hashMap.values()) {
            boolean judge = true;
            for (int i = 0; i < arrayList.size() - 1; i++) {
                if (arrayList.get(i) + m > arrayList.get(i + 1)){
                    count++;
                    judge = false;
                    break; // 下种颜色
                }
            }
            if (judge) {
                int distance = n - arrayList.get(arrayList.size() - 1) +arrayList.get(0);
                if (distance > m) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }


}
