package First;

/**
 * @author ranran
 * @version V1.0
 * @Title:
 * @Package First
 * @Description: 如何删除字符串中重复的字符
 *  String类型传递是值传递，char[]类型传递是引用传递
 * @date 2017/8/1 17:33
 */
public class RemoveDuplicateFromStringSolution {

    public static String removeDuplicate(String str) {
        char[] chars = str.toCharArray();
        byte[] bytes = str.getBytes();
        int len = bytes.length;
        int[] flags = new int[256];
        for (int i = 0; i < 256; i++) {
            flags[i] = 0;
        }
        for (int i = 0; i < len; i++) {
            if (flags[bytes[i]] == 0) {
                flags[bytes[i]] = 1;
            } else {
                chars[i] = '\0';
            }
        }

        int index = 0;
        for (int i = 0; i < len; i++) {
            if (chars[i] != '\0') {
                chars[index] = chars[i];
                index++;
            }
        }
        return new String(chars, 0, index);
    }

    public static void main(String[] args) {
        String string = "fsdfsdfsd2332423fd";
        String result = removeDuplicate(string);
        System.out.println(string);
        System.out.println(result);
    }

}
