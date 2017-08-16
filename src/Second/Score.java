package Second;

import java.util.ArrayList;

/**
 * @author ranran
 * @version V1.0
 * @Title:
 * @Package Second
 * @Description:在某射击场有N个靶，每个靶上都有一个分数，存在score数组中。击中第i个靶的得分为score[left] * score[i] * score[right]，同时原left和right两个靶变为相邻的靶。其中得分为0的靶是不能射击的，当left不存在或者
 * 不能射击时，得分为 score[i] * score[right]，同理right也遵循此规则; 当left和right都不存在或者不能射击时，得分
 * 为score[i]。请计算出击中所有能射击的靶，最多能得多少分？
 * 暴力破解 数组长度大于12超时，参考 MaxCoinsSolution o^3的做法
 * @date 2017/8/14 20:16
 */
public class Score {

    public static int scoreTotal = 0;

    public static int getScoreTotal(ArrayList<Integer> arrayList, int index, int scoreMax) {
//        ArrayList<Integer> temp = new ArrayList<>();
//        temp.addAll(arrayList);
//        temp.remove(new Integer(0));
        if (arrayList.isEmpty()) {
            return scoreMax;
        }

        if (arrayList.size() == 1) {
            scoreMax += arrayList.get(index);
        } else if (index == 0) {
            scoreMax += arrayList.get(index) * arrayList.get(index + 1);
        } else if (index == (arrayList.size() - 1)) {
            scoreMax += arrayList.get(index) * arrayList.get(index - 1);
        } else {
            scoreMax += arrayList.get(index) * arrayList.get(index - 1) * arrayList.get(index + 1);
        }
        arrayList.remove(index);
//        System.out.println("----------- scoreMax:" +scoreMax);
        int tempScore = scoreMax;
        for (int i = 0; i < arrayList.size(); i++) {
            // 竞争一个最大值
            ArrayList<Integer> temp2 = new ArrayList<>();
            temp2.addAll(arrayList);
//            System.out.println("************ i:" + i);
            int maxValue = getScoreTotal(temp2, i, tempScore);
//            System.out.println("maxValue:" + maxValue);
            scoreMax = Math.max(scoreMax, maxValue);

        }
        return scoreMax;
    }

    public static int maxCoins(int[] nums) {
        // Write your code here
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
        }
        int scoreMax = 0;

        for (int i = 0; i < list.size(); i++) {
            ArrayList<Integer> temp = new ArrayList<>();
            temp.addAll(list);
            scoreMax = getScoreTotal(temp, i, scoreMax);
            System.out.println("scoreMax:" + scoreMax);
            scoreTotal = Math.max(scoreTotal, scoreMax);
            scoreMax = 0;
        }
        return scoreTotal;
    }

    public static void main(String[] args) {
//        int[] nums = {35,16,83,87,84,59,48,41,20,54}; // 1849648
        int[] nums = {2,4,8,4,0,7,8,9,1,2,4,7,1,7,3};
        System.out.println(maxCoins(nums));
//        ArrayList<Integer> list = new ArrayList<>();
//
//
//        list.add(4);
//        list.add(1);
//        list.add(5);
//        list.add(10);
//
//        int scoreMax = 0;
//
//        for (int i = 0; i < list.size(); i++) {
//            ArrayList<Integer> temp = new ArrayList<>();
//            temp.addAll(list);
//            scoreMax = getScoreTotal(temp, i, scoreMax);
////            System.out.println("scoreMax:" + scoreMax);
//            scoreTotal = Math.max(scoreTotal, scoreMax);
//            scoreMax = 0;
//        }
//        System.out.println(scoreTotal);


    }


}
