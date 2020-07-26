package week.week199;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package week.week199
 * @Description:
 * @date 2020-07-26 10:37
 */
public class MinFlipsSolution {


    public int minFlips(String target) {
        int pre = 0;
        int ans = 0;
        for (int i = 0; i < target.length(); i++) {
            int cur = target.charAt(i) - '0';
            if (pre != cur) {
                ans++;
//                System.out.println("pre:" + pre);
//                System.out.println("cur:" + cur);
                pre = cur;
            }
        }
        return ans;
    }


    public int minFlips2(String target) {
        int cnt = 0;

        if (target.charAt(target.length() - 1) == '0') {
            cnt = cnt + 1;
        }
        for (int i = target.length() - 1; i > 0; i--) {
            if (target.charAt(i) == '1' && target.charAt(i - 1) == '0') {
                cnt = cnt + 2;
            }
        }
        if (target.charAt(0) == '1') {
            return cnt + 1;
        } else {
            return cnt - 1;
        }
    }

    public static void main(String[] args) {
        MinFlipsSolution solution = new MinFlipsSolution();
        System.out.println(solution.minFlips( "101110"));
    }


}
