package tenth;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package tenth
 * @Description:
 * @date 2019-07-13 18:05
 */
public class RotatedDigitsSolution {

    public int rotatedDigits(int N) {
        int count = 0;
        for (int i = 1; i <= N; i++) {
            int num = i;
            Boolean changed = false;
            while(num > 0) {
                int rem = num % 10;
                if (rem == 3 || rem == 4 || rem == 7) {
                    break;
                }
                changed = rem == 2 || rem == 5 || rem == 6 || rem == 9 || changed;
                num = num / 10;
            }
            if (changed && num == 0) {
                count++;
            }
        }
        return  count;
    }

    public static void main(String[] args) {
        RotatedDigitsSolution solution = new RotatedDigitsSolution();
        System.out.println(solution.rotatedDigits(10));
    }

}
