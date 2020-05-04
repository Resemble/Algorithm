package tenth;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package tenth
 * @Description: 1248. 统计「优美子数组」
 * @date 2020-05-04 15:51
 */
public class NumberOfSubarraysSolution {

    /** 前缀和解法 */
    public int numberOfSubarrays(int[] nums, int k) {
        // 数组 prefixCnt 的下标是前缀和（即当前奇数的个数），值是前缀和的个数
        int[] prefixCnt = new int[nums.length + 1];
        // 多算一个 1
        prefixCnt[0] = 1;
        // 遍历原数组，计算当前的前缀和，统计到 prefixCnt 数组中
        // 并且在 res 中累加上与当前前缀和差值为 k 的前缀和的个数
        int res = 0, index = 0;
        for (int num : nums) {
            /** num & 1 奇数则为1 */
//            index += num & 1;
            if (num % 2 == 1) {
                index++;
            }
            /** sum:0,1,2,3 prefixCnt[sum] 记录前面有多少个数 */
            prefixCnt[index]++;
            if (index >= k) {
                res += prefixCnt[index - k];
                System.out.println("res:" + res);
            }
        }
//        for (int i = 0; i < prefixCnt.length; i++) {
//            System.out.println("prefixCnt[" + i + "]:" + prefixCnt[i]);
//        }
        return res;
    }



        /** 滑动窗口解法 */
    public int numberOfSubarrays3(int[] nums, int k) {
        List<Integer> oddList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & 1) == 1) {
                oddList.add(i);
            }
        }
        if (oddList.size() < k) {
            return 0;
        }
        int cnt = 0;
        int leftCnt;
        int rightCnt;
        int lastLeft = 0;
        int j;
        for (int i = 0; i + k - 1 < oddList.size(); i++) {
            // 左边的个数
            j = i + k - 1;
            leftCnt = oddList.get(i) - lastLeft;
            if (i == 0) {
                leftCnt = leftCnt + 1;
            }
            lastLeft = oddList.get(i);
            if (j == oddList.size() - 1) {
                rightCnt = nums.length - oddList.get(j);
            } else {
                rightCnt = oddList.get(j + 1) - oddList.get(j);
            }

            cnt = cnt + leftCnt * rightCnt;
        }
        return cnt;
    }



    public int numberOfSubarrays2(int[] nums, int k) {
        int cntOfSubarrays = 0;
        int cnt;
        for (int i = 0; i < nums.length; i++) {
            cnt = 0;
            for (int j = i; j < nums.length; j++) {
                if (nums[j] % 2 == 1) {
                    cnt++;
                    if (cnt > k) {
                        break;
                    } else if (cnt == k) {
                        cntOfSubarrays++;
                    }
                } else {
                    if (cnt == k) {
                        cntOfSubarrays++;
                    }
                }
            }
        }
        return cntOfSubarrays;
    }

    public static void main(String[] args) {
//        [1,1,2,1,1]
//        3
        int[] nums = new int[] {2, 2, 2, 1, 2, 2, 1, 2, 2, 2};
        int k = 2;
//
//        int[] nums = new int[] {1,1,2,1,1};
//        int k = 3;

        NumberOfSubarraysSolution solution = new NumberOfSubarraysSolution();
        System.out.println(solution.numberOfSubarrays(nums, k));

    }

}
