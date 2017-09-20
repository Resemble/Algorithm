package Sixth;

/**
 * @author ranran
 * @version V1.0
 * @Title:
 * @Package Sixth
 * @Description:
 * @date 2017/9/20 10:32
 */
public class Test {

    public static void main(String[] args) {
        String string = "5:4|7";
        String[] tempString = string.split(":");
        int valRoot = Integer.parseInt(tempString[0]);
        String[] temp2 = tempString[1].split("\\|");
        int left = Integer.parseInt(temp2[0]);
        int right = Integer.parseInt(temp2[1]);
        System.out.println(valRoot);
        System.out.println(left);
        System.out.println(right);
    }

}
