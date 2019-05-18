package ninth;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package ninth
 * @Description:
 * @date 2019-05-18 11:10
 */
public class ReplaceBlankSolution {

    /*
     * @param string: An array of Char
     * @param length: The true length of the string
     * @return: The true length of new string
     */
    public int replaceBlank(char[] string, int length) {
        // write your code here
        if (string == null) {
            return 0;
        }
        int newLength = length;
        for (int i = 0; i < string.length; i++) {
            if (string[i] == ' ') {
                newLength = newLength + 2;
            }
        }
        if (newLength == length) {
            return newLength;
        }
        // %20
        for (int i = newLength - 1; i >= 0; i--) {
            length = length - 1;
            if (string[length] == ' ') {
                string[i] = '0';
                string[i - 1] = '2';
                string[i - 2] = '%';
                i = i - 2;
            } else {
                string[i] = string[length];
            }
        }
        return newLength;
    }

    public static void main(String[] args) {
        ReplaceBlankSolution solution = new ReplaceBlankSolution();
        solution.replaceBlank(null, 0);
    }
}
