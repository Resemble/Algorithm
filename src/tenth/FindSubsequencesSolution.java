package tenth;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package tenth
 * @Description: 491. 递增子序列
 * @date 2019-09-15 15:05
 */
public class FindSubsequencesSolution {

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        search(nums, 0, new ArrayList<>());
        return result;
    }


    public void search(int[] nums, int index, List<Integer> subSequence) {

        if (subSequence.size() >= 2) {
            result.add(new ArrayList<>(subSequence));
        }
        for (int i = index; i < nums.length; i++) {
            if (!subSequence.isEmpty() && subSequence.get(subSequence.size() - 1) > nums[i]) {
                continue;
            }
            boolean isRepeat = false;
            for (int j = index; j < i; j++) {
                if (nums[j] == nums[i]) {
                    isRepeat = true;
                    break;
                }
            }
            if (isRepeat) {
                continue;
            }
            subSequence.add(nums[i]);
            search(nums, i + 1, subSequence);
            subSequence.remove(subSequence.size() - 1);
        }
    }

    public static void main(String[] args) {
        FindSubsequencesSolution solution = new FindSubsequencesSolution();
//        int[] nums = {-100,-99,-98,-97,-96,-96};
        int[] nums = {4,6,7,7};
        List<List<Integer>> result = solution.findSubsequences(nums);
        for (int i = 0; i < result.size(); i++) {
            for (int j = 0; j < result.get(i).size(); j++) {
                System.out.print(result.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

}
