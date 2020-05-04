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


    public int numberOfSubarrays(int[] nums, int k) {
        List<Integer> oddList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 1) {
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
