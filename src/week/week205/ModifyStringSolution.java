package week.week205;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package week.week205
 * @Description:
 * @date 2020-09-06 10:31
 */
public class ModifyStringSolution {

    public String modifyString(String s) {
        StringBuilder result = new StringBuilder();
        Character lastChar = 'a';
        Character nextChar = 'b';
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '?') {
                if (i != s.length() - 1) {
                    if (s.charAt(i + 1) != '?') {
                        nextChar = s.charAt(i + 1);
                    }
                    if (i != 0) {
                        lastChar = result.charAt(i - 1);
                    }
                }
                Character temp = getOneChar(lastChar, nextChar);
                result.append(temp);
            } else {
                result.append(s.charAt(i));
            }
            lastChar = result.charAt(i);
        }
        return result.toString();
    }

    public Character getOneChar(Character lastChar, Character nextChar) {
        for (int i = 97; i <= 122; i++) {
            Character temp = (char) i;
            if (temp != lastChar && temp != nextChar) {
                return temp;
            }
        }
        return lastChar;
    }

    public static void main(String[] args) {
        for (int i = 97; i <= 122; i++) {
            System.out.println((char) i);
        }
        System.out.println(Integer.valueOf('a'));

    }

}
