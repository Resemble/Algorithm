package eighth;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package eighth
 * @Description:
 * @date 2019-05-26 14:46
 */
public class AtoiSolution {

    /**
     * @param str: A string
     * @return: An integer
     */
    public int atoi(String str) {
        // write your code here

        if ("".equals(str) || "0".equals(str)) {
            return 0;
        }

        int max = Integer.MAX_VALUE;
        String maxString = "" + max;
        boolean isPositive = false;
        int result;
        str = str.trim();
        if (str.charAt(0) == '-') {
            isPositive = false;
            str = str.substring(1);
        } else if (str.charAt(0) == '+') {
            isPositive = true;
            str = str.substring(1);
        } else {
            isPositive = true;
        }

        if ("".equals(str)) {
            return 0;
        }

        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                if (i != 0) {
                    str = str.substring(0, i);
                    break;
                } else {
                    return 0;
                }
            }
        }

        if (str.length() < maxString.length()) {
            result = Integer.parseInt(str);
        } else if (str.length() > maxString.length()) {
            if (isPositive) {
                return Integer.MAX_VALUE;
            } else {
                return Integer.MIN_VALUE;
            }
        } else {
            for (int i = 0; i < str.length(); i++) {
                if (Character.getNumericValue(str.charAt(i)) > Character.getNumericValue(maxString.charAt(i))) {
                    if (isPositive) {
                        return Integer.MAX_VALUE;
                    } else {
                        return Integer.MIN_VALUE;
                    }
                }
            }
        }
        result = Integer.parseInt(str);
        if (isPositive) {
            return result;
        } else {
            return -result;
        }
    }

    public static void main(String[] args) {
        System.out.println("0123".substring(0));
    }

}
