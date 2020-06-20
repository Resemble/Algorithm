package package11;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package package11
 * @Description: 加一
 * @date 2020-06-20 17:33
 */
public class PlusOneSolution {

    public int[] plusOne(int[] digits) {
        int temp = 0;
        int tempSum;
        digits[digits.length - 1] = digits[digits.length - 1] + 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            tempSum = digits[i] + temp;
            digits[i] = tempSum % 10;
            temp = tempSum / 10;
        }
        if (temp == 0) {
            return digits;
        }
        int[] result = new int[digits.length + 1];
        result[0] = temp;
        for (int i = 0; i < digits.length; i++) {
            result[i + 1] = digits[i];
        }
        return result;
    }

}
