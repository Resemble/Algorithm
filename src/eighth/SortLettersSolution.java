package eighth;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package eighth
 * @Description:
 * @date 2019/4/9 11:28 PM
 */
public class SortLettersSolution {

    /*
     * @param chars: The letter array you should sort by Case
     * @return: nothing
     */
    public void sortLetters(char[] chars) {
        // write your code here

        char temp;
        for (int i = 0, j = chars.length - 1; i < j;) {
            while (Character.isLowerCase(chars[i])) {
                i++;
                if (i >= j) {
                    return;
                }
            }
            while (Character.isUpperCase(chars[j])) {
                j--;
                if (i >= j) {
                    return;
                }
            }
            temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
        }

    }


}
