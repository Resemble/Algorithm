package ninth;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package ninth
 * @Description:
 * @date 2019/4/13 9:43 AM
 */
public class RemoveDuplicatesSolution {

    public int removeDuplicates(int[] nums) {
        // write your code here
        if (nums.length == 0) {
            return 0;
        }
        int slowIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[slowIndex] != nums[i]) {
                slowIndex++;
                nums[slowIndex] = nums[i];
            }
        }
        return slowIndex + 1;
    }

    public static void main(String[] args) {
        RemoveDuplicatesSolution removeDuplicatesSolution = new RemoveDuplicatesSolution();
        int[] nums = {-14,-14,-13,-13,-13,-13,-13,-13,-13,-12,-12,-12,-12,-11,-10,-9,-9,-9,-8,-7,-5,-5,-5,-5,-4,-3,-3,-2,-2,-2,-2,-1,-1,-1,-1,-1,0,1,1,1,1,2,2,2,3,3,3,4,4,4,4,5,5,5,6,6,6,6,7,8,8,8,9,9,9,10,10,10,11,11,11,12,12,12,13,14,14,14,14,15,16,16,16,18,18,18,19,19,19,19,20,20,20,21,21,21,21,21,21,22,22,22,22,22,23,23,24,25,25};
        int[] result = {-14,-13,-12,-11,-10,-9,-8,-7,-5,-4,-3,-2,-1,0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,18,19,20,21,22,23,24,25};
        System.out.println(nums.length);
        System.out.println(result.length);
        System.out.println(removeDuplicatesSolution.removeDuplicates(nums));
    }

}
