package week.week204;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package week.week204
 * @Description:
 * @date 2020-08-30 10:31
 */
public class ContainsPatternSolution {

    public boolean containsPattern(int[] arr, int m, int k) {
        if (arr.length < m) {
            return false;
        }
        StringBuilder arrStr = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            arrStr.append(arr[i]);
        }
        for (int i = 0; i < m; i++) {
            String lastTempStr = "";
            int cnt = 0;
            for (int j = i; j <= arrStr.length() - m; j = j + m) {
                String tempStr = arrStr.substring(j, j + m);
                if (tempStr.equals(lastTempStr)) {
                    cnt++;
                } else {
                    lastTempStr = tempStr;
                    cnt = 1;
                }

                if (cnt >= k) {
                    return true;
                }
            }
        }
        return false;
    }

}
