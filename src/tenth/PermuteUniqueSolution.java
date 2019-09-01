package tenth;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package tenth
 * @Description:
 * @date 2019-09-01 15:19
 */
public class PermuteUniqueSolution {

    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        dfs(nums, 0);
        return ans;
    }

    private void dfs(int[] nums, int cur) {
        if (cur == nums.length) {
            List<Integer> line = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                line.add(nums[i]);
            }
            ans.add(line);
        } else {
            for (int i = cur; i < nums.length; i++) {
                if (canSwap(nums, cur, i)) {
                    swap(nums, cur, i);
                    /** 递归解决了全排列的问题 */
                    dfs(nums, cur + 1);
                    swap(nums, cur, i);
                }
            }
        }
    }

    private boolean canSwap(int nums[], int begin, int end) {
        for (int i = begin; i < end; i++) {
            if (nums[i] == nums[end]) {
                return false;
            }
        }
        return true;
    }

    private void swap(int nums[], int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        ArrayList<Integer> arrayList2 = new ArrayList<>();
        arrayList2.add(1);
        if (arrayList.equals(arrayList2)) {
            System.out.println("equal");
        }
    }

}
