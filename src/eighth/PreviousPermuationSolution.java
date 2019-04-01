package eighth;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package eighth
 * @Description:
 * @date 2019/3/31 3:07 PM
 */
public class PreviousPermuationSolution {

    /*
     * @param nums: A list of integers
     * @return: A list of integers that's previous permuation
     */
    public List<Integer> previousPermuation(List<Integer> nums) {
        // write your code here
        if (nums.size() == 1)
            return nums;
        List<Integer> sortNums = new ArrayList<>(nums);
        Collections.sort(sortNums);
        if (sortNums.equals(nums)) {
            Collections.reverse(nums);
            return nums;
        }


        List<Integer> result = new ArrayList<>();
        List<Integer> result2 = new ArrayList<>();
        boolean toBeChange = true;
        int descNum = 0;
        int indexOfDesc = 0;
        for (int i = nums.size() - 1; i >= 0; i--) {
            if (toBeChange) {
                result.add(nums.get(i));
                if (nums.get(i) < nums.get(i - 1)) {
                    descNum = nums.get(i - 1);
                    result2.add(descNum);
                    indexOfDesc = i - 1;
                    i = i - 1;
                    toBeChange = false;
                }
            } else {
                result2.add(nums.get(i));
            }
        }
        Collections.reverse(result2);
        Collections.sort(result, Collections.reverseOrder());
        int index = 0;
        for (int i = 0; i < result.size(); i++) {
            if (result.get(i) < descNum) {
                index = i + result2.size();
                break;
            }
        }
        result2.addAll(result);
        swapItem(result2, indexOfDesc, index);
        return result2;
    }

    public void swapItem(List<Integer> nums, int i, int j) {
        Integer temp = nums.get(i);
        nums.set(i, nums.get(j));
        nums.set(j, temp);
    }




    public static void main(String[] args) {
        // [3,1,2] -> [2,3,1]
        // [2,1,3] -> [1,3,2]
//        List<Integer> list3 = Arrays.asList(1, 3, 2, 3);
        List<Integer> list3 = Arrays.asList(2,1,1);
        PreviousPermuationSolution previousPermuationSolution = new PreviousPermuationSolution();
        System.out.println(previousPermuationSolution.previousPermuation(list3));

    }

}
