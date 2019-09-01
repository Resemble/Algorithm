package tenth;

import java.util.ArrayList;
import java.util.Arrays;
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

    public List<List<Integer>> permuteUnique2(int[] nums) {
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



    /** 解法二 */
    List<List<Integer>> list;
    public List<List<Integer>> permuteUnique(int[] nums) {
        list = new ArrayList<>();
        Arrays.sort(nums);
        List<Integer> ll = new ArrayList<>();
        boolean[] flag = new boolean[nums.length];
        dfs(ll, nums, flag, 0);
        return list;
    }

    private void dfs(List<Integer> ll, int[] nums, boolean[] flag, int len) {
        if(len == nums.length) {
            list.add(new ArrayList<>(ll));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (flag[i]) {
                continue;
            }
            /** i-1和i的值相等，且i-1没被用过（之后可能会被用就产生重复） */
            if (i > 0 && nums[i - 1] == nums[i] && flag[i - 1] == false) {
                continue;
            }
            ll.add(nums[i]);
            flag[i] = true;
            dfs(ll, nums, flag, len + 1);
            ll.remove(ll.size() - 1);
            flag[i] = false;
        }
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
