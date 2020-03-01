package tenth;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package tenth
 * @Description: 合并两个有序数组
 * @date 2020-03-01 16:53
 */
public class MergeSortArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int j = m - 1;
        int k = n - 1;
        for (int i = m + n - 1; i >= 0; i--) {
            if ((j >= 0 && k >= 0 && nums1[j] >= nums2[k]) || (j >= 0 && k < 0)) {
                nums1[i] = nums1[j];
                j--;
            } else if (k >= 0){
                nums1[i] = nums2[k];
                k--;
            }
        }
    }

}
