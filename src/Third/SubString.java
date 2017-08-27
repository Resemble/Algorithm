package Third;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author ranran
 * @version V1.0
 * @Title:
 * @Package Third
 * @Description:
 * @date 2017/8/26 15:43
 */
public class SubString {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> arrayList = new ArrayList<>();
        while(scanner.hasNext()) {
            arrayList.add(scanner.nextInt());
        }
//        arrayList.add(-23);
//        arrayList.add(17);
//        arrayList.add(-7);
//        arrayList.add(11);
//        arrayList.add(-2);
//        arrayList.add(1);
//        arrayList.add(-34);

        int max = Integer.MIN_VALUE;
        int tempMax = 0;
        for (int i = 0; i < arrayList.size(); i++) {
            tempMax = Math.max(arrayList.get(i), tempMax + arrayList.get(i));
            max = Math.max(max, tempMax);
        }
        System.out.println(max);
    }


}
