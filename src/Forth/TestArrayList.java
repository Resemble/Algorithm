package Forth;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author ranran
 * @version V1.0
 * @Title:
 * @Package Forth
 * @Description:
 * @date 2017/9/9 9:54
 */
public class TestArrayList {

    static class ClassInfo {
        public int avgAge;
        public int num;

        public ClassInfo(int avgAge, int num) {
            this.avgAge = avgAge;
            this.num = num;
        }
    }



    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(3);
        arrayList.add(322);
        arrayList.add(33);
        arrayList.add(23);
        arrayList.add(13);
        arrayList.add(344);
        arrayList.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i));
        }


        ClassInfo classInfo1 = new ClassInfo(2, 35);
        ClassInfo classInfo2 = new ClassInfo(32, 32);
        ClassInfo classInfo3 = new ClassInfo(2, 33);
        ClassInfo classInfo4 = new ClassInfo(23, 3);
        ClassInfo classInfo5 = new ClassInfo(2, 13);

        ArrayList<ClassInfo> arrayList1 = new ArrayList<>();
        arrayList1.add(classInfo1);
        arrayList1.add(classInfo2);
        arrayList1.add(classInfo3);
        arrayList1.add(classInfo4);
        arrayList1.add(classInfo5);

        Collections.sort(arrayList1, new Comparator<ClassInfo>() {
            @Override
            public int compare(ClassInfo o1, ClassInfo o2) {

                int diffAvgAge = o1.avgAge - o2.avgAge;
                int diffNum = o1.num - o2.num;
                if (diffAvgAge == 0) {
                    return diffNum;
                } else {
                    return diffAvgAge;
                }
            }
        });

        for (int i = 0; i < arrayList1.size(); i++) {
            System.out.println(arrayList1.get(i).avgAge + " " + arrayList1.get(i).num);
        }
    }

}
