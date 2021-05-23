package package12;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package package12
 * @Description: https://leetcode-cn.com/problems/compare-version-numbers/ 165. 比较版本号
 * @date 5/23/21 3:39 PM
 */
public class CompareVersionSolution {

    public int compareVersion(String version1, String version2) {
        String[] version1Array = version1.split("\\.");
        String[] version2Array = version2.split("\\.");
        int version1Num;
        int version2Num;
        for (int i = 0; i < version1Array.length || i < version2Array.length; i++) {
            if (i < version1Array.length) {
                version1Num = Integer.parseInt(version1Array[i]);
            } else {
                version1Num = 0;
            }
            if (i < version2Array.length) {
                version2Num = Integer.parseInt(version2Array[i]);
            } else {
                version2Num = 0;
            }
            if (version1Num > version2Num) {
                return 1;
            } else if (version1Num < version2Num) {
                return -1;
            }
        }
        return 0;
    }

}
