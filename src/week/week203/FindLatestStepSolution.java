package week.week203;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package week.week203
 * @Description:
 * @date 2020-08-23 11:05
 */
public class FindLatestStepSolution {

    public int findLatestStep(int[] arr, int m) {
        if (m == arr.length) {
            return arr.length;
        }
        char[] curChar = new char[arr.length];
        for (int i = 0; i < curChar.length; i++) {
            curChar[i] = '1';
        }
        int cnt1 = arr.length;
        List<List> arrayList = new ArrayList<>();
        List<List> arrayList2 = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        tempList.add(0);
        tempList.add(arr.length - 1);
        arrayList.add(tempList);
        for (int i = arr.length - 1; i >= 0; i--) {
            cnt1--;
            if (cnt1 < m) {
                return -1;
            }
            int curIndex = arr[i] - 1;
            for (int j = 0; j < arrayList.size(); j++) {
                tempList = arrayList.get(j);
                int interval = tempList.get(1) - tempList.get(0) + 1;
                if (interval == m) {
                    return i;
                } else if (interval > m) {
                    if (curIndex <= tempList.get(1) && curIndex >= tempList.get(0)) {
                        if (tempList.get(1) - curIndex > m) {
                            List<Integer> temp1 = new ArrayList<>();
                            temp1.add(curIndex + 1);
                            temp1.add(tempList.get(1));
                            arrayList2.add(temp1);
                        } else if (tempList.get(1) - curIndex == m) {
                            return i;
                        }
                        if (curIndex - tempList.get(0) > m) {
                            List<Integer> temp1 = new ArrayList<>();
                            temp1.add(tempList.get(0));
                            temp1.add(curIndex - 1);
                            arrayList2.add(temp1);
                        } else if (curIndex - tempList.get(0) == m) {
                            return i;
                        }

                    } else {
                        arrayList2.add(tempList);
                    }

                }
            }
            arrayList = new ArrayList<>(arrayList2);
            arrayList2 = new ArrayList<>();
        }
        return -1;
    }

    public boolean findLatest(char[] curChar, int m) {
        int cnt = 0;
        for (int i = 0; i < curChar.length; i++) {
            if (i == curChar.length - 1) {
                if (curChar[i] == '1') {
                    cnt = cnt + 1;
                }
                if (cnt == m) {
                    return true;
                }
            } else {
                if (curChar[i] == '1') {
                    cnt = cnt + 1;
                } else {
                    if (cnt == m) {
                        return true;
                    }
                    cnt = 0;
                }
            }
        }
        return false;
    }

}
