package Second;

/**
 * @author ranran
 * @version V1.0
 * @Title:
 * @Package Second
 * @Description:
 * @date 2017/7/8 10:48
 */
public class Test {

    public static void main(String[] args) {

        double d1 = 2.333000;
        double d2 = 2.3330;

        if (d1 == d2) {
            System.out.println("d1 == d2");
        } else {
            System.out.println("d1 != d2");
        }

        String d3 = "2.333000";
        String d4 = "2.3330";

        if (d3 == d4) {
            System.out.println("d3 == d4");
        } else {
            System.out.println("d3 != d4");
        }

        if (d3.equals(d4)) {
            System.out.println("d3.equals(d4)");
        } else {
            System.out.println("!d3.equals(d4)");
        }



    }

}
