package Third;

/**
 * @author ranran
 * @version V1.0
 * @Title:
 * @Package Third
 * @Description:
 * @date 2017/8/23 20:20
 */
public class Test {

    public static void main(String[] args) {
        String string = "string";
        for (int i = 0; i < string.length(); i++) {
            System.out.println(string.charAt(i));
        }
        System.out.println(string.substring(2));
        System.out.println(string.substring(2,5));
        System.out.println(string.substring(2,6));
    }

}
